package game.tower.upgrade;

/**An abstract class that represent an upgrade in the game*/
public abstract class Upgrade {

    /*this upgrade's cost */
    protected int cost;

    /*Build an upgarde with the given cost */
    public Upgrade(int cost){
        this.cost = cost;
    }

    /**
     * Get the damage multiplier.
     * @return the damage multiplier, 0 if this upgrade does not concern Damages.
     */
    public double getDamageMultiplier(){
        return 0.0;
    }
    
    /**
     * Get the range multiplier.
     * @return the range multiplier, 0 if this upgrade does not concern range.
     */
    public double getRangeMultiplier(){
        return 0.0;
    }

    /**
     * Get the area of effect multiplier.
     * @return the aoe multiplier, 0 if this upgrade does not concern area of effect.
     */
    public double getAreaMultiplier(){
        return 0.0;
    }
}
