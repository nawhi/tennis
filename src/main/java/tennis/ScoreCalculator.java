package tennis;

import java.util.HashMap;
import java.util.Map;

class ScoreCalculator {
    private Score score;
    private static final Map<Integer, String> SCORES = new HashMap<>();

    static {
        SCORES.put(0, "Love");
        SCORES.put(1, "Fifteen");
        SCORES.put(2, "Thirty");
        SCORES.put(3, "Forty");
    }

    ScoreCalculator(Score score) {
        this.score = score;
    }

    String score() {
        if (score.player1() != score.player2())
            return SCORES.get(score.player1()) + "-" + SCORES.get(score.player2());
        return "Love-All";
    }
}
