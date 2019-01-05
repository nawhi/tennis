package tennis;

import java.util.HashMap;
import java.util.Map;

class ScoreCalculator {
    private static final String SEPARATOR = "-";
    private static final String ALL = "All";
    private final int player1Score;
    private final int player2Score;
    private static final Map<Integer, String> SCORES = new HashMap<>();

    static {
        SCORES.put(0, "Love");
        SCORES.put(1, "Fifteen");
        SCORES.put(2, "Thirty");
        SCORES.put(3, "Forty");
    }

    ScoreCalculator(int player1Score, int player2Score) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    String score() {
        if (player1Score > 3) {
            return playerWins(1);
        }
        if (player2Score > 3) {
            return playerWins(2);
        }
        if (player1Score == player2Score) {
            return regularDraw();
        }
        return regularScore();
    }

    private String playerWins(int player) {
        return "Game Player " + player;
    }

    private String regularScore() {
        return SCORES.get(player1Score) + SEPARATOR + SCORES.get(player2Score);
    }

    private String regularDraw() {
        return SCORES.get(player2Score) + SEPARATOR + ALL;
    }
}
