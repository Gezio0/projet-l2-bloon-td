package game.tower.upgrade;

import game.tower.*;

public class CooldownEvolution extends Upgrade{
    protected double multiplier;

    public CooldownEvolution(int cost, double multiplier){
        this.multiplier = multiplier;
    }

}