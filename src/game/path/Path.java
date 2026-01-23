package game.path;
import java.util.*;
import game.exception.*;
public class Path {
    protected CellPath firstCell;
    protected CellPath lastCell;
    protected List<CellPath> cellsPaths;
    /**Builds a Path with a first cell in parameter
     * has a firstCell, a list with all the cells path and the last cell
     * @throws NoNextCellException
    */
    public Path(CellPath firstCell)throws NoNextCellException{
        this.firstCell = firstCell;
        this.cellsPaths = new ArrayList<CellPath>();
        if (firstCell!=null){
            CellPath currentTempCell = firstCell;
            while(!currentTempCell.isFinished()){
                this.cellsPaths.add(currentTempCell);
                currentTempCell = currentTempCell.getNextCell();
            }
            this.cellsPaths.add(currentTempCell);
            this.lastCell = this.cellsPaths.get(this.cellsPaths.size()-1);
        }
        else{
            this.lastCell = null;
        }
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
     * 
     * @return List<CellPath>
     */
    public List<CellPath> getPath(){
        return this.cellsPaths;
    }

    /**
     * check if each elements in this list and the other list are the same
     * @return boolean
     */
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Path)){
            return false;
        }
        Path other = (Path) o;
        boolean boolSizeList =this.cellsPaths.size()==other.cellsPaths.size();
        if (boolSizeList){
            for (int i=0;i<this.cellsPaths.size();i++){
                if (!this.cellsPaths.get(i).equals(other.cellsPaths.get(i))){
                    return false;
                }
            }
        }

        return boolSizeList
        &&this.firstCell.equals(other.firstCell)
        &&this.lastCell.equals(other.lastCell);
    }

    public String toString(){
        String coos = "";
        for(CellPath cp: this.cellsPaths){
            int x = cp.getCell().getX();
            int y = cp.getCell().getY();
            coos+= "("+x+","+y+") ";
        }
        return coos;
    }
}
