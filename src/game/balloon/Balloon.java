package game.balloon;

import game.exception.NoNextCellException;
import game.path.*;
import game.*;


/**Represents a bloon td game balloon, moving on the board from the start
 * up to the end of a path
 */
public class Balloon extends GameObject {
    /**represents the balloon hp */
    protected int resistance ;
    /**Balloon speed : the hight clockSpeed is, the lower balloon speed is */
    protected int clockSpeed;
    /**the current cell where the balloon is */
    protected CellPath cell ;
    /**the original balloon speed */
    protected int originalSpeed ;
    /**time multiplier to manage the balloon speed */
    protected int timeMultiplier ;

    /**
     * Initialize the balloon with its speed, resistance and cell
     * @param clockSpeed balloon speed
     * @param resistance balloon hp
     * @param cell balloon current cell
     */
    public Balloon(int clockSpeed,int resistance, CellPath cell){
        super();
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
     * Get the original speed
     * @return the original speed
     */
    public int getOriginalSpeed(){
        return this.originalSpeed;
    }

    /**
     * Get the time multiplier
     * @return the time multiplier
     */
    public int getTimeMultipier(){
        return this.timeMultiplier;
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
     * @param clock the current clock of the game (right now)
     * @return
     */
    public boolean onClock(int clock){
        if (clock%this.clockSpeed == 0){
            try {
                moveForward();
            } catch (Exception e){
                System.out.println(e);
            }
            return true;
        }
        if(this.isFinished()){
            System.out.println("Ballon : " + this.toString() + " destroyed at clock : " + clock);
            destroy();
        }
        return false;
    }

    /**
     * decrease balloon resistance depending on a turret shot damage
     * @param damage damage dealt to the balloon
     */
    public void decreaseResistance(int damage){
        this.resistance = this.resistance - damage;
    }


    /**
     * return true if the balloon is dead (resistance <= 0)
     * @return balloon state (true = dead, false = alive)
     */
    public boolean isDead(){
        return this.resistance <= 0;
    }

    /**
     * Shows the resistance, speed and x and y coordinates of the current cell
     * @return a display of the main balloon informations
     */
    @Override
    public String toString(){
        return "resistance : " + this.resistance + " speed : " + this.clockSpeed + " cell , x: " + this.cell.getCell().getX() + " y: " + this.cell.getCell().getY() + " id : " + this.getId();
    }




}
