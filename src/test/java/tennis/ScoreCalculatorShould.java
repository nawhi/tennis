package tennis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCalculatorShould {

    @Test
    void return_love_all_for_nil_nil() {
        ScoreCalculator calculator = new ScoreCalculator(new Score(0, 0));
        assertEquals("Love-All", calculator.score());
    }

    @Test
    void return_fifteen_love_for_1_nil() {
        ScoreCalculator calculator = new ScoreCalculator(new Score(1, 0));
        assertEquals("Fifteen-Love", calculator.score());
    }
}
