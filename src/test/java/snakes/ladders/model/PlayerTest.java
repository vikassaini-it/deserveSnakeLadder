package snakes.ladders.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getPositionTest() {
        Player player = new Player();
        assertEquals(1, player.getPosition());
    }

    @Test
    void setPositionTest() {
        Player player = new Player();
        player.setPosition(99);
        assertEquals(99, player.getPosition());
    }
}