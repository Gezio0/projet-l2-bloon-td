package game;
import game.board.*;
import game.path.*;

public class Livrable1aMain {
    public static void main(String[] args) {
        if (args.length>=2){
            try {
                
                int height = Integer.parseInt(args[0]);
                int width = Integer.parseInt(args[1]);
                ClassicalBoard board = new ClassicalBoard(height,width);
                board.initPath();
                Path p = board.getPaths().get(0);
                System.out.println(p);
                board.Show();

        }
        catch ( Exception e) {
                System.out.println("args need to be int type");
            }
        }
        else {
            System.out.println("2 args needed");
        }
        
        
        
    }
}
