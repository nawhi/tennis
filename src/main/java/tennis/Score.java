package tennis;

class Score {
    private int player1;
    private int player2;

    Score(int player1, int player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    int player1() {
        return player1;
    }

    int player2() {
        return player2;
    }
}
