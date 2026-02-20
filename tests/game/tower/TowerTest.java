package game.tower;

import java.util.*;
import game.balloon.*;
import game.path.*;
import game.board.Board;
import game.board.ClassicalBoard;
import game.exception.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TowerTest {
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


        CellPath cp =new CellPath(new Cell(10, 0));
        for(int i=10;i>=0;i--){
            cp =new CellPath(new Cell(i,0),cp);
        }
        Path p = new Path(cp);
        this.paths =new ArrayList<>();
        this.paths.add(p);

        Random rng = new Random();
        for(int i=0; i<5;i++){
           
            int speed = rng.nextInt(40) + 10;
            this.balloons.add(new Balloon(speed,2,this.paths.getFirst().getFirstCell()));
        }

        this.tower = new Tower(2, 80, this.bullet, 5,new Cell(3,1), this.paths);

    }

    @Test
    public void getRangeTest(){
        assertEquals(this.tower.getRange(),2);
        
    }
    @Test
    public void getCostTest(){
        assertEquals(this.tower.getCost(),80);
    }
    @Test
    public void getBulletTest(){
        assertEquals(this.tower.getBullet(),this.bullet);
    }
    @Test
    public void getReloadTimeTest(){
        assertEquals(this.tower.getReloadTime(),5);
    }
    @Test
    public void getCellTest(){
        assertEquals(this.tower.getCell(),new Cell(3,1));
    }
    @Test
    public void SameTowerCellTest(){
        assertTrue(this.tower.SameTowerCell(this.tower));
        assertFalse(this.tower.SameTowerCell(new Tower(0, 0, this.bullet, 0,new Cell(0,0), this.paths)));
    }
    @Test
    public void shootNotInRangeTest(){
        Balloon balloonTarget = new Balloon(10,2,this.paths.getFirst().getFirstCell());
        this.balloons.add(balloonTarget);
        List<Bullet> b = this.tower.shoot(this.balloons);
        assertEquals(b.size(),0);
    }
    




}
