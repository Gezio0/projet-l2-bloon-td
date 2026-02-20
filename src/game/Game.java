package game;
import game.board.*;
import game.exception.*;
import game.path.*;
import java.util.*;
import game.balloon.*;
import game.tower.*;

/**A game of a bloons td game */
public class Game {
    /**Game's Board */
    protected Board board;
    /**Game's clock */
    protected int clock;
    /**Game's gameObjects */
    protected Set<GameObject> gameObjects;
    /**Game's balloons */
    protected Set<Balloon> balloons;
    /**Game's towers */
    protected Set<Tower> towers;
    /**
     * Builds a Game with a given board and balloons number
     * @param board Game's board
     * @param NbBalloons Game's balloons number
     */
    public Game(Board board,int NbBalloons){
        this.clock = 0;
        this.gameObjects = new HashSet<GameObject>();
        this.balloons = new HashSet<Balloon>();
        this.towers = new HashSet<>();
        List<Path> paths = board.getPaths();
        int pathIndex = 0;
        int pathsNumber = paths.size();

        Random rng = new Random();
        for(int i = 0 ; i < NbBalloons ; i++){
            
            CellPath cellStart = paths.get(pathIndex).getFirstCell();
            int clockSpeed = rng.nextInt(40) + 10; // 10 ~ 50
            int resistance = rng.nextInt(4) + 1; // 1 ~ 4
            Balloon balloon = new Balloon(clockSpeed,resistance,cellStart);
            this.gameObjects.add(balloon);
            this.balloons.add(balloon);
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
        return balloons.size() == 0;
    }

    /**
     * Do a turn of the game
     * @throws NoNextCellException 
    */
    public void loop() throws NoNextCellException{
        List<GameObject> gameObjectToDestroy = new LinkedList<GameObject>();
        List<GameObject> gameObjectsToAdd = new LinkedList<>();

        // Clock des gameobjects
        for (GameObject gameObject : this.gameObjects) {
            boolean eventTrigerred = gameObject.onClock(this.clock);

            if (gameObject instanceof Bullet && eventTrigerred){
                Bullet b = (Bullet) gameObject;
                for (Effect e : b.getEffects()){
                    gameObjectsToAdd.add(e);
                }
            }

            if(gameObject.toDestroy()){
                gameObjectToDestroy.add(gameObject);
            }
        }

        // Clock des ballons
       /** for (Balloon balloon : this.balloons){
            balloon.onClock(this.clock);
            if(balloon.toDestroy()){
                gameObjectToDestroy.add(balloon);
            }
        }*/
       for(Tower t: this.towers){
            if(t.onClock(this.clock)){
                Bullet bullet = t.shoot(this.balloons);
                if (bullet != null){
                    gameObjectsToAdd.add(bullet);
                }
            }
       }

       for (GameObject newObj : gameObjectsToAdd){
            this.addGameObject(newObj);
       }


        // Destruction des objets à détruire
        for(GameObject gameObject : gameObjectToDestroy){
            this.DeleteGameObject(gameObject);
        }

        this.clock++;
    }

    public Set<Balloon> getBalloons(){
        return this.balloons;
    }

    public void setTower(Tower t){
        this.towers.add(t);
    }
    
    public void addBalloons(Balloon o){
        this.balloons.add(o);
    }

    public void addGameObject(GameObject o){
            this.gameObjects.add(o);
    }

    public void DeleteGameObject(GameObject gameObject){
        this.gameObjects.remove(gameObject);
        if(gameObject instanceof Balloon){
            this.balloons.remove((Balloon) gameObject);
        }
    }

    public void applyEffectToBalloonOnCells(List<Cell> cells,Effect effect){
        for(Balloon balloon : this.balloons){
                CellPath cellPath = balloon.getCell();
                Cell cellBalloon = cellPath.getCell();
                for(Cell cellToApply : cells){
                    if(cellBalloon.equals(cellToApply)){
                        effect.addTarget(balloon);
                        effect.onClock(this.clock);
                    }
                }
            }
        this.addGameObject(effect);
    }
}
