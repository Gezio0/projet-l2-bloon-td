package game.tower.upgrade;

import java.util.List;

/**A class to manage tower upgrade */
public class UpgradeTree {
    /**active upgrades that are applied, can be sold */
    protected List<Upgrade> activeUpgrades ;
    /**inactive upgrades, can be bought */
    protected List<Upgrade> inactiveUpgrades ;
}
