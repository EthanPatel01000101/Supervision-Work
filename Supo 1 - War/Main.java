public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Card currentCard;
        for (int i = 0; i < 52; i++) {
            currentCard = deck.selectCard();
            currentCard.print();
        }
    }
}