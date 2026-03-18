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
}
