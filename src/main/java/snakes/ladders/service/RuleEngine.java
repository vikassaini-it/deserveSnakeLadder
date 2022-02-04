package snakes.ladders.service;

import snakes.ladders.model.Obstacle;
import snakes.ladders.model.Player;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {

    List<Obstacle> obstacles = new ArrayList<>();

    RuleEngine(Obstacle[] initObstacles) {
        obstacles.addAll(List.of(initObstacles));
    }

    public void execute(Player player, Integer diceValue, Integer boardSize) {
        if (player.getPosition() + diceValue >= boardSize) {
            player.setPosition(boardSize);
            return;
        }
        for (Obstacle obstacle : obstacles) {
            if (obstacle.isCollision(player.getPosition() + diceValue)) {
                player.setPosition(obstacle.getNewPosition(player.getPosition() + diceValue));
                execute(player, 0, boardSize);
                return;
            }
        }
        if (diceValue != 0)
            player.setPosition(player.getPosition() + diceValue);
    }

}
