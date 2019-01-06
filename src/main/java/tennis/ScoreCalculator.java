package tennis;

class ScoreCalculator {

    private final int scoreP1;
    private final int scoreP2;
    private final ScoreFormatter formatter;
    private final int leadingPlayer;
    private final int difference;

    ScoreCalculator(int scoreP1, int scoreP2) {
        this.scoreP1 = scoreP1;
        this.scoreP2 = scoreP2;
        this.formatter = new ScoreFormatter();
        this.leadingPlayer = (scoreP2 > scoreP1) ? 2 : 1;
        this.difference = Math.abs(this.scoreP2 - this.scoreP1);
    }

    String score() {
        if (goneToDeuce()) {
            return endgame();
        }

        if (gotRegularWinner()) {
            return formatter.game(leadingPlayer);
        }

        return regularScore();
    }

    private boolean goneToDeuce() {
        return scoreP1 >= 3 && scoreP2 >= 3;
    }

    private String endgame() {
        if (difference == 0) {
            return formatter.deuce();
        }
        if (difference == 1) {
            return formatter.advantage(leadingPlayer);
        }
        return formatter.game(leadingPlayer);
    }

    private boolean gotRegularWinner() {
        return scoreP1 > 3 || scoreP2 > 3;
    }

    private String regularScore() {
        if (difference == 0) {
            return formatter.simpleDraw(scoreP1);
        }
        return formatter.simpleScore(scoreP1, scoreP2);
    }
}
