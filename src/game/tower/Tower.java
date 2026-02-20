package game.tower;
import game.Game;
import game.GameObject;
import game.balloon.Balloon;
import game.path.*;
import java.util.*;
/**represents a tower in the game that can shoot */
public class Tower extends GameObject{
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
    /**time before the tower can shoot an other time*/
    protected int reloadTime;



    /** builds a tower with a range, a cost, a bullet and a cell
     * @param range int
     * @param cost int
     * @param bullet Bullet
     * @param cell Cell
     * @param paths List<Path>
     * 
     *
     * 
     */
    public Tower(int range, int cost, Bullet bullet,int reloadTime,Cell cell,List<Path> paths) {
        this.range = range;
        this.cost = cost;
        this.bullet = bullet;
        this.reloadTime = reloadTime;
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
    /**get the reload time of this tower
     * @return int
     */
    public int getReloadTime(){
        return this.reloadTime;
    }
    /**get the range of this tower
     * @return int
     */
    public int getRange() {
        return this.range;
    }
    /**get the cost of this tower
     * @return int
     */
    public int getCost() {
        return this.cost;
    }
    /**get the bullet of this tower
     * @return Bullet
     */
    public Bullet getBullet() {
        return this.bullet;
    }
    /**
     * get the cell of this tower
     * @return Cell
     */
    public Cell getCell(){
        return this.cell;
    }

    /**return the distance of a balloon and a cell pathpath
     *distance : sqrt((LastCellPathX-BalloonX)²+(LastCellPathY-BalloonY²). 
     * @param b1
     * @param lastCellPath
     * @return double
     */
    protected double distance(Balloon b1,CellPath lastCellPath){
        double b1ToLastCellX = lastCellPath.getCell().getX()-b1.getCell().getCell().getX();
        double b1ToLastCellY = lastCellPath.getCell().getY()-b1.getCell().getCell().getY();
        return Math.sqrt(((b1ToLastCellX*b1ToLastCellX)+(b1ToLastCellY*b1ToLastCellY)));
    }
    /**check if a balloon is in range, if it is then it will 
     * return the balloon that is the closest to end the path,
     * if it is not in range, then it will return null
     * @param Set<Balloon> balloons that are currently in the game
     * @return balloon targeted
     */
    protected Balloon isInRange(Set<Balloon> balloons){
        Balloon balloonTargeted = null;
        double distanceMin = Double.MAX_VALUE;
        for(Balloon b : balloons){

            Cell bCell = b.getCell().getCell();
            if(this.cellInRange.contains(bCell)){

                for(Path p : this.paths){
                    CellPath lasCellPath = p.getLastCell();
                    double currentDistance = this.distance(b, lasCellPath);
                    if (currentDistance<distanceMin){
                        distanceMin = currentDistance;
                        balloonTargeted = b;
                    }
                }
            }
        }
        return balloonTargeted;
    }
    /**check if two tower has the sameCell
     * @return true if they have the same cell, else false
     */
    public boolean SameTowerCell(Object object){
        if (!(object instanceof Tower)){
            return false;
        }
        Tower o = (Tower) object;
        return this.cell.equals(o.getCell());
    }
    /**attemps to fire a projectile at a target
     * if a target is found, it creates a new bullet with the properties of 
     * the current tower's bullet
     * @param Set<Balloon> balloons that are currently in the game
     * @return a new Bullet if a target is found,
     * else null.
     * 
     * 
     */
    public Bullet[] shoot(Set<Balloon>balloons){
        Balloon target= this.isInRange(balloons);
        Bullet[] projectile = new Bullet[1] ;
        if(target!=null){
            projectile[0] =(new Bullet(this.bullet.getArea(),this.bullet.getTimeLeft(),this.bullet.getEffects()));
            projectile[0].setBalloons(balloons);
            projectile[0].addTarget(target);
        }
        return projectile;
    }

    /**updates the tower's state every game tick
     * it is checking if the tower is ready to shoot or not
     * @param int the current clock of the game
     * @return true if this tower is ready else false
    */
    @Override
    public boolean onClock(int clock) {
        return clock%this.reloadTime==0;
    }


    

}
