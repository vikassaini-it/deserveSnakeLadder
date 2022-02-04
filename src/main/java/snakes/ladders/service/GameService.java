package snakes.ladders.service;

import snakes.ladders.model.Dice;
import snakes.ladders.model.Obstacles;
import snakes.ladders.model.Player;
import snakes.ladders.model.Snakes;

public class GameService {

    private Integer totalTries = 20;

    private Integer boardSize = 100;

    private Integer totalSnakes = 1;

    public void start() {

        Dice dice = new Dice();
        Player player = new Player();
        Snakes snakes = new Snakes(boardSize, totalSnakes);
        RuleEngine ruleEngine = new RuleEngine(new Obstacles[]{snakes});
        execute(dice, player, ruleEngine);

    }

    private void execute(Dice dice, Player player, RuleEngine ruleEngine) {
        while (totalTries-- > 0) {
            int newDicePosition = dice.rollDice();

        }

    }
}
