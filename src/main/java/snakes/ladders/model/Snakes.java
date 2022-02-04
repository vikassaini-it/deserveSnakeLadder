package snakes.ladders.model;

import java.util.HashMap;
import java.util.Map;

public class Snakes implements Obstacle {

    public Snakes(Integer boardSize, Integer numberOfSnakes) {
        positions.keySet().removeAll(positions.keySet());
        initSnakes(boardSize, numberOfSnakes);
    }

    private void initSnakes(Integer boardSize, Integer numberOfSnakes) {
        int maxStart = boardSize-1, minStart=2;
        int maxEnd = boardSize-2, minEnd = 1;
        while (numberOfSnakes-- > 0) {
            Integer start = (int) (Math.random() * (maxStart - minStart + 1) + minStart);
            if (positions.containsKey(start)) {
                numberOfSnakes++;
                continue;
            }
            Integer tail = (int) (Math.random() * (start - minEnd) + minEnd);
            positions.put(start, tail);
        }
        System.out.println("Snake positions ->");
        positions.forEach((key, value) -> System.out.println("\tHead: "+ key + "\t Tail: "+ value));
    }

    @Override
    public boolean isCollision(Integer positionToTest) {
        boolean collision = positions.containsKey(positionToTest);
        if (collision) {
            System.out.println("Collision with snake's head at: " + positionToTest
            );
        }
        return collision;
    }

    @Override
    public Integer getNewPosition(Integer positionToTest) {
        return positions.get(positionToTest);
    }
}
