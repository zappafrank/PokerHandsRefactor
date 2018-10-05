import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PokerHands2Test {
    private String inputFile;

    @Before
    public void setUp() throws Exception {
        inputFile = "test.txt";
    }

    @Test
    public void createTenOfSpades() throws Exception {
        String input = "TS";
        Card card = new Card(input);
        assertEquals(10, card.getRank());
        assertEquals('S', card.getSuit());
    }

    @Test
    public void createTwoOfHearts() throws Exception {
        String input = "2H";
        Card card = new Card(input);
        assertEquals(2, card.getRank());
        assertEquals('H', card.getSuit());
    }

    @Test
    public void createHand() throws Exception {
        String[] input = {"4D", "5D", "6D", "7D", "8D"};
        Hand hand = new Hand(input);
        assertEquals(4, hand.getValue(0));
        assertEquals('D', hand.getSuit(0));
        assertEquals(5, hand.getValue(1));
        assertEquals('D', hand.getSuit(1));
        assertEquals(6, hand.getValue(2));
        assertEquals('D', hand.getSuit(2));
        assertEquals(7, hand.getValue(3));
        assertEquals('D', hand.getSuit(3));
        assertEquals(8, hand.getValue(4));
        assertEquals('D', hand.getSuit(4));
    }

    @Test
    public void pairOfCards() throws Exception {
        String poker = "Black: 2H 5D 6S KC KD White: 2C 3H 4S 8C AH";
        writeToFile(poker);
        PokerHands pokerHands = new PokerHands(inputFile);
        pokerHands.compareHands();
        assertEquals(1, pokerHands.player1.getHandScore());
        assertEquals(13, pokerHands.player1.getHighCard());
    }

    @Test
    public void threeOfAKind() throws Exception {
        String poker = "Black: 2H 5D KS KC KD White: 2C 3H 4S 8C AH";
        writeToFile(poker);
        PokerHands pokerHands = new PokerHands(inputFile);
        pokerHands.compareHands();
        assertEquals(3, pokerHands.player1.getHandScore());
        assertEquals(13, pokerHands.player1.getHighCard());
    }

    @Test
    public void player2Wins() throws Exception {
        String poker = "Black: 2C 3H 4S 8C AH White: 2H 5D TS KC KD";
        writeToFile(poker);
        PokerHands pokerHands = new PokerHands(inputFile);
        pokerHands.compareHands();
        assertEquals(1, pokerHands.player2.getHandScore());
        assertEquals(13, pokerHands.player2.getHighCard());
    }

    @Test
    public void twoPairOfCards() throws Exception {
        String poker = "Black: 2H 2D 6S 6C KD White: 2C 3H 4S 8C AH";
        writeToFile(poker);
        PokerHands pokerHands = new PokerHands(inputFile);
        pokerHands.compareHands();
        assertEquals(2, pokerHands.player1.getHandScore());
        assertEquals(13, pokerHands.player1.getHighCard());
    }

    private void writeToFile(String poker) {
        BufferedWriter writeFile;
        try {
            writeFile = new BufferedWriter(new FileWriter(inputFile));
            writeFile.write(poker);
            writeFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
