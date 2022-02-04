package snakes.ladders;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SnakesAndLadderTest {

    private void inputConsole(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }


    @Test
    void mainTest() {
        String[] args = new String[]{};
        inputConsole("N");
        assertNotNull(SnakesAndLadder.main(args));
    }
}