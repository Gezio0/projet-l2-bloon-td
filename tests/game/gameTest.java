package game;

import org.junit.*;
import org.junit.Assert.*;
import game.balloon.*;
import game.board.*;
import game.exception.NoNextCellException;
import game.exception.TooMuchPathsException;
import game.path.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

public class gameTest {



@Test
public void getBalloonsTest() throws TooMuchPathsException,NoNextCellException{
    Board board = new ClassicalBoard(10, 10);
    
    board.initPath();
    Game game = new Game(board,10);
    
    Set<Balloon> balloons =game.getBalloons();
    assertEquals(balloons.size(),10);
    
    Game game2 = new Game(board,50);
    Set<Balloon> balloons2 =game2.getBalloons();
    assertEquals(balloons2.size(),50);
    
    
    
}

@Test 
public void isFinishedTest()throws TooMuchPathsException,NoNextCellException{
    Board board = new ClassicalBoard(10, 10);
    board.initPath();
    Game emptyGame = new Game(board,0);
    assertTrue(emptyGame.isFinished());
    Game game = new Game(board,10);
    assertFalse(game.isFinished());

}

}
