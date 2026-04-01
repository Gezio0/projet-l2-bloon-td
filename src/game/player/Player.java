package game.player;
import game.*;
import game.tower.*;
import game.tower.upgrade.*;
import java.util.*;

public class Player{
    protected int lives;
    protected int money;
    protected Shop shop;

    public Player(Shop shop){
        this.shop = shop;
        this.money = 2500;
        this.lives = 20;
    }

    public int getMoney(){
        return this.money;
    }
    
    public int getLives(){
        return this.lives;
    }

    public void buyUpgrade(Tower tower){

    }

    public boolean buyTower(Tower tower,int x,int y){
        int cost = tower.getCost();
        if(this.canBuyTower(tower)){
            this.money = this.money - cost;
            Tower tower2 = tower.copy();
            tower2.setCell(x,y);
            System.out.println("Tower "+ tower.getName()+ " was purchased for "+ cost + " gold. The player has now "+ this.money + " gold.");
            return true;
        }
        else{
            System.out.println("You don't have enough money");
            return false;
        }
    }

    public boolean sellTower(Tower tower){
        int cost = tower.getCost();
        this.money = this.money + (int)(Math.floor(0.8*cost));
        System.out.println("You sold "+ tower.getName()+" for "+0.8*cost);
        tower.toDestroy();
        return true;
    }

    public boolean canBuyTower(Tower tower){
        int cost = tower.getCost();
        return this.money >= cost;
    }

    public boolean canBuyUpgrade(Tower tower, Upgrade upgrade){
        if(tower.getUpgradeTree().getInactiveUpgrades().contains(upgrade)){
            int cost = upgrade.getCost();
            return this.money > cost;
        }
        return false;
    }

    public boolean buyUpgrade(Tower tower, Upgrade upgrade){
        int cost = upgrade.getCost();
        if(this.canBuyUpgrade(tower,upgrade)){
            this.money = this.money - cost;
            tower.buyUp(upgrade);
            System.out.println("Upgrade was purchased for "+ cost + " gold. The player has now "+ this.money + " gold.");
            return true;
        }
        else{
            System.out.println("You don't have enough money");
            return false;
        }
    }

    public boolean sellUpgrade(Tower tower,Upgrade upgrade){
        int cost = upgrade.getCost();
        this.money = this.money + (int)(Math.floor(0.8*cost));
        System.out.println("You sold "+ tower.getName()+" for "+0.8*cost);
        tower.getUpgradeTree().sell(upgrade);
        return true;
    }

    public void decreaseLife(){
        this.lives = this.lives - 1;
    }
    
}

