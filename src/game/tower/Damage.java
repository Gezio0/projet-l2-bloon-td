package game.tower;
import game.GameObject;
import game.balloon.*;
import java.util.*;

public class Damage extends Effect{
    protected int damage;
    public Damage(String name, int duration, boolean stackable,int damage){
        super(name,duration,stackable);
        this.damage = damage;
    }

    public void applyEffect(){
        if (this.duration >= 0){
            for(Balloon b : this.balloons){
                b.decreaseResistance(this.damage);
                this.duration = this.duration - 1;
            }
        }
        else{
            this.destroy();
        }
    }

    public boolean onClock(){
        this.applyEffect();
        return true;
    }
}