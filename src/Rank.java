enum Rank {

    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    T(10),
    J(11),
    Q(12),
    K(13),
    A(14);

    private int cardValue;

    Rank(int cardValue) {
        this.cardValue = cardValue;
    }

    public int getCardValue() {
        return cardValue;
    }

    public static Rank toRank(String rankString) {
        for (Rank rank : values()) {
            if (Integer.valueOf(rankString) == rank.getCardValue()) {
                return rank;
            }
        }
        throw new RuntimeException("rank does not exist");
    }
}
