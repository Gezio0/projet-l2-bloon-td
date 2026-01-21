package game.board;

import game.board.Board;
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
    public Path initPath() {
        Random rng = new Random();
        int y = rng.nextInt(0,this.height);
        int lastRandomNum = null;

        int x = this.width - 1;
        Cell firstCell = this.getCell(x,y);
        x--;
        Cell secondCell = this.getCell(x,y);

        CellPath cellPath = new CellPath(firstCell,secondCell);

        while(x > 0){
            if(y == height || y == 0){
                x--:
            } else {
                int randomNum = rng.nextInt(0,2);
                switch randomNum{
                    case 1:
                        if(lastCell != 2){
                            y++;
                        } else {
                            x--;
                        }
                    case 2:
                        if(lastCell != 1){
                            y++;
                        } else {
                            x--;
                        }
                }
                Cell newCell = new Cell(x,y);
                cellPath = new CellPath(newCell,cellPath.getCell());
            }
            lastRandomNum = randomNum;
        }
        return new Path(cellPath);
    }

    /** add the path to the list of paths
	 * @param path the path to add 
     * @throws TooMuchPathsException if there is already a path
	 */
    public Path addPath(Path path) throws TooMuchPathsException {
        if(pathTab.size() < 1){
            super.addPath(path);
        } else {
            throw new TooMuchPathsException();
        }
    }
}