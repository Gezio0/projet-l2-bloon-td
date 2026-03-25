package game.player;
import game.*;



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

    public boolean buyTower(Tower tower){
        int cost = tower.getCost();
        if(canBuyTower()){
            this.money = this.money - cost;
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
        this.money = this.money + 0.8*cost;
        System.out.println("You sold "+ tower.getName()+" for "+0.8*cost);
        return true;
    }

    public boolean canBuyTower(Tower tower){
        int cost = tower.getCost();
        return this.money >= cost;
    }

    public boolean canBuyUpgrade(Upgrade upgrade){
        int cost = upgrade.getCost();
        return this.money > cost;
    }

    public boolean buyUpgrade(Upgrade upgrade){
        int cost = upgrade.getCost();
        if(canBuyUpgrade()){
            this.money = this.money - cost;
            System.out.println("Upgrade was purchased for "+ cost + " gold. The player has now "+ this.money + " gold.");
            return true;
        }
        else{
            System.out.println("You don't have enough money");
            return false;
        }
    }

    public boolean sellUpgrade( Upgrade upgrade){
        int cost = upgrade.getCost();
        this.money = this.money + 0.8*cost;
        System.out.println("You sold "+ tower.getName()+" for "+0.8*cost);
        return true;
    }

}