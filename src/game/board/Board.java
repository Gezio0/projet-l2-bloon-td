package game.board;

import java.util.ArrayList;
import java.util.List;

import game.path.*;


/**An abstract board representing a bloons td game board */
public abstract class Board {
    /**Board width */
    protected int width ;
    /**Board height */
    protected int height ;
    /**Represents the cells of the board */
    protected Cell[][] tab ;
    /**The board paths list */
    protected List<Path> pathList ;

    /**Builds a Board with a given width and height
     * @param width board width
     * @param height board height
     */
    public Board(int width, int height){
        this.width = width ;
        this.height =  height ;
        this.tab = new Cell[width][height];
        this.pathList = new ArrayList<>();
    }

    /**Get a specific cell from a x and a y value 
     * @param x x value
     * @param y y value
     * @return the cell to this coordinates
    */
    public Cell getCell(int x, int y){
        return this.tab[x][y] ;
    }
    
    /**Get the board width 
     * @return the width
    */
    public int getWidth(){
        return this.width;
    }

    /**Get the board height 
     * @return the width
    */
    public int getHeight(){
        return this.height ;
    }

    /**Get the list of the paths 
     * @return the list
    */
    public List<Path> getPaths(){
        return this.pathList ;
    }

    /**Add a path to the paths list
     * @param path the path to add
     */
    public void addPath(Path path){
        this.pathList.add(path);
    }

    public abstract Path initPath() ;

}
