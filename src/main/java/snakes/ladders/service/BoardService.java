package snakes.ladders.service;

import snakes.ladders.model.Dice;
import snakes.ladders.model.Player;

public class BoardService {

    int boardSize;

    public BoardService(int initBoardSize){
        boardSize = initBoardSize;
    }

    public boolean execute(Dice dice, Player player, RuleEngine ruleEngine, Integer totalTries) {
        while (totalTries-- > 0) {
            System.out.println("");
            System.out.println("Rolling Dice");
            int diceValue = dice.rollDice();
            System.out.println("dice: " + diceValue);
            ruleEngine.executeRules(player, diceValue, boardSize);
            if (player.getPosition() == boardSize) {
                System.out.println("\n\n");
                System.out.println("Congratulations you won");
                System.out.println("Number of tries remaining: " + totalTries);
                return true;
            }
        }
        System.out.println("\n\n");
        System.out.println("You lost");
        return false;
    }

}
