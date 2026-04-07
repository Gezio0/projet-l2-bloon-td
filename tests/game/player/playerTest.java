import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import game.balloon.Balloon;
import game.exception.NoNextCellException;
import game.exception.TooMuchPathsException;
import game.tower.*;
import game.tower.upgrade.*;
import game.path.*;
public class playerTest {
    private List<Effect> effects;
    private Bullet bullet;
    private Set<Balloon> balloons;
    private List<Path> paths;
    private List<Tower> towers;
    private List<Upgrade> upgrades;
    private Upgrade range1 ;
    private Upgrade range2 ;
    private Upgrade damage1 ;
    private UpgradeTree tree;
    private Shop shop;
    private Player player;
    @BeforeEach
    public void before() throws TooMuchPathsException,NoNextCellException{
        this.effects = new ArrayList<>();
        this.effects.add(new Damage("damage",0, false, 1));
        this.bullet = new Bullet(-1, 10, this.effects);
        List<Upgrade> upgradesClassic = new ArrayList<Upgrade>();
        this.range1 = new RangeUpgrade(0, 0.20);
        this.range2 = new RangeUpgrade(100000, 0.50);
        this.damage1 = new DamageUpgrade(0, 0.30);
        this.upgrades.add(range1);
        this.upgrades.add(range2);
        this.upgrades.add(damage1);
        this.tree = new UpgradeTree(upgrades);
        this.tree = new UpgradeTree(upgradesClassic);
        this.towers = new ArrayList<>();
        this.towers.add(new Tower(2, 80, this.bullet, 5,null, this.paths,this.tree,"tower"));
        
        towers.add(this.tower);
        towers.add(new Tower(2, 80000000, this.bullet, 5,null, this.paths,this.tree,"tower"));
        this.shop = new Shop(towers);
        this.player = new Player(this.shop);
    }
    @Test
    public void buyTowerEnoughMoneyTest(){
        assertTrue(this.player.buyTower(this.towers.get(0), 0, 0));
    }
    @Test
    public void buyTowerNotEnoughMoneyTest(){
        assertFalse(this.player.buyTower(towers.get(1), 0, 0));
    }
    @Test
    public void sellTowerTest(){
        this.player.buyTower(this.towers.get(0), 0, 0);
        assertTrue(this.player.sellTower(this.towers.get(0)));
    }
    @Test 
    public void canBuyTowerTest(){
        assertTrue(this.player.canBuyTower(this.towers.get(0)));
        assertFalse(this.player.canBuyTower(this.towers.get(1)));
    }
    @Test
    public void canBuyUpgradeTest(){
        this.player.buyTower(this.towers.get(0), 0, 0);
        assertTrue(this.player.canBuyUpgrade(this.towers.get(0),this.range1));
        assertFalse(this.player.canBuyUpgrade(this.towers.get(0),new DamageUpgrade(0,350)));
        assertFalse(this.player.canBuyUpgrade(this.towers.get(0),this.range2));
    }
    @Test
    public void buyUpgradeTest(){
        this.player.buyTower(this.towers.get(0), 0, 0);
        assertTrue(this.player.buyUpgrade(this.towers.get(0),this.range1));
        assertFalse(this.player.buyUpgrade(this.towers.get(0),new DamageUpgrade(0,350)));
        assertFalse(this.player.buyUpgrade(this.towers.get(0),this.range2));
    }    
    @Test
    public void sellUpgradeTest(){
        this.player.buyTower(this.towers.get(0), 0, 0);
        this.player.buyUpgrade(this.towers.get(0),this.range1);
        assertTrue(this.player.sellUpgrade(this.towers.get(0),this.range1));
        assertFalse(this.player.sellUpgrade(this.towers.get(0),this.range1));
        assertFalse(this.player.sellUpgrade(this.towers.get(0),this.range2));
    }
    
    



}
