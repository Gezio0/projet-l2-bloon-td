package game;


public abstract class GameObject {
    private static int gameObjectCounter;
    private int id;
    private boolean destroyed;

    public int getId(){
        return this.id;
    }
    
    public void destroy(){
        this.destroyed = true;
    }

    public boolean toDestroy(){
        return this.destroyed;
    }

    public int hashCode() {
        return this.id;
    }

    public GameObject(){
        this.id = gameObjectCounter;
        gameObjectCounter++;
    }

    public abstract boolean onClock(int clock);
}