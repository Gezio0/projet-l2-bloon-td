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
            this.destroy();
        }
        

    }
}








slow 
set time a 2

pour resset set tme a 1


freeze 
set a 999
