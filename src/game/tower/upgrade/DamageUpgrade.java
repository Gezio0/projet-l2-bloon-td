package game.tower.upgrade;

/**
 * A class managing damages upgrades
 */
public class DamageUpgrade extends Upgrade{
    /**the value to multiply a bullet damage */
    protected double multiplier;
    
    /**
     * Builds a DamageUpgrade class with a multiplier
     * @param multiplier
     */
    public DamageUpgrade(int cost,double multiplier){
        super(cost);
        this.multiplier = multiplier;
    }

    /**
     * Get the damage multiplier.
     * @return the damage multiplier.
     */
    @Override
    public double getDamageMultiplier(){
        return this.multiplier;
    }
}
