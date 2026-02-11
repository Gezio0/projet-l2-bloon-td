package game.tower;
import game.GameObject;
import game.balloon.*;
import java.util.*;

public class Freeze extends Effect{
    

    public Freeze(String name, int duration, boolean stackable){
        super(name,duration,stackable);
    }

    public void applyEffect(){
        if (this.duration >= 0){
            for (Balloon b: this.balloons){
                b.setTimeSlower(999);
            }
        }
        else{
            for (Balloon b: this.balloons){
                b.setTimeSlower(1);
            }
            this.destroy();
        }
    }

    
}

