public class ScratchCard {
    int cardNumber;
    int[] winningNumbers;
    int[] userNumberChoice;

    public ScratchCard (int cardNum, int[] winNum, int[] userNum) {
        cardNumber = cardNum;
        winningNumbers = winNum;
        userNumberChoice = userNum;
    }

    public int matches(int[] cardWin, int[] cardUser) {
        int score = 0;
        boolean firstTime = true;
        for (int i = 0; i < cardWin.length; i++) {
            for (int j = 0; j < cardUser.length; j++) {
                if (cardUser[j] == cardWin[i] && cardUser[j] != 0 && cardWin[i] != 0) {
                    if (firstTime) {
                        score = 1;
                        firstTime = false;
                    } else {
                        score *= 2;
                    }
                }
            }
        }
        return score;
    }
    public int scratchCards(int[] winning, int[] other) {
        int copy = 1;
        int card = 0;
        boolean firstTime = true;
        int[] instance = new int[100000];
        for (int i = 0; i < winning.length; i++) {
            for (int j = 0; j < other.length; j++) {
                if (winning[j] == other[i] && other[j] != 0 && winning[i] != 0) {
                    card = winning[i];
                    instance[j] = card;
                    copy++;
                }
            }
        }
        return copy;
    }
}

