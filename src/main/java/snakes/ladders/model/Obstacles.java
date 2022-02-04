package snakes.ladders.model;

import java.util.HashMap;
import java.util.Map;

public interface Obstacles {
    Map<Integer, Integer> position = new HashMap<>();

    boolean isCollision(Integer positionToTest);

    Integer getNewPosition(Integer positionToTest);
}
