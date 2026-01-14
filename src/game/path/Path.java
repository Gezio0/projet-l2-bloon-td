package game.path;
import java.util.*;
public class Path {
    protected CellPath firstCell;
    protected CellPath lastCell;
    protected List<CellPath> cellsPaths;
    /**Builds a Path with a first cell in parameter
     * has a firstCell, a list with all the cells path and the last cell
    */
    public Path(CellPath firstCell){
        this.firstCell = firstCell;
        this.cellsPaths = new ArrayList<CellPath>();
        CellPath currentTempCell = firstCell;
        while(!currentTempCell.isFinished()){
            this.cellsPaths.add(currentTempCell);
            currentTempCell = currentTempCell.getNextCell();
        }
        this.cellsPaths.add(currentTempCell);
        this.lastCell = this.cellsPaths.get(this.cellsPaths.size()-1);
    }
    /**get the first Cell of this Path
     * @return CellPath the first cell of this path
    */
    public CellPath getFirstCell() {
        return this.firstCell;
    }
    /**get the last CellPath of this path
     * @return CellPath the last cell path
     */
    public CellPath getLastCell(){
        return this.lastCell;
    }
    /**get the CellPath list of this path
     * @return List<CellPath>
     */
    public CellPath getPath(){
        return this.cellsPaths;
    }
    public boolean equals(Object o){
        if (!(o instanceof Path)){
            return false;
        }
        Path other = (Path) o;
        
    }

}
