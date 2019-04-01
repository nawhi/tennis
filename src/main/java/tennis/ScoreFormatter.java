package tennis;

import java.util.HashMap;
import java.util.Map;

class ScoreFormatter {

    private static final Map<Integer, String> SCORES = Map.of(
            0, "Love",
            1, "Fifteen",
            2, "Thirty",
            3, "Forty"
    );

    String simpleScore(int player1Score, int player2Score) {
        return SCORES.get(player1Score) + "-" + SCORES.get(player2Score);
    }

    String simpleDraw(int score) {
        return SCORES.get(score) + "-All";
    }

    String deuce() {
        return "Deuce";
    }

    String advantage(int player) {
        return "Advantage Player " + player;
    }

    String game(int player) {
        return "Game Player " + player;
    }
}
