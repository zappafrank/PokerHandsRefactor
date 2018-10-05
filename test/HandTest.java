import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class HandTest {

    @Test
    public void handIsCreated() {
        Hand newHand = new Hand(new String[]{"4D"});
        List<Card> cards = newHand.getCards();
        Card card = cards.get(0);
        assertEquals(Rank.FOUR, card.getRank());
        assertEquals(Suit.D, card.getSuit());
    }

    @Test
    public void fullHand() {
        Hand newHand = new Hand(new String[]{"4D", "5D", "6D", "7D", "8D"});
        List<Card> cards = newHand.getCards();
        assertEquals(cards.size(), 5);
        for (Card card : cards) {
            assertEquals(Suit.D, card.getSuit());
            assertTrue(Arrays.asList(Rank.values()).contains(card.getRank()));
        }
    }
}