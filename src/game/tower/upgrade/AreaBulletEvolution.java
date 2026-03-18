package game.tower.upgrade;

/**
 * A class managing area of effect upgrades
 */
public class AreaUpgrade extends Upgrade {
    /**the value to multiply a bullet area of effect */
    protected double multiplier;
    
    /**
     * Builds a AreaUpgrade class with a multiplier
     * @param multiplier
     */
    public AreaUpgrade(int cost,double multiplier){
        super(cost);
        this.multiplier = multiplier;
    }

    /**
     * Get the area of effect multiplier.
     * @return the area of effect multiplier.
     */
    @Override
    public double getAreaMultiplier(){
        return this.multiplier;
    }
    
}
