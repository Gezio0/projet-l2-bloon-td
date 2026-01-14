package game.board;

import game.board.Board;
import game.path.*;
import game.exceptions.*;

// class for classical board
public class ClassicalBoard extends Board {

    /** create a classcial board with the length
    */
    public ClassicalBoard(int width,int height){
        super(width,height);
    }

    /** create a path in the board
     * @return the path created
	 */
    public Path initPath() {
        Random rng = new Random();
        int y = rng.nextInt(0,this.height);
        int lastY = null;
        int x = 0
        Cell firstCell = this.getCell(x,y);
        while(x < this.width){
            if(y == height || y == 0){
                x++:
            } else {
                switch rng.nextInt(0,3){
                    case 1:
                        
                    case 2:

                    case 3:
                }
            }
            lastY = y;
        }
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