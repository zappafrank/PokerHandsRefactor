public class Card {
    private Rank rank;
    private Suit suit;

    public Card(String input) {
        String rankString = input.substring(0, 1);
        String suitString = input.substring(1, 2);
        this.rank = Rank.toRank(rankString);
        this.suit = Suit.valueOf(suitString);
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
