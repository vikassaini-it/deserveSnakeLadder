package snakes.ladders.service;

import snakes.ladders.model.Obstacles;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {

    List<Obstacles> obstacles = new ArrayList<>();

    RuleEngine(Obstacles[] initObstacles) {
        obstacles.addAll(List.of(initObstacles));
    }

}
