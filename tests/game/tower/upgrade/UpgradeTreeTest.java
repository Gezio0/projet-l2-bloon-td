package game.tower.java;
import java.util.*;
import game.balloon.*;
import game.path.*;
import game.tower.upgrade.RangeUpgrade;
import game.tower.upgrade.UpgradeTree;
import game.exception.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UpgradeTreeTest {
    
    @BeforeEach
    public void before(){
        List upgrades = new ArrayList<>();
        Upgrade range1 = new RangeUpgrade(0, 0.20);
        Upgrade range2 = new RangeUpgrade(0, 0.50);
        Upgrade damage1 = new RangeUpgrade(0, 0.30);
        upgrades.add(range1);
        upgrades.add(range2);
        upgrades.add(damage1);
        UpgradeTreeTest tree = new UpgradeTree(upgrades);
    }

    @Test
    public void buyTest(){
        tree.buy(range1);
        assertEquals(range1,tree.getActiveUpgrades()[0]);
    }

        @Test
    public void sellTest(){
        tree.buy(range1);
        tree.sell(range1);
        assertTrue(tree.getActiveUpgrades().isEmpty());
    }
}
