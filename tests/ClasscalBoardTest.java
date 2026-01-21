package game.path;
import exception.*;
import game.board.ClassicalBoard;;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CellPathTest{
    private ClassicalBoard board;

    @BeforeEach
    public void before() {
        this.board = new ClassicalBoard(5,5);
    }

    @Test
    public void testInitPath(){
        Path path = this.board.initPath();
        assertEquals(path.getFirstCell().getCell().x,0);
        assertEquals(path.getLastCell().getCell().x,4);
    }

    @Test
    public void testAddPathThrowError() throws TooMuchPathsException{
        Path newPath = this.board.initPath();
        Path newPath2 = this.board.initPath();
        this.board.addPath(newPath);
        assertThrows(TooMuchPathsException.class, ()->this.board.addPath(newPath2));
    }
}