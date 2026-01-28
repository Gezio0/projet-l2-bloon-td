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
    Set<Balloon> balloons =game.getBalloons();
    assertEquals(balloons.size(),10);
    for(Balloon b : balloons){
        assertTrue(b instanceof Balloon);
    }
    Game game2 = new Game(board,10);
    Set<Balloon> balloons2 =game2.getBalloons();
    assertEquals(balloons2.size(),50);
    for(Balloon b : balloons2){
        assertTrue(b instanceof Balloon);
    }
    
}

@Test 
public void isFinished(){
    Board board = new ClassicalBoard(10, 10);
    Game emptyGame = new Game(board,0);
    assertTrue(emptyGame.isFinished());
    Game Game = new Game(board,10);
    assertFalse(Game.isFinished());
}

}
