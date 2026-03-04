package game.tower.upgrade;

import game.tower.Tower;

/**An abstract class that represent an upgrade in the game*/
public abstract class Upgrade {

    /*this upgrade's cost */
    protected int cost;

    /*Build an upgarde with the given cost */
    public Upgrade(int cost){
        this.cost = cost;
    }

    /** Upgrade a tower
    * @param tower the tower to upgrade
    */
    public abstract void evolve(Tower tower);
}
