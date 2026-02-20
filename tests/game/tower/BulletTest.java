package game.tower;
import java.util.*;
import game.balloon.*;
import game.path.*;
import game.exception.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class BulletTest {
    private List<Effect> effects;
    private Bullet bullet;
    private Set<Balloon> balloons;
    private List<Path> paths;
    private Tower tower;
    @BeforeEach
    public void before() throws TooMuchPathsException,NoNextCellException{
        this.effects = new ArrayList<>();
        this.effects.add(new Damage("damage",0, false, 1));
        this.bullet = new Bullet(1, 0, this.effects);

        this.balloons = new HashSet<>();
        
        CellPath cp =new CellPath(new Cell(10, 0));
        for(int i=10;i>=0;i--){
            cp =new CellPath(new Cell(i,0),cp);
        }
        Path p = new Path(cp);
        this.paths =new ArrayList<>();
        this.paths.add(p);
        this.tower = new Tower(2, 80, this.bullet, 5,new Cell(3,1), this.paths);

        for(int i = 0;i<5;i++){
            this.balloons.add(new Balloon(10, 2, cp));
        }
    }
    @Test
    public void getAreaTest(){
        assertEquals(this.bullet.getArea(),1);
    }
    @Test
    public void getTimeLeftTest(){
        assertEquals(this.bullet.getTimeLeft(),0);
    }

    @Test
    public void setBalloonsBeforeSetTest(){
        assertEquals(bullet.getBalloons(),null);
    }
    @Test
    public void setBalloonsAfterSetTest(){
        bullet.setBalloons(this.balloons);
        assertEquals(5,this.bullet.getBalloons().size());
        assertTrue(this.balloons.equals(this.bullet.getBalloons()));
    }
    @Test
    public void addTargetBeforeTest(){
        assertEquals(null, this.bullet.getTarget());
    }

    @Test
    public void addTargetAfterTest(){
        Balloon b = new Balloon(0, 0, null);
        this.bullet.addTarget(b);
        assertEquals(b, this.bullet.getTarget());
    }

}
