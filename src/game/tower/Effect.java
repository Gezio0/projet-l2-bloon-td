package game.tower;
import game.GameObject;
import game.balloon.*;
import java.util.*;


public abstract class Effect extends GameObject {
    protected int duration;
    protected String name;
    protected boolean stackable;
    protected List<Balloon> balloons;

    public Effect(String name, int duration, boolean stackable){
        super();
        this.name = name;
        this.duration = duration;
        this.stackable = stackable;
        this.balloons = new LinkedList<Balloon>();
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

    public List<Balloon> getTargets(){
        return this.balloons;
    }

    public void addTarget(Balloon balloon){
        this.balloons.add(balloon);
    }

    public abstract void applyEffect();
    
    public abstract boolean onClock(int clock);
}