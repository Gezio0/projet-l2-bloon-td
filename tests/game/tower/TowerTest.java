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
        Board b = new ClassicalBoard(10, 10);
        this.paths = b.getPaths();
        Random rng = new Random();
        for(int i=0; i<10;i++){
           
            int speed = rng.nextInt(40) + 10;
            this.balloons.add(new Balloon(speed,2,this.paths.getFirst().getFirstCell()));
        }
        this.tower = new Tower(10, 80, this.bullet, 5,new Cell(2,2), this.paths);

    }

    @Test
    public void getRangeTest(){
        assertEquals(this.tower.getRange(),10);
        
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
        assertEquals(this.tower.getCell(),new Cell(2,2));
    }
    @Test
    public void SameTowerCellTest(){
        assertTrue(this.tower.SameTowerCell(this.tower));
        assertFalse(this.tower.SameTowerCell(new Tower(0, 0, this.bullet, 0,new Cell(0,0), this.paths)));
    }



}
