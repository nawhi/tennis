package tennis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCalculatorShould {

  @ParameterizedTest
  @CsvSource({
          "0,0,Love-All",
          "1,0,Fifteen-Love",
          "2,0,Thirty-Love",
          "1,1,Fifteen-All",
          "3,3,Deuce",
          "2,2,Thirty-All",
          "1,3,Fifteen-Forty"

  })
  void return_correct_scores_as_string(int p1score, int p2score, String expectedResult) {
    final ScoreCalculator calculator = new ScoreCalculator(new Score(p1score, p2score));
    assertEquals(expectedResult, calculator.score());
  }

}
