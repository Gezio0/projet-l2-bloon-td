package game.board;

import game.exception.*;
import game.path.*;
import java.util.Random ;

/**
 * A class representing a classical board with a single path starting from left.
 * This path can go up,down,right but not left until end column is reached.
 */
public class ClassicalBoard extends Board {

    /** create a classcial board with the length
     * @param width width of this board
     * @param height height of this board
    */
    public ClassicalBoard(int width,int height){
        super(width,height);
        
    }

    /** create a random path in the board
     * @throws TooMuchPathsException when paths are exceeding the limit (here it's 1)
     * @throws NoNextCellException when trying to get a null cell
	 */
    public void initPath() throws TooMuchPathsException,NoNextCellException{
        Random rng = new Random();
        int y = rng.nextInt(this.height);
        String lastDirection = "";

        int x = this.width - 1;
        Cell firstCell = new Cell(x,y);


        CellPath cellPath = new CellPath(firstCell);

        while(x > 0){
            int randomNum = rng.nextInt(2);
            if(randomNum == 1){
                if(!lastDirection.equals("Down") && y < this.height-1){
                    y++;
                    lastDirection = "Up";
                } else {
                    x--;
                    lastDirection = "Left";
                }
            } else {
                if(!lastDirection.equals("Up") && y > 0){
                    y--;
                    lastDirection = "Down";
                } else {
                    x--;
                    lastDirection = "Left";
                }
            }
            Cell newCell = new Cell(x,y);
            cellPath = new CellPath(newCell,cellPath);
            
        }
        this.addPath(new Path(cellPath));
    }

    /** add the path to the list of paths
	 * @param path the path to add 
     * @throws TooMuchPathsException if there is already a path
	 */
    public void addPath(Path path) throws TooMuchPathsException {
        if(this.pathList.size() < 1){
            super.addPath(path);
        } else {
            throw new TooMuchPathsException();
        }
    }
}