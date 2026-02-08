package game.tower;

import java.util.*;
/** bullet class for  */
public class Bullet {

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

    /**
     * builds a bullet with a damage area, a timeLeft and a list of effects
     *
     * @param area int
     * @param timeLeft int
     * @param effects List<Effect>
     */
    public Bullet(int area, int timeLeft, List<Effect> effects) {
        this.area = area;
        this.timeLeft = timeLeft;
        this.effects = effects;
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

    /** get the list of effects of this bullet
     * @return int
     */
    public List<Effect> getEffects() {
        return this.effects;
    }

}
