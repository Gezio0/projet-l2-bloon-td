package game.path;

/**A cell of a bloons td game */
public class Cell {
    /**x coordinate of the cell in the board */
    private int x;
    /**y coordinate of the cell in the board */
    private int y;
    /**true if this cell is empty (does not contain any path) */
    private boolean isEmpty ;

    /**
     * Builds an empty cell of a bloon td game board with a x and y coordinate.
     * @param x x coordinate
     * @param y y coordinate
     */
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.isEmpty = true;
    }
}
