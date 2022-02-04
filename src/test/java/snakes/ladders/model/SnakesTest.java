package snakes.ladders.model;

import org.assertj.core.util.diff.myers.Snake;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SnakesTest {

    @Test
    void isCollisionTrueTest() throws NoSuchFieldException, IllegalAccessException {
        Field reader = Obstacle.class.getDeclaredField("positions");
        reader.setAccessible(true);
        Obstacle snakes = new Snakes(100, 98);
        Map<Integer, Integer> positions = (Map<Integer, Integer>) reader.get(snakes);
        Integer head = (Integer) positions.keySet().toArray()[0];
        assertTrue(snakes.isCollision(head));
    }

    @Test
    void isCollisionFalseTest() throws NoSuchFieldException, IllegalAccessException {
        Field reader = Obstacle.class.getDeclaredField("positions");
        reader.setAccessible(true);
        Obstacle snakes = new Snakes(100, 1);
        Map<Integer, Integer> positions = (Map<Integer, Integer>) reader.get(snakes);
        Integer head = ((Integer) positions.keySet().toArray()[0])+1;
        assertFalse(snakes.isCollision(head));
    }

    @Test
    void getNewPositionTest() throws NoSuchFieldException, IllegalAccessException {
        Field reader = Obstacle.class.getDeclaredField("positions");
        reader.setAccessible(true);
        Obstacle snakes = new Snakes(100, 1);
        Map<Integer, Integer> positions = (Map<Integer, Integer>) reader.get(snakes);
        Integer head = ((Integer) positions.keySet().toArray()[0]);
        assertEquals(positions.get(head), snakes.getNewPosition(head));
    }
}