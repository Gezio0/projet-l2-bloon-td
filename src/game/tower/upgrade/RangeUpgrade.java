package game.tower.upgrade;

/**
 * A class managing Range upgrades
 */
public class RangeUpgrade extends Upgrade{
    /**the value to multiply a tower range */
    protected double multiplier;
    
    /**
     * Builds a RangeUpgrade class with a multiplier
     * @param multiplier
     */
    public RangeUpgrade(int cost,double multiplier){
        super(cost);
        this.multiplier = multiplier;
    }

    /**
     * Get the range multiplier.
     * @return the range multiplier.
     */
    @Override
    public double getRangeMultiplier(){
        return this.multiplier;
    }
}
