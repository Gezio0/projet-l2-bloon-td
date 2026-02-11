package game.tower;

import game.path.*;
import java.util.*;

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
    /**paths that are in the board*/
    protected List<Path> paths;
    /**List of cell in range of this tower */
    protected List<Cell> cellInRange;

    /** builds a tower with a range, a cost, a bullet and a cell
     * @param range int
     * @param cost int
     * @param bullet Bullet
     * @param cell Cell
     * @param paths List<Path>
     *
     * 
     */
    public Tower(int range, int cost, Bullet bullet,Cell cell,List<Path> paths) {
        this.range = range;
        this.cost = cost;
        this.bullet = bullet;
        this.cell = cell;
        this.cellInRange = new ArrayList<Cell>();
        int maxX = this.cell.getX()+this.range;
        int maxY = this.cell.getY()+this.range;
        int minX = this.cell.getX()+this.range;
        int minY = this.cell.getY()+this.range;
        for(Path p : paths){
            List<CellPath> cellpaths= p.getPath();
            for(CellPath cp : cellpaths){
                Cell c = cp.getCell();
                if( c.getX()<=maxX && c.getX()>=minX && c.getY()>=minY && c.getY()<=maxY){
                    cellInRange.add(c);
                }
            }
        }

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
