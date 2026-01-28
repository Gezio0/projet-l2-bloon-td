package game;

import org.junit.Test;

import game.board.*;
import game.path.*;
import game.exception.*;
import java.util.*;

public class gameTest {



@Test
public void getBalloonsTest(){
    Board board = new ClassicalBoard(10, 10);
    Game game = new Game(board,10);
    Set<Balloon> balloons =game.getBalloons()
    assertEquals(balloons.size(),10);
    for(Balloon b : balloons){
        assertTrue(b instanceof Balloon);
    }
}

@Test 


}
