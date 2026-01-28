package game;
import game.board.*;
import game.exception.*;
import game.path.*;
import java.util.*;
import game.balloon.*;

/**A game of a bloons td game */
public class Game {
    /**Game's Board */
    protected Board board;
    /**Game's clock */
    protected int clock;
    /**Game's balloons */
    protected Set<Balloon> balloons;

    /**
     * Builds a Game with a given board and balloons number
     * @param board Game's board
     * @param NbBalloons Game's balloons number
     */
    public Game(Board board,int NbBalloons){
        this.clock = 0;
        this.balloons = new HashSet<Balloon>();

        List<Path> paths = board.getPaths();
        int pathIndex = 0;
        int pathsNumber = paths.size();

        Random rng = new Random();
        if (paths.size()==1){
            CellPath cellStart = paths.get(0).getFirstCell();
            for(int i = 0 ; i < NbBalloons ; i++){

                int clockSpeed = rng.nextInt(40) + 10; // 10 ~ 50
                int resistance = rng.nextInt(4) + 1; // 1 ~ 4
                
                
                this.balloons.add(new Balloon(clockSpeed,resistance,cellStart));

                if(pathIndex >= pathsNumber){
                    pathIndex = 0;
                } else {
                    pathIndex++;
                }
            }
        }
        else{
            for(int i = 0 ; i < NbBalloons ; i++){

                int clockSpeed = rng.nextInt(40) + 10; // 10 ~ 50
                int resistance = rng.nextInt(4) + 1; // 1 ~ 4
                CellPath cellStart = paths.get(i).getFirstCell();
                
                this.balloons.add(new Balloon(clockSpeed,resistance,cellStart));

                if(pathIndex >= pathsNumber){
                    pathIndex = 0;
                } else {
                    pathIndex++;
                }
            }
        }
        
        this.board = board;
    }

    /**
     * Return true if the game is finished
     * @return true if the game is finished
    */
    public boolean isFinished(){
        return balloons.size() == 0;
    }

    /**
     * Do a turn of the game
     * @throws NoNextCellException 
    */
    public void loop() throws NoNextCellException{
        List<Balloon> balloonsToDestroy = new LinkedList<Balloon>();
        for (Balloon balloon : balloons){
            balloon.onClock(clock);
            if(balloon.isFinished()){
                balloonsToDestroy.add(balloon);
            }
        }
        for (Balloon balloon : balloonsToDestroy){
            System.out.println("Balloon destroyed at clock : " + clock);
            balloons.remove(balloon);
        }
        clock++;
    }
    public Set<Balloon> getBalloons(){
        return this.balloons;
    }
}
