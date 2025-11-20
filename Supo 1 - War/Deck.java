import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.lang.Integer;

public class Deck {
    private Card[] cards = new Card[52];
    private String[] suits = {"Clubs", "Diamond", "Spades", "Hearts"};
    private String[] value = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private List<Integer> selectedIndexs = new ArrayList<>();

    public Deck() {
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < value.length; j++) {
                cards[(i*(value.length)) + j] = new Card(suits[i], value[j]);
            }
        }
    }

    public Card selectCard() {
        if (selectedIndexs.size() >= 52) {
            throw new IllegalStateException("No Cards left in the deck");
        }
        else {
            Random generator = new Random();
            int index = generator.nextInt(52);
            while (selectedIndexs.contains(index)) {
                index = generator.nextInt(52);
            }
            selectedIndexs.add(index);
            return cards[index];
        }
    }
}