package game.player;

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
}