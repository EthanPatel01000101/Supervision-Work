public class Game {
    Deck deck;
    Player player1;
    Player player2;
    UI ui;

    public Game() {
        deck = new Deck();
        this.player1 = new Player(this.deck);
        this.player2 = new Player(this.deck);
        this.ui = new UI();
        this.ui.displayTitle();

        while(this.player1.getNumOfCards() != 0 && this.player2.getNumOfCards() != 0) {
            this.playTurn();
            System.out.println("\n");
        }

        if (this.player1.getNumOfCards() == 0) {
            System.out.println("Player 2 Wins Overall");
        } else if (this.player2.getNumOfCards() == 0) {
            System.out.println("Player 1 Wins Overall");
        }

    }

    public boolean playTurn() {
        if (this.player1.getNumOfCards() == 0) {return false;}
        else if (this.player2.getNumOfCards() == 0) {return true;}
        else {
            Card drawCardPlayer1 = this.player1.drawCard();
            Card drawCardPlayer2 = this.player2.drawCard();
            this.ui.selectCards(drawCardPlayer1, drawCardPlayer2);
            int choose = drawCardPlayer1.isGreaterThan(drawCardPlayer2);
            if (choose == 2) {
                this.player1.addCard(drawCardPlayer1);
                this.player1.addCard(drawCardPlayer2);
                System.out.println("Player 1 Wins");
                System.out.println("Cards gained");
                this.ui.displayCards(drawCardPlayer1, drawCardPlayer2);
                return true;
            } else if (choose == 0) {
                this.player2.addCard(drawCardPlayer1);
                this.player2.addCard(drawCardPlayer2);
                System.out.println("Player 2 Wins");
                System.out.println("Cards gained");
                this.ui.displayCards(drawCardPlayer1, drawCardPlayer2);
                return false;
            } else if (choose == 1) {
                if (this.player1.getNumOfCards() == 0) {
                    System.out.println("Player 2 Wins");
                    return false;
                } else if (this.player2.getNumOfCards() == 0) {
                    System.out.println("Player 1 Wins");
                    return true;
                } else {
                    Card faceDownCardP1 = this.player1.drawCard();
                    Card faceDownCardP2 = this.player2.drawCard();
                    boolean isPlayer1Winner = this.playTurn();
                    if (isPlayer1Winner) {
                        this.player1.addCard(drawCardPlayer1);
                        this.player1.addCard(drawCardPlayer2);
                        this.player1.addCard(faceDownCardP1);
                        this.player1.addCard(faceDownCardP2);
                    } else {
                        this.player2.addCard(drawCardPlayer1);
                        this.player2.addCard(drawCardPlayer2);
                        this.player2.addCard(faceDownCardP1);
                        this.player2.addCard(faceDownCardP2);
                    }

                    System.out.println("Cards Gained");
                    drawCardPlayer1.print();
                    drawCardPlayer2.print();
                    faceDownCardP1.print();
                    faceDownCardP2.print();
                    return isPlayer1Winner;
                }
            } else {
                throw new IllegalStateException("Draw");
            }
        }
    }
}