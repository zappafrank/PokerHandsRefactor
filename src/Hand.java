import java.util.*;

public class Hand {
    public List<Card> getCards() {
        return cards;
    }

    private List<Card> cards;
    int handScore;
    int highCard;

    public Hand(String[] input) {
        cards = new ArrayList<>(5);
        for (String anInput : input) {
            cards.add(new Card(anInput));
        }
        sort();
    }

    private void sort() {
        for (int i = 0; i < cards.size(); i++) {
            int minimumIndex = i;
            int minimum = getValue(i);
            for (int j = i + 1; j < cards.size(); j++){
                if(getValue(j) < minimum) {
                    minimum = getValue(j);
                    minimumIndex = j;
                }
            }
            Card temp = getCard(i);
            cards.set(i, getCard(minimumIndex));
            cards.set(minimumIndex, temp);
        }
    }

    public int getValue(int i) {
//        return cards.get(i).getRank();
        return 0;
    }

    public char getSuit(int i) {
//        return cards.get(i).getSuit();
        return 0;
    }

    public Card getCard(int i) {
        return cards.get(i);
    }

    public int getHandScore() {
        return handScore;
    }

    public int getHighCard() {
        return highCard;
    }

    public void setHandScore(int handScore) {
        this.handScore = handScore;
    }

    public void setHighCard(int i) {
        highCard = i;
    }
}
