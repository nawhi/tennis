package tennis;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class ScoreCalculator {
    private final Score score;

    ScoreCalculator(Score score) {
        this.score = score;
    }

    String score() {
        if (score.getUmpire() == 1 && score.getUmpire() == score.getPlayer2()) {
            return fifteenAll();
        } else if (score.getUmpire() == 0 && score.getUmpire() == score.getPlayer2())
            return loveAll();
        else if (score.getUmpire() * score.getPlayer2() == 9)
            return theScore();

        final ScoreDisplayFactory scoreDisplayFactory = new ScoreDisplayFactory(score);
        if (scoreDisplayFactory.shouldBeDisplayed()) {
            return scoreDisplayFactory.display();
        }

        if ((score.getUmpire() + score.getPlayer2() + score.scoreNormalizer() == 4))
            return Optional.of("Thirty-All").get();

        return scores()
        .get(score.getUmpire()) + "-Love";
//        else if (score.getUmpire() == 1)
//            return "Fifteen-Love";
//        else if (score.getUmpire() == 2)
//            return "Thirty-Love";
//        return "Love-All";
    }

    private List<String> scores() {
        return Arrays.asList("Love","Fifteen","Thirty");
    }

    private String theScore() {
        return "Deuce";
    }

    private String loveAll() {
        return "Love-All";
    }

    private String fifteenAll() {
        return "Fifteen-All";
    }
}
