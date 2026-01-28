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
    public void isFinishedTestFalse(){
        assertFalse(this.b1.isFinished());
    }

    @Test
    public void isFinishedTestTrue(){
        this.b1.moveForward();
        assertTrue(this.b1.isFinished());
    }

    @Test
    public void decreaseResistanceTest(){
        int res = this.b1.getResistance();
        this.b1.decreaseResistance(2);
        assertEquals(res-2,this.b1.getResistance());
    }

    @Test
    public void isDeadTestTrue(){
        this.b1.decreaseResistance(3);
        assertTrue(this.b1.getResistance()<=0);
    }

    @Test
    public void isDeadTestFalse(){
        this.b1.decreaseResistance(2);
        assertFalse(this.b1.getResistance()<=0);
    }

}

