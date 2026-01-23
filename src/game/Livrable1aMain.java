package game;
import game.board.*;
import game.path.*;

public class Livrable1aMain {
    public static void main(String[] args) throws TooMuchPathsException,NoNextCellException{
        if (args.length>=2){
            try {
                int height = Integer.parseInt(args[0]);
                int width = Integer.parseInt(args[1]);
                ClassicalBoard board = new ClassicalBoard(height,width);
                board.initPath();
                board.show();
                System.out.println(board);

            }
            catch ( Exception e) {
                    System.out.println("args need to be int type");
                    System.out.println(e.getMessage());
            }
        }
        else {
            System.out.println("2 args needed");
        }
    }
}
