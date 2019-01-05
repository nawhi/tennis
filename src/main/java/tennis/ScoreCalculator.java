package tennis;

import java.util.HashMap;
import java.util.Map;

class ScoreCalculator {
    private Score score;
    private static final Map<Integer, String> SCORES = new HashMap<>();

    static {
        SCORES.put(1, "Fifteen");
        SCORES.put(2, "Thirty");
    }

    ScoreCalculator(Score score) {
        this.score = score;
    }

    String score() {
        if (score.player1() > 0)
            return SCORES.get(score.player1()) + "-Love";
        return "Love-All";
    }
}
