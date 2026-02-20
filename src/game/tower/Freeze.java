package game.tower;
import game.balloon.*;

public class Freeze extends Effect{
    

    public Freeze(String name, int duration, boolean stackable){
        super(name,duration,stackable);
    }

    /*method that applies the effect Freeze (wich stop the balloon) to the balloon list and removes the effect when its durability reaches 0  */
    public void applyEffect(int clock){
        if (this.duration >= 0){
            for(Balloon b:this.balloons){
                if(b.isDead()){
                    
                    continue; 
                }
                b.setTimeSlower(999);
                if (this.isFirstTick){
                    System.out.println("Balloon "+ b+ " is frozen for " + this.duration + " turn : " + clock);
                }
            }
            this.isFirstTick = false;
        }
        else{
            for (Balloon b: this.balloons){
                if (!b.isDead()) {
                    b.setTimeSlower(1);
                    System.out.println("Balloon "+ b + " is no longer frozen : " + clock);
                }
                
            }
            this.destroy();
            
        }
    }
    
    
    

    /**Copy a Freeze effect in order to have new bullets */
    @Override
    public Effect copy(){
        return new Freeze(this.name,this.duration,this.stackable);
    }
}

