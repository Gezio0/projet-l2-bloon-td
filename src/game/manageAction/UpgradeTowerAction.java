package game.manageAction;

import game.player.Player;
import game.tower.Tower;
import game.tower.upgrade.Upgrade;

/**A class to upgrade a tower */
public class UpgradeTowerAction implements ManageAction{
    /**the player */
    protected Player player ;
    /**the tower to place */
    protected Tower tower;
    /**the upgrade to buy */
    protected Upgrade upgrade;

    /**
     * An action to upgrade a tower with all the informations needed
     * @param player
     * @param tower
     * @param upgrade
     */
    public UpgradeTowerAction(Player player, Tower tower, Upgrade upgrade){
        this.player = player;
        this.tower = tower;
        this.upgrade = upgrade;
    }

    /**
     * Perform the action to upgrade the tower
     */
    @Override
    public void perform(){
        this.player.buyUpgrade(tower, upgrade);
    }
}


