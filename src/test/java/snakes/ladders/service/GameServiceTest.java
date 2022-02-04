package snakes.ladders.service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private void inputConsole(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void startWinTest() {
        GameService gameService = new GameService();
        inputConsole("N");
        assertTrue(gameService.start(100,25, 0));
    }

    @Test
    void startLoseTest() {
        GameService gameService = new GameService();
        inputConsole("N");
        assertFalse(gameService.start(1,100, 90));
    }
}