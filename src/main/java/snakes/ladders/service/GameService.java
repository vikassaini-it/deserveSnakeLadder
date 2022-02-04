package snakes.ladders.service;

import snakes.ladders.model.Dice;
import snakes.ladders.model.Obstacle;
import snakes.ladders.model.Player;
import snakes.ladders.model.Snakes;

public class GameService {

    private Integer totalTries = 20;

    private final Integer boardSize = 100;

    private final Integer totalSnakes = 40;

    public void start() {
        System.out.println("Board Size: "+ boardSize);
        System.out.println("Total Tries: "+ totalTries);
        Snakes snakes = new Snakes(boardSize, totalSnakes);
        Player player = new Player();
        RuleEngine ruleEngine = new RuleEngine(new Obstacle[]{snakes});
        Dice dice = new Dice();
        execute(dice, player, ruleEngine);

    }

    private void execute(Dice dice, Player player, RuleEngine ruleEngine) {
        while (totalTries-- > 0) {
            System.out.println("");
            System.out.println("Rolling Dice");
            int diceValue= dice.rollDice();
            System.out.println("dice: "+ diceValue);
            ruleEngine.execute(player,diceValue, boardSize);
            if(player.getPosition() == boardSize){
                System.out.println("\n\n");
                System.out.println("Congratulations you won");
                System.out.println("Number of tries remaining: "+ totalTries);
                return;
            }
        }
        System.out.println("\n\n");
        System.out.println("You lost");

    }
}
