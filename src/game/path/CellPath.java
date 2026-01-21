package game.path;
import exception.*;
// class to connect each cell to his next cell
public class CellPath{
    protected Cell cell;
    protected Cell nextCell;

    /** constructor for the last cell (without a next cell)
     * @param cell the actual cell
     */
    public CellPath(Cell cell){
        this.cell = cell;
    }

    /** constructor for a cell 
     * @param cell the actual cell
     * @param nextCell the next cell
     */
    public CellPath(Cell cell,Cell nextCell){
        this.cell = cell;
        this.nextCell = nextCell;
    }

    /** return the actual cell
     * @return the cell
     */
    public Cell getCell(){
        return this.cell;
    }

    /**return the next cell if it exist
     * @throws NoNextCellException
     * @return the next cell
     */
    public Cell getNextCell()throws NoNextCellException{
        if(this.nextCell == null){
            throw new NoNextCellException();
        }
        return this.nextCell;
    }

    /**return if the actual cell is the last cell of the path
     * @return boolean that say if the cell is the last one of the path
     */
    public boolean isFinished(){
        return this.nextCell == null;
    }

    /**return if the actual cell is equals to another cell gived in parameter
     * @param o the other cell to compare
     * @return boolean that say if the cells are equals
     */
    public boolean equals(Object o){
        if (!(o instanceof CellPath)){
            return false;
        }
        CellPath other = (CellPath) o;
        return (this.cell == other.cell && this.nextCell == other.nextCell);
    }
}