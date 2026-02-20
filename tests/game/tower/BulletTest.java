package game.tower;
import java.util.*;
import game.balloon.*;
import game.path.*;
import game.exception.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class BulletTest {
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

    }
    
}
