package game;
import game.board.*;
import game.path.*;
import game.exception.*;

public class Livrable1aMain {
    public static void main(String[] args) {
        if (args.length>=2){
            try {
                
                int height = Integer.parseInt(args[0]);
                int width = Integer.parseInt(args[1]);
                ClassicalBoard board = new ClassicalBoard(args[0],args[1]);
                Path p = board.initPath();
                board.addPath(p);
                System.out.println(p);
                System.out.println(board);

        }
        catch (NumberFormatException e) {
                System.out.println("args need to be int type");
            }
        }
        else {
            System.out.println("2 args needed");
        }
        
        
        
    }
}
