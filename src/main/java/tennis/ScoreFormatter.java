package tennis;

import java.util.HashMap;
import java.util.Map;

class ScoreFormatter {
    private static final String SEPARATOR = "-";
    private static final String ALL = "All";
    private static final String DEUCE = "Deuce";

    private static final Map<Integer, String> SCORES = new HashMap<>();
    static {
        SCORES.put(0, "Love");
        SCORES.put(1, "Fifteen");
        SCORES.put(2, "Thirty");
        SCORES.put(3, "Forty");
    }

    String deuce() {
        return DEUCE;
    }

    String advantage(int player) {
        return "Advantage Player " + player;
    }

    String game(int player) {
        return "Game Player " + player;
    }

    String simpleDraw(int score) {
        return SCORES.get(score) + SEPARATOR + ALL;
    }

    String simpleScore(int player1Score, int player2Score) {
        return SCORES.get(player1Score) + SEPARATOR + SCORES.get(player2Score);
    }
}
