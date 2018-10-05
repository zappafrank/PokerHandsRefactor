import org.junit.Test;

import static org.junit.Assert.*;

public class HandDeterminerTest {

    @Test
    public void pairWins() {
        Hand winningHand = new Hand(new String[]{"2C", "2H", "4S", "8C", "AH"});
        Hand losingHand = new Hand(new String[]{"2C", "4H", "5S", "8C", "AH"});
        Hand actualWinningHand = new HandDeterminer(winningHand, losingHand).chooseWinner();
        assertEquals(winningHand, actualWinningHand);
    }
}