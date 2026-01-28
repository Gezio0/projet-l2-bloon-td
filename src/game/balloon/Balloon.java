package game.balloon;

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
     * @return
     */
    public int getResistance(){
        return this.resistance;
    }




}
