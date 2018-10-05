import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class PokerHands {
    public Hand player1;
    public Hand player2;
    private int numberOfCards = 5;

    public PokerHands(String inputFile){
        try {
            BufferedReader file = new BufferedReader(new FileReader(inputFile));
            String line = file.readLine();
            String blackHand = line.substring(line.indexOf(":")+1, line.indexOf("White:"));
            String whiteHand = line.substring(line.lastIndexOf(":") + 1);
            String[] blackCards = blackHand.trim().split(" ");
            String[] whiteCards = whiteHand.trim().split(" ");
            System.out.println("P1: " + blackHand);
            System.out.println("P2: " + whiteHand);
            player1 = new Hand(blackCards);
            player2 = new Hand(whiteCards);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void compareHands() {
        getHandScore(player1);
        getHandScore(player2);
        if (player1.getHandScore() > player2.getHandScore())
            System.out.println("Player 1 wins");
        else
            System.out.println("player 2 wins");
    }

    private void getHandScore(Hand player) {
        if (hasThreeOfAKind(player)) {
            player.setHandScore(3);
            if (isThreeOfAKind(player.getCard(0), player.getCard(1), player.getCard(2))) {
                player.setHighCard(player.getValue(2));
            }
            else {
                player.setHighCard((player.getValue(4)));
            }
        }
        else if (hasTwoPair(player)) {
            player.setHandScore(2);
            if (isTwoPair(player.getCard(0), player.getCard(1), player.getCard(2), player.getCard(3))) {
                player.setHighCard(player.getValue(4));
            }
            else {
                player.setHighCard((player.getValue(5)));
            }
        }
        else if(hasPair(player)) {
            player.setHandScore(1);
            if (isPair(player.getCard(0), player.getCard(1)) || isPair(player.getCard(2), player.getCard(1))) {
                player.setHighCard(player.getValue(1));
            }
            else {
                player.setHighCard(player.getValue(3));
            }
        }
        else {
            player.setHandScore(0);
        }
    }

    private boolean hasTwoPair(Hand player) {
        for (int i = 0; i < numberOfCards - 3; i++) {
            if(isPair(player.getCard(i), player.getCard(i + 1)))
                for(int j = i; j < numberOfCards -1; j++) {
                    if(isPair(player.getCard(j), player.getCard(j + 1))) {
                        return true;
                    }
                }
        }
        return false;
    }

    private boolean isTwoPair(Card card1, Card card2, Card card3, Card card4) {
        return card1.getRank() == card2.getRank() && card3.getRank() == card4.getRank();
    }

    private boolean hasThreeOfAKind(Hand player) {
        for (int i = 0; i < numberOfCards - 2; i++) {
            if (isThreeOfAKind(player.getCard(i), player.getCard(i+1), player.getCard(i+2)))
                return true;
        }
        return false;
    }

    private boolean isThreeOfAKind(Card card1, Card card2, Card card3) {
        return card1.getRank() == card2.getRank() && card2.getRank() == card3.getRank();
    }

    private boolean hasPair(Hand player) {
        for (int i = 0; i < numberOfCards - 1; i++) {
            if(isPair(player.getCard(i), player.getCard(i + 1)))
                return true;
        }
        return false;
    }

    private boolean isPair(Card card1, Card card2) {
        return card1.getRank() == card2.getRank();
    }
}