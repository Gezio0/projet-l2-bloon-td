package game.balloon;
import game.exception.*;
import game.path.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BalloonTest{

    private Balloon b1;
    private Cell c1;
    private Cell c2;
    private CellPath cp1;
    private CellPath cp2;
    

    @BeforeEach
    public void before() {
        this.b1 = new Balloon(25,3);
        this.c1 = new Cell(0,0);
        this.c2 = new Cell(0,1);
        this.cp1 = new CellPath(this.c1);
        this.cp2 = new CellPath(this.c2);
        this.cp1.setNext(this.cp2);
    }

    @Test
    public void moveForwardTestOK() throws NoNextCellException{
        CellPath next = this.cp1.getNextCell();
        assertEquals(this.cp1.getCell(),this.b1.getCell().getCell());
        this.b1.moveForward();
        assertEquals(next,this.b1.getCell());
    }


    @Test
    public void isFinishedTest(){}


}


