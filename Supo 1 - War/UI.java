public class UI {

    public void UI() {}
    public void displayTitle() {
        System.out.println("PLAYER                  COMPUTER");
    }

    public void selectCards(Card cardP1, Card cardP2) {
        System.out.print("Player 1: ");cardP1.print();
        System.out.print("Player 2: ");cardP2.print();
        System.out.println("\n");
    }
    public void displayCards(Card cardA, Card cardB) {
        cardA.print();
        cardB.print();
    }
}