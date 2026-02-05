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
        this.duration = duration;$
        this.stackable = stackable;
        this.balloon = balloon;
    }
}