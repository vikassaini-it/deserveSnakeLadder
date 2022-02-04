package snakes.ladders.service;

import org.dom4j.rule.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import snakes.ladders.model.Dice;
import snakes.ladders.model.Obstacle;
import snakes.ladders.model.Player;
import snakes.ladders.model.Snakes;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class RuleEngineTest {

    private void inputConsole(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void executeRulesWinConditionTest() {
        Snakes snakesMock = Mockito.mock(Snakes.class);
        RuleEngine ruleEngine = new RuleEngine(new Obstacle[]{snakesMock});
        inputConsole("N");
        Dice diceMock = Mockito.mock(Dice.class);
        Player player = new Player();
        player.setPosition(99);

        ruleEngine.executeRules(player,1,100);

        assertEquals(100, player.getPosition());

    }

    @Test
    void executeRulesCollisionTest() {
        Snakes snakesMock = Mockito.mock(Snakes.class);
        RuleEngine ruleEngine = new RuleEngine(new Obstacle[]{snakesMock});
        inputConsole("N");
        Dice diceMock = Mockito.mock(Dice.class);
        Player player = new Player();
        player.setPosition(50);

        Mockito.when(snakesMock.isCollision(51)).thenReturn(true);
        Mockito.when(snakesMock.getNewPosition(51)).thenReturn(25);

        ruleEngine.executeRules(player,1,100);

        assertEquals(25, player.getPosition());
    }

    @Test
    void executeRulesNoCollisionTest() {
        Snakes snakesMock = Mockito.mock(Snakes.class);
        RuleEngine ruleEngine = new RuleEngine(new Obstacle[]{snakesMock});
        inputConsole("N");
        Dice diceMock = Mockito.mock(Dice.class);
        Player player = new Player();
        player.setPosition(50);

        Mockito.when(snakesMock.isCollision(55)).thenReturn(false);

        ruleEngine.executeRules(player,5,100);

        assertEquals(55, player.getPosition());
    }

    @Test
    void executeRulesCollisionChainingTest() {
        Snakes snakesMock = Mockito.mock(Snakes.class);
        RuleEngine ruleEngine = new RuleEngine(new Obstacle[]{snakesMock});
        inputConsole("N");
        Dice diceMock = Mockito.mock(Dice.class);
        Player player = new Player();
        player.setPosition(50);

        Mockito.when(snakesMock.isCollision(51)).thenReturn(true);
        Mockito.when(snakesMock.getNewPosition(51)).thenReturn(25);

        Mockito.when(snakesMock.isCollision(25)).thenReturn(true);
        Mockito.when(snakesMock.getNewPosition(25)).thenReturn(10);

        ruleEngine.executeRules(player,1,100);

        assertEquals(10, player.getPosition());
    }
}