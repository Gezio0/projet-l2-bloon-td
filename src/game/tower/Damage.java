package game.tower;
import game.balloon.*;

public class Damage extends Effect{
    protected int damage;
    public Damage(String name, int duration, boolean stackable,int damage){
        super(name,duration,stackable);
        this.damage = damage;
    }

    /*method that applies the effect Damage to the balloon list and removes the effect when its durability reaches 0  */
    public void applyEffect(int clock){
        if (this.duration >= 0){
            for(Balloon b : this.balloons){
                b.decreaseResistance(this.damage);
                System.out.println("Balloon "+ b+ " received "+ this.damage+ " damages");
                if(b.isDead()){
                    System.out.println("Balloon "+ b+ " has been destroyed");
                }
            }
        }
        else{
            this.destroy();
        }
    }

    /**Copy a Damage effect in order to have new bullets */
    @Override
    public Effect copy(){
        return new Damage(this.name,this.duration,this.stackable, this.damage);
    }
}