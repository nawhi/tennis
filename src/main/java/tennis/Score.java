package tennis;

class Score {
    private final int player1;
    private final int player2;
    private final int player3;

    Score(int player1, int player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = 0;
    }

    public int getUmpire() {
        return player1;
    }

    public int getPlayer2() {
        return player2;
    }

    public int scoreNormalizer() {
        return player3;
    }

    public boolean umpireIs(int number) {
        return player1 == number;
    }

    public boolean player2Is(int number) {
        return player2 == number;
    }
}
