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
        int lastRandomNum = 0;

        int x = this.width - 1;
        Cell firstCell = this.getCell(x,y);
        CellPath cellPath = new CellPath(firstCell);

        while(x > 0){
            if(y == height || y == 0){
                x--;
            } else {
                int randomNum = rng.nextInt(2);
                if(randomNum == 1){
                if(lastRandomNum != 2){
                        y++;
                    } else {
                        x--;
                    }
                } else {
                if(lastRandomNum != 1){
                        y++;
                    } else {
                        x--;
                    }
                }
                Cell newCell = new Cell(x,y);
                cellPath = new CellPath(newCell,cellPath);
                lastRandomNum = randomNum;
            }
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