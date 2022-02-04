package snakes.ladders.model;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    private void inputConsole(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void diceNormalUpperLimitTest() {
        inputConsole("N");
        Dice dice = new Dice();
        assertTrue(dice.rollDice()<=6);
    }

    @Test
    void diceNormalLowerLimitTest() {
        inputConsole("N");
        Dice dice = new Dice();
        assertTrue(dice.rollDice()>=1);
    }

    @Test
    void diceCrookedEvenRollTest() {
        inputConsole("Y");
        Dice dice = new Dice();
        assertEquals(0, dice.rollDice() % 2);
    }
}