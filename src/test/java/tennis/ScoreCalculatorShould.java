package tennis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCalculatorShould {

    @ParameterizedTest
    @CsvSource({
            "1,0,Fifteen-Love",
            "2,0,Thirty-Love",
            "3,0,Forty-Love",

            "0,1,Love-Fifteen",
            "0,2,Love-Thirty",
            "0,3,Love-Forty",

            "0,0,Love-All",
            "1,1,Fifteen-All",
            "2,2,Thirty-All",

            "2,1,Thirty-Fifteen",
            "3,1,Forty-Fifteen",
            "3,2,Forty-Thirty",

            "4,0,Game Player 1",
            "0,4,Game Player 2"
    })
    void calculate_scores(int player1Score, int player2Score, String expectedScore) {
        ScoreCalculator calculator = new ScoreCalculator(player1Score, player2Score);
        assertEquals(expectedScore, calculator.score());
    }
}
