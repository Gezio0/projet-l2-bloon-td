package game.path;
import game.exception.*;
// class to connect each cell to his next cell
public class CellPath{
    protected Cell cell;
    protected CellPath nextCell;

    

    /** constructor for a cell 
     * @param cell the actual cell
     * @param nextCell the next cellPath that contains the next cell
     */
    public CellPath(Cell cell){
        this.cell = cell;
        this.nextCell = null;
    }

    /** return the actual cell
     * @return the cell
     */
    public Cell getCell(){
        return this.cell;
    }
    /** set a new CellPath in nextCell*/
    public void setNext(Cell cell){
        this.nextCell = new CellPath(cell);
    }



    /**return the next cellPath if it exist
     * @throws NoNextCellException
     * @return the next cell
     */
    public CellPath getNextCell()throws NoNextCellException{
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
