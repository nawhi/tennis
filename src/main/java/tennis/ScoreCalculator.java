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

    ScoreCalculator(int player1Score, int player2Score) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    String score() {
        if (goneToDeuce()) {
            return endgameScore();
        }

        if (gotAWinner()) {
            return winner();
        }

        return regularScore();
    }

    private String regularScore() {
        if (player1Score == player2Score) {
            return simpleDraw();
        }
        return simpleScore();
    }

    private boolean gotAWinner() {
        return player1Score > 3 || player2Score > 3;
    }

    private String winner() {
        return "Game " + leadingPlayer();
    }

    private boolean goneToDeuce() {
        return player1Score >= 3 && player2Score >= 3;
    }

    private String endgameScore() {
        if (player1Score == player2Score) {
            return DEUCE;
        }
        if (scoreDifference() > 1)
            return winner();
        return "Advantage " + leadingPlayer();
    }

    private String leadingPlayer() {
        return (player2Score > player1Score) ? "Player 2" : "Player 1";
    }

    private int scoreDifference() {
        return Math.abs(player2Score - player1Score);
    }

    private String playerWins(int player) {
        return "Game Player " + player;
    }

    private String simpleDraw() {
        return SCORES.get(player2Score) + SEPARATOR + ALL;
    }

    private String simpleScore() {
        return SCORES.get(player1Score) + SEPARATOR + SCORES.get(player2Score);
    }
}
