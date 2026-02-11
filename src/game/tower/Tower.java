package game.tower;

import game.path.Cell;

public class Tower {
    /**
     * range of this tower, if a balloon is inside this range, then the tower can
     * hit it
     */
    protected int range;
    /** cost of this tower */
    protected int cost;
    /** bullet of this tower */
    protected Bullet bullet;
    /**Cell of this tower */
    protected Cell cell;

    /** builds a tower with a range, a cost, a bullet and a cell
     * @param range int
     * @param cost int
     * @param bullet Bullet
     * @param cell Cell
     * 
     */
    public Tower(int range, int cost, Bullet bullet,Cell cell) {
        this.range = range;
        this.cost = cost;
        this.bullet = bullet;
        this.cell = cell;

    }
    /**get the range of this tower
     * @return int
     */
    public int getRange() {
        return range;
    }
    /**get the cost of this tower
     * @return int
     */
    public int getCost() {
        return cost;
    }
    /**get the bullet of this tower
     * @return Bullet
     */
    public Bullet getBullet() {
        return bullet;
    }
    /**check if a balloon is in range, if it is then it will 
     * return the balloon that is the closest to end the path,
     * if it is not in range, then it will return null
     * @return Cell
     */
    protected Cell isInRange(){

    }
    public void shoot(){

    }

}
