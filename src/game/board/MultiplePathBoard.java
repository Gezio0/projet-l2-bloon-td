package game.board;

import game.board.Board;
import game.path.*;
import game.exceptions.*;

// class for classical board
public class MultiplePathBoard extends Board {

    /** create a classcial board with the length
    */
    public MultiplePathBoard(int width,int height){
        super(width,height);
    }

    /** create a path in the board
     * @return the path created
	 */
    public Path initPath() {
        Random rng = new Random();
        boolean vertical = rng.nextInt(0,2) == 1;
        boolean sens = rng.nextInt(0,2) == 1;
        int index = 0;
        int pathLength = 0;
        CellPath firstCell;
        if(vertical){
            index = rng.nextInt(0,this.width);
            pathLength = this.height;
        } else {
            index = rng.nextInt(0,this.height);
            pathLength = this.width;
        }
        
        if(vertical){

        } else {

        }
    }
}