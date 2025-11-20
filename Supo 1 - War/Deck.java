public class Deck {
    private Card[] cards = new Card[52];
    private String[] suits = {"Clubs", "Diamond", "Spades", "Hearts"};
    private String[] value = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public Deck() {
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < value.length; j++) {
                cards[(i*(value.length)) + j] = new Card(suits[i], value[j]);
            }
        }
    }

    public void print() {
        for (int i = 0; i < cards.length; i++) {
            System.out.println(cards[i].getSuit() + " " + cards[i].getValue());
        }
    }
}