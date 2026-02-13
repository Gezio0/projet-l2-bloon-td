package game.tower;

import game.Game;
import game.GameObject;
import game.balloon.*;
import java.util.*;
/** Represent a Tower bullet that can hit or apply effects to a balloon or a group of balloon */
public class Bullet extends GameObject{

    /**
     * area impact of this bullet
     */
    protected int area;
    /**
     * time left before the bullet reach the target
     */
    protected int timeLeft;
    /**
     * list of effects that this bullet has
     */
    protected List<Effect> effects;

    /**the initial target of this bullet*/
    protected Balloon target;

    /**the current game*/
    protected Game game;

    /**
     * builds a bullet with a damage area, a timeLeft and a list of effects
     *
     * @param area int
     * @param timeLeft int
     * @param effects List<Effect>
     */
    public Bullet(int area, int timeLeft, List<Effect> effects,Game game) {
        this.area = area;
        this.timeLeft = timeLeft;
        this.effects = effects;
        this.target = null;
        this.game = game;
    }

    /** get the area damage of this bullet
     * @return int
     */
    public int getArea() {
        return this.area;
    }

    /** get the time left of this bullet
     * @return int
     */
    public int getTimeLeft() {
        return this.timeLeft;
    }
    /**return all the balloons in the area of the bullet when it will hit the initial target
     * @return Set<Balloon> all the balloons that are targeted.
     */
    protected Set<Balloon> finalTargets(){
        Set<Balloon> balloonsTargeted = new HashSet<>();
        int maxX = this.target.getCell().getCell().getX()+this.area;
        int maxY = this.target.getCell().getCell().getY()+this.area;
        int minX = this.target.getCell().getCell().getX()-this.area;
        int minY = this.target.getCell().getCell().getY()-this.area;
        for(Balloon b:this.game.getBalloons()){
            int balloonX = b.getCell().getCell().getX();
            int balloonY = b.getCell().getCell().getY();
            if(balloonX>=minX&&balloonX<=maxX&&balloonY>=minY&&balloonY<=maxY){
                balloonsTargeted.add(b);
            }
        }
        return balloonsTargeted;
    }

    /** get the list of effects of this bullet
     * @return the list of effects
     */
    public List<Effect> getEffects() {
        return this.effects;
    }

    /**Updates the bullet's state every game tick
     * if the bullet has time left before hitting a target, the timeleft decrease,
     * when there is no time left it applies all the effects balloons in the area of this bullet.
     * @return 
    */
    @Override
    public boolean onClock(int clock){
        if ((this.timeLeft>0)){
            this.timeLeft--;
            if (this.timeLeft==0){
                Set<Balloon> balloonsTargeted = this.finalTargets();
                for(Balloon b : balloonsTargeted){
                    for(Effect effect : this.effects){
                        effect.addTarget(b);
                    }
                }
                this.destroy();
                return true;
            } 
        }
        return false;
        }
        

    /**add a target to the balloon */
    public void addTarget(Balloon b){
        this.target = b;
    }

}
