package game.board;

import game.path.*;
import game.exception.*;
import java.util.Random ;

// class for classical board
public class ClassicalBoard extends Board {

    /** create a classcial board with the length
    */
    public ClassicalBoard(int width,int height){
        super(width,height);
    }

    /** create a random path in the board
     * @return the path created
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