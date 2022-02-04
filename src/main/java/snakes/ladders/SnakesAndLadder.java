package snakes.ladders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import snakes.ladders.service.GameService;

class SnakesAndLadder {

    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.start();
    }

}
