package game.tower;

import java.util.*;
import game.balloon.*;
import game.path.*;
import game.board.Board;
import game.board.ClassicalBoard;
import game.exception.TooMuchPathsException;
import game.exception.*;
import org.junit.jupiter.api.BeforeEach;

public class TowerTest {
    private List<Effect> effects;
    private List<Bullet> bullets;
    private Set<Balloon> balloons;
    private List<Path> paths;
    
    @BeforeEach
    public void before() throws TooMuchPathsException,NoNextCellException{
        this.effects = new ArrayList<>();
        this.bullets = new ArrayList<>();
        this.effects.add(new Damage("damage",0, false, 1));
        this.bullets.add(new Bullet(0, 0, effects));
        Board b = new ClassicalBoard(10, 10);
        this.paths = b.getPaths();
        for(int i=0; i<10;i++){
            this.balloons.add(Balloon)
        }
    }

}
