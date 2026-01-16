package game.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.path.*;

/**A bloon td game board with multiple straight paths */
public class MultiplePathBoard extends Board {
    /**The number of path on the board */
    protected int NbOfPaths ;
    
    /**
     * Build a multiple path board with a given width, height and number of paths
     * @param width the width of the board
     * @param height the height of the board
     * @param NbOfPaths the number of path
     */
    public MultiplePathBoard(int width, int height, int NbOfPaths) throws TooMuchPathException{
        super(width,height);

        if (NbOfPaths > height/2){
            throw new TooMuchPathException("too much path, you need to have less than height/2");
        }

        initPath();
    }




    protected void initPath(){
        fillpath();

        List<Integer> occupiedColumn = new ArrayList<>();
        List<Integer> occupiedRow = new ArrayList<>();

        for (int n = 0; n<this.NbOfPaths; n++){
            int startX =0 ;
            int startY = 0 ;
            int DirX = 0;
            int DirY = 0;

            /*4 differents path types, we get one type of each before getting another for the same type */
            if (n%4 == 0){

            }
        }

    }

    /**
     * fill the board with empty cells
     */
    protected void fillpath(){
        for (int x = 0; x<this.width; x++){
            for (int y = 0; y < this.height; y++){
                this.tab[x][y] = new Cell(x,y);
            }
        }

    }

    /**
     * Give a starting index for a path
     * @param max maximum index for the path to be in the grid
     * @param occupied list of index where a path already starts
     * @return the index where the path will start
     */
    protected int StartingIndex(int max, List<Integer> occupied){
        Random rand = new Random();
        int res = -1;

        while(occupied.contains(res)){
            res = rand.nextInt(max);
        }

        occupied.add(res);
        return res;
    }

    
}

