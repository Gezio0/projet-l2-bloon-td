package game.tower;
import game.balloon.*;

public class Slow extends Effect{
    

    public Slow(String name, int duration, boolean stackable){
        super(name,duration,stackable);
    }

    /*method that applies the effect Slow (wich slow the balloon) to the balloon list and removes the effect when its durability reaches 0  */
    public void applyEffect(int clock){
        if (this.duration >= 0){
            for(Balloon b:this.balloons){
                if(b.isDead()){
                    continue; 
                }
                b.setTimeSlower(2);
                if (this.isFirstTick){
                    System.out.println("Balloon "+ b+ " is slowed for" + this.duration + " turn : " + clock);
                }
            }
            this.isFirstTick = false;
        }
        else{
             for (Balloon b: this.balloons){
                if (!b.isDead()) {
                    b.setTimeSlower(1);
                }
            }
            this.destroy();
        }
    }
    

    /**Copy a Slow effect in order to have new bullets */
    @Override
    public Effect copy(){
        return new Slow(this.name,this.duration,this.stackable);
    }
}

