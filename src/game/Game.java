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
    protected Set<GameObject> gameObjects;

    /**
     * Builds a Game with a given board and balloons number
     * @param board Game's board
     * @param NbBalloons Game's balloons number
     */
    public Game(Board board,int NbBalloons){
        this.clock = 0;
        this.gameObjects = new HashSet<GameObject>();

        List<Path> paths = board.getPaths();
        int pathIndex = 0;
        int pathsNumber = paths.size();

        Random rng = new Random();
        for(int i = 0 ; i < NbBalloons ; i++){
            
            CellPath cellStart = paths.get(pathIndex).getFirstCell();
            int clockSpeed = rng.nextInt(40) + 10; // 10 ~ 50
            int resistance = rng.nextInt(4) + 1; // 1 ~ 4
            
            
            this.gameObjects.add(new Balloon(clockSpeed,resistance,cellStart));

            if(pathIndex + 1 >= pathsNumber){
                pathIndex = 0;
            } else {
                pathIndex++;
            }
        }
        this.board = board;
    }

    /**
     * Return true if the game is finished
     * @return true if the game is finished
    */
    public boolean isFinished(){
        return gameObjects.size() == 0;
    }

    /**
     * Do a turn of the game
     * @throws NoNextCellException 
    */
    public void loop() throws NoNextCellException{
        List<GameObject> gameObjectToDestroy = new LinkedList<GameObject>();
        for (GameObject gameObject : this.gameObjects){
            gameObject.onClock(this.clock);
            if(gameObject.toDestroy()){
                gameObjectToDestroy.add(gameObject);
            }
        this.clock++;
        }
        for(GameObject gameObject : gameObjectToDestroy){
            this.DeleteGameObject(gameObject);
        }
    }

    public Set<GameObject> getBalloons(){
        return this.gameObjects;
    }

    public void DeleteGameObject(GameObject gameObject){
        this.gameObjects.remove(gameObject);
    }
}
