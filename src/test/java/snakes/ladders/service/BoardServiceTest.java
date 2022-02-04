package snakes.ladders.service;

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

class BoardServiceTest {

    private void inputConsole(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void executeWinTest() {
        BoardService boardService = new BoardService(100);
        Player player = new Player();
        inputConsole("N");
        Dice diceMock = Mockito.mock(Dice.class);

        Mockito.when(diceMock.rollDice()).thenReturn(0);
        player.setPosition(100);

        Snakes snakes = new Snakes(100, 1);
        RuleEngine ruleEngine = new RuleEngine(new Obstacle[]{snakes});

        assertTrue(boardService.execute(diceMock, player, ruleEngine,1));

    }

    @Test
    void executeLoseTest() {
        BoardService boardService = new BoardService(100);
        Player player = new Player();
        inputConsole("N");
        Dice diceMock = Mockito.mock(Dice.class);

        Mockito.when(diceMock.rollDice()).thenReturn(0);
        player.setPosition(1);

        Snakes snakes = new Snakes(100, 1);
        RuleEngine ruleEngine = new RuleEngine(new Obstacle[]{snakes});

        assertFalse(boardService.execute(diceMock, player, ruleEngine,1));

    }
}