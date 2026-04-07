package game.manageAction;

import game.player.Player;
import game.tower.Tower;

/**A class to buy a tower */
public class BuyTowerAction implements ManageAction {
    /**the player */
    protected Player player ;
    /**the tower to place */
    protected Tower tower;
    /**x coordinate to place the tower */
    protected int x;
    /**y coordinate to place the tower */
    protected int y;

    public BuyTowerAction(Player player, Tower tower, int x, int y){
        this.player = player;
        this.tower = tower;
        this.x = x;
        this.y = y;
    }
}
