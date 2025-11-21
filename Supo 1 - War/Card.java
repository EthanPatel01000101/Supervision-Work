public class Card {
    private String suit; //D -> Diamond, C -> Clubs, S -> Spade, H -> hearts
    private String value; //number -> number, K -> King, Q -> Queen, J -> Jack, A -> Ace

    public Card(String mySuit, String myNum) {
        this.suit = mySuit;
        this.value = myNum;
    }

    public String getSuit() {return this.suit;}
    public String getValue() {return this.value;}

    public void print() {
        System.out.println(this.value + " " + this.suit);
    }

    public int isGreaterThan(Card card) {
        int thisValue = this.convertValue();
        int cardValue = card.convertValue();
        if (cardValue > thisValue) {
            return 0;
        }
        else if (cardValue < thisValue) {
            return 2;
        }
        else {
            return 1;
        }
    }

    public int convertValue() { //Converts the Value to something we can easily compare
        if (this.value.equals("J")) {return 11;}
        else if (this.value.equals("Q")) {return 12;}
        else if (this.value.equals("K")) {return 13;}
        else if (this.value.equals("A")) {return 14;}
        else {return Integer.parseInt(this.value);}
    }
}