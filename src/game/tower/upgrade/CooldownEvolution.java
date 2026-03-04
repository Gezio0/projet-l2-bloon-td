package game.tower.upgrade;

import game.tower.*;

public class CooldownEvolution extends Upgrade{
    protected double multiplier;

    /*constructor of the class CooldownEvolution that modify the time for reload a bullet to a specific tower */
    public CooldownEvolution(int cost, double multiplier){
        this.multiplier = multiplier;
    }

    /** upgrade the tower in parameter by setting its reload time lower 
    * @param tower the tower to upgrade
    */
    public void evolve(Tower tower){
        int cd = tower.getReloadTime();
        int newCd = (int) Math.floor(cd * this.multiplier);
        tower.setReloadTime(newCd);
    }
}