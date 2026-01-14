package game.board;

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

}
