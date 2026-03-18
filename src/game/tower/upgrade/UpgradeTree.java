package game.tower.upgrade;

import java.util.ArrayList;
import java.util.List;

/**A class to manage tower upgrade */
public class UpgradeTree {
    /**active upgrades that are applied, can be sold */
    protected List<Upgrade> activeUpgrades ;
    /**inactive upgrades, can be bought */
    protected List<Upgrade> inactiveUpgrades ;

    /**
     * Builds an UpgradeTree with a list of upgrades.
     * Create a new empty list that will contain active upgrades.
     * Copy the list in parameter to create a new list of inactives upgrades.
     * @param inactiveUpgrades the list copied.
     */
    public UpgradeTree(List<Upgrade> inactiveUpgrades){
        this.activeUpgrades = new ArrayList<>();
        this.inactiveUpgrades = new ArrayList<>(inactiveUpgrades);
    }

    /**
     * Switch an upgrade from the inactiveUpgrades list to the active one
     * No effect if upgrade is not in the inactive list.
     * @param upgrade the upgrade to buy
     */
    public void buy(Upgrade upgrade){
        if (this.inactiveUpgrades.contains(upgrade)){
            this.inactiveUpgrades.remove(upgrade);
            this.activeUpgrades.add(upgrade);
        }
    }

    /**
     * Switch an upgrade from the activeUpgrades list to the inactive one
     * No effect if upgrade is not in the active list.
     * @param upgrade the upgrade to sell
     */
    public void sell(Upgrade upgrade){
        if (this.activeUpgrades.contains(upgrade)){
            this.activeUpgrades.remove(upgrade);
            this.inactiveUpgrades.add(upgrade);
        }
    }

    /**
     * Get the list of active upgrades
     * @return the list of active upgrades
     */
    public List<Upgrade> getActiveUpgrades(){
        return this.activeUpgrades;
    }
}
