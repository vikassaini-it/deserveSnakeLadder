package snakes.ladders.service;

import snakes.ladders.model.Dice;
import snakes.ladders.model.Obstacle;
import snakes.ladders.model.Player;
import snakes.ladders.model.Snakes;

public class GameService {

    public Boolean start(Integer totalTries, Integer boardSize, Integer totalSnakes) {
        System.out.println("Board Size: "+ boardSize);
        System.out.println("Total Tries: "+ totalTries);
        Snakes snakes = new Snakes(boardSize, totalSnakes);
        Player player = new Player();
        RuleEngine ruleEngine = new RuleEngine(new Obstacle[]{snakes});
        Dice dice = new Dice();
        BoardService boardService = new BoardService(boardSize);
        return boardService.execute(dice, player, ruleEngine, totalTries);
    }


}
