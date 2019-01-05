package tennis;

import java.util.HashMap;
import java.util.Map;

class ScoreCalculator {
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

    private final int player1Score;
    private final int player2Score;
    private final int difference;
    private final ScoreFormatter formatter;

    ScoreCalculator(int player1Score, int player2Score) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.difference = calcDifference();
        formatter = new ScoreFormatter();
    }

    String score() {
        if (goneToDeuce()) {
            return endgame();
        }

        if (gotAWinner()) {
            return formatter.game(leadingPlayer());
        }


        return regularScore();
    }

    private String regularScore() {
        if (difference == 0) {
            return formatter.simpleDraw(player1Score);
        }
        return formatter.simpleScore(player1Score, player2Score);
    }

    private boolean gotAWinner() {
        return player1Score > 3 || player2Score > 3;
    }

    private boolean goneToDeuce() {
        return player1Score >= 3 && player2Score >= 3;
    }

    private String endgame() {
        if (difference > 1)
            return formatter.game(leadingPlayer());
        if (difference == 1) {
            return formatter.advantage(leadingPlayer());
        }
        return formatter.deuce();
    }

    private int leadingPlayer() {
        return (player2Score > player1Score) ? 2 : 1;
    }

    private int calcDifference() {
        return Math.abs(player2Score - player1Score);
    }

}
