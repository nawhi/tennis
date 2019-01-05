package tennis;

class ScoreCalculator {
    private Score score;

    ScoreCalculator(Score score) {
        this.score = score;
    }

    String score() {
        if (score.player1() == 2)
            return "Thirty-Love";
        if (score.player1() == 1)
            return "Fifteen-Love";
        return "Love-All";
    }
}
