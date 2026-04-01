import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private Tower tower;
    private List<Upgrade> upgrades;
    private Upgrade range1 ;
    private Upgrade range2 ;
    private Upgrade damage1 ;
    private UpgradeTree tree;
    @BeforeEach
    public void before() throws TooMuchPathsException,NoNextCellException{
        this.effects = new ArrayList<>();
        this.effects.add(new Damage("damage",0, false, 1));
        this.bullet = new Bullet(-1, 10, this.effects);
        List<Upgrade> upgradesClassic = new ArrayList<Upgrade>();
        this.range1 = new RangeUpgrade(0, 0.20);
        this.range2 = new RangeUpgrade(0, 0.50);
        this.damage1 = new DamageUpgrade(0, 0.30);
        this.upgrades.add(range1);
        this.upgrades.add(range2);
        this.upgrades.add(damage1);
        this.tree = new UpgradeTree(upgrades);
        this.tree = new UpgradeTree(upgradesClassic);
        this.tower = new Tower(2, 80, this.bullet, 5,new Cell(3,1), this.paths,this.tree,"tower");
    }
}
