package tennis;

public class ScoreDisplayFactory {
  private Score score;

  public ScoreDisplayFactory(Score score) {
    this.score = score;
  }

  public boolean shouldBeDisplayed() {
    return (score.getUmpire() != score.getPlayer2()) &&
            score.umpireIs(1) &&
            score.player2Is(3);
  }

  public String display() {
    return "Fifteen-Forty";
  }
}
