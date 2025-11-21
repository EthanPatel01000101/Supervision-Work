import java.util.Queue;
import java.util.LinkedList;

public class Player {
    private Queue<Card> hand;
    private int numOfCards;

    public Player(Deck deck) {
        this.hand = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            this.hand.add(deck.selectCard());
        }
        this.numOfCards = 26;
    }

    public Card drawCard() {
        this.numOfCards -= 1;
        return this.hand.poll();
    }

    public void addCard(Card card) {
        this.numOfCards += 1;
        this.hand.add(card);
    }

    public int getNumOfCards() {return this.numOfCards;}
}