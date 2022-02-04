package snakes.ladders.model;

import java.util.HashMap;
import java.util.Map;

public interface Obstacle {
    Map<Integer, Integer> positions = new HashMap<>();

    boolean isCollision(Integer positionToTest);

    Integer getNewPosition(Integer positionToTest);
}
