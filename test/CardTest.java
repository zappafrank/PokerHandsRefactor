import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void card() {
        Card twoOfHearts = new Card("2H");
        assertEquals(Rank.TWO, twoOfHearts.getRank());
        assertEquals(Suit.H, twoOfHearts.getSuit());
    }

    @Test(expected = RuntimeException.class)
    public void badRank() {
        Card badRank = new Card("1H");
    }

}