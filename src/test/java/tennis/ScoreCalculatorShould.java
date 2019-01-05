package tennis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCalculatorShould {

    @ParameterizedTest
    @CsvSource({
            "0,0,Love-All",
            "1,0,Fifteen-Love"
    })
    void calculate_scores(int player1Score, int player2Score, String expectedScore) {
        ScoreCalculator calculator = new ScoreCalculator(new Score(player1Score, player2Score));
        assertEquals(expectedScore, calculator.score());
    }
}
