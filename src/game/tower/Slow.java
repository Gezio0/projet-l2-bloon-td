package game.tower;
import game.GameObject;
import game.balloon.*;
import java.util.*;

public class Slow extends Effect{
    

    public Slow(String name, int duration, boolean stackable){
        super(name,duration,stackable);
    }

    /*method that applies the effect Slow (wich slow the balloon) to the balloon list and removes the effect when its durability reaches 0  */
    public void applyEffect(){
        if (this.duration >= 0){
            for (Balloon b: this.balloons){
                b.setTimeSlower(2);
            }
        }
        else{
            for (Balloon b: this.balloons){
                b.setTimeSlower(1);
            }
            this.destroy();
        }
    }

    /**method that allows the effect to be applied every clock cycle  
    * @return boolean true 
    */
    public boolean onClock(int clock){
        this.applyEffect();
        this.duration = this.duration - 1;
        return true;
    }
}

