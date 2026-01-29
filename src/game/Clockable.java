package game;
import game.board.*;
import game.path.*;
import game.balloon.*;
import game.exception.*;

/**
 * The interface that will manage the different actions of the objects that use the clock 
 */
public interface Clockable{

    /**
     * The method that verify if its the turn for an object to play
     */
    public boolean onClock(int clock) throws NoNextCellException;
}