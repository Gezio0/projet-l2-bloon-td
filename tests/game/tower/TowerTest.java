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
        assertTrue(this.tower.getRange(),10);
        assertFalse(this.tower.getRange(),0);
        assertFalse(this.tower.getRange(),9);
        assertFalse(this.tower.getRange(),11);
    }
    public void getCostTest(){
        assertTrue(this.tower.getCost(),80);
    }
    

}
