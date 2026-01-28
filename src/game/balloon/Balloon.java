package game.balloon;

import game.exception.NoNextCellException;
import game.path.*;


/**Represents a bloon td game balloon, moving on the board from the start
 * up to the end of a path
 */
public class Balloon {
    /**represents the balloon hp */
    protected int resistance ;
    /**Balloon speed : the hight clockSpeed is, the lower balloon speed is */
    protected int clockSpeed;
    /**the current cell where the balloon is */
    protected CellPath cell ;


    /**
     * Initialize the balloon with its speed, resistance and cell
     * @param clockSpeed balloon speed
     * @param resistance balloon hp
     * @param cell balloon current cell
     */
    public Balloon(int clockSpeed,int resistance, CellPath cell){
        this.clockSpeed = clockSpeed;
        this.resistance = resistance;
        this.cell = cell;
    }

    /**
     * Get the balloon speed 
     * @return the balloon speed (lower value returned = higher speed in the game)
    */
    public int getSpeed(){
        return this.clockSpeed;
    }

    /**
     * Get the balloon hp
     * @return the remaining resistance
     */
    public int getResistance(){
        return this.resistance;
    }

    /**
     * Get the balloon current cell
     * @return the current cell
     */
    public CellPath getCell(){
        return this.cell;
    }

    /**
     * Move the balloon to the next cell of its path
     * @throws NoNextCellException if there's no next cell
     */
    public void moveForward() throws NoNextCellException{
        this.cell = this.cell.getNextCell();
    }

    /**
     * return true if the balloon is on the last cell of its path
     * @return
     */
    public boolean isFinished(){
        return this.cell.isFinished();
    }

    /**
     * Move forward depending to the clock.
     * Example : 
     * if clockSpeed = 3 and clock = 1 then don't move forward and return false
     * if clockSpeed = 3 and clock = 3 then move forward and return true
     * if clockSpeed = 6 and clock = 3 then move forward and return true
     * @param clock
     * @return
     * @throws NoNextCellException
     */
    public boolean onClock(int clock) throws NoNextCellException{
        if (clock%this.clockSpeed == 0){
            moveForward();
            return true;
        }
        return false;
    }




}
