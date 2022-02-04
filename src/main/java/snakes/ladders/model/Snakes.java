package snakes.ladders.model;

import java.util.Map;

public class Snakes implements Obstacles {

    public Snakes(Integer boardSize, Integer numberOfSnakes) {
        initSnakes(boardSize, numberOfSnakes);
    }

    private void initSnakes(Integer boardSize, Integer numberOfSnakes) {
        int maxStart = boardSize - 1, minStart = (boardSize / 2) + 1;
        int maxEnd = 1, minEnd = (boardSize / 2);
        while (numberOfSnakes-- > 0) {
            Integer start = (int) (Math.random() * (maxStart - minStart + 1) + minStart);
            if (position.containsKey(start)) {
                numberOfSnakes++;
                continue;
            }
            Integer tail = (int) (Math.random() * (maxEnd - minEnd + 1) + minEnd);
            position.put(start, tail);
        }
    }

    @Override
    public boolean isCollision(Integer positionToTest) {
        return position.containsKey(positionToTest);
    }

    @Override
    public Integer getNewPosition(Integer positionToTest) {
        return position.get(positionToTest);
    }

    public Map<Integer, Integer> getAllSnakes() {
        return position;
    }
}
