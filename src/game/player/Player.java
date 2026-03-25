package game.player;

public class Player{
    protected int lives;
    protected int money;
    protected Shop shop;

    public Player(Shop shop){
        this.shop = shop;
    }
    
}