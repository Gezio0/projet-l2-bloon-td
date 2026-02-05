package game.tower;
import game.balloon.*;
import game.board.*;
import game.path.*;


public abstract class Effects{
    private int duration;
    private String name;
    private boolean stackable;
    private Balloon balloon;

    public Effects(String name, int duration, boolean stackable, Balloon balloon){
        this.name = name;
        this.duration = duration;
        this.stackable = stackable;
        this.balloon = balloon;
    }

    public String getName(){
        return this.name;
    }

    public int getDuration(){
        return this.duration;
    }

    public boolean isStackable(){
        return this.stackable;
    }

    public Balloon getTarget(){
        return this.balloon;
    }

    public abstract void applyEffect();
}