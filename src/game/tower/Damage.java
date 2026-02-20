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

    /*method that applies the effect Damage to the balloon list and removes the effect when its durability reaches 0  */
    public void applyEffect(){
        if (this.duration >= 0){
            for(Balloon b : this.balloons){
                b.decreaseResistance(this.damage);
                System.out.println("Le ballon "+ b+ " a reçu "+ this.damage+ " dégats");
                if(b.isDead()){
                    System.out.println("Le ballon "+ b+ " est détruit");
                }
            }
        }
        else{
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

    /**Copy a Damage effect in order ton have new bullets */
    @Override
    public Effect copy(){
        return new Damage(this.name,this.duration,this.stackable, this.damage);
    }
}