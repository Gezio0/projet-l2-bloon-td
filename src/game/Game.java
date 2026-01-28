package game;
import game.board.*;
import game.exception.*;
import game.path.*;
import java.util.*;
import java.balloons.*;

public class Game {
    protected Board board;
    protected int clock;
    protected Set<Balloons> balloons;

    /**A game of a bloons td game */
    public Game(Board board,int NbBalloons){
        this.clock = 0;
        this.Balloons = new HashSet<Balloons>();

        List<Path> paths = board.getPaths();
        int pathIndex = 0;
        int pathsNumber = paths.size();

        Random rng = new Random();

        for(int i = 0 ; i < NbBalloons ; i++){

            int clockSpeed = rng.nextInt(40) + 10; // 10 ~ 50
            int resistance = rng.nextInt(4) + 1; // 1 ~ 4
            CellPath cellStart = paths[i].getFirstCell();
            
            this.Balloons.add(new Balloons(clockSpeed,resistance,cellStart));

            if(pathIndex >= pathsNumber){
                pathIndex = 0;
            } else {
                pathIndex++;
            }
        }
        this.board = board;
    }

    public boolean isFinished(){
        return balloons.size() == 0;
    }


    public void loop(){
        List<Balloon> balloonsToDestroy = new LinkedList<Balloon>():
        for (Balloon balloon : balloons){
            balloon.onClock(clock);
            if(balloon.finished()){
                balloonsToDestroy.add(balloon);
            }
        }
        for (Balloon balloon : balloonsToDestroy){
            System.out.println("Balloon destroyed at clock : " + clock);
            balloons.remove(balloon);
        }
        clock++;
    }
}
