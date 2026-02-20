package game.tower;
import game.GameObject;
import game.balloon.*;
import java.util.*;


public abstract class Effect extends GameObject {
    protected int duration;
    protected String name;
    protected boolean stackable;
    protected List<Balloon> balloons;
    protected boolean isFirstTick;

    public Effect(String name, int duration, boolean stackable){
        super();
        this.name = name;
        this.duration = duration;
        this.stackable = stackable;
        this.balloons = new LinkedList<Balloon>();
        this.isFirstTick = true;
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
    public void removeTarget(Balloon balloon){
        this.balloons.remove(balloon);
    }
    public abstract void applyEffect(int clock);
    
    public boolean onClock(int clock){
        this.applyEffect(clock);
        this.duration = this.duration -1;
        return true;
    }

    public abstract Effect copy();
}