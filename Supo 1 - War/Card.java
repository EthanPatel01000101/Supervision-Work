public class Card {
    private String suit; //D -> Diamond, C -> Clubs, S -> Spade, H -> hearts
    private String value; //number -> number, K -> King, Q -> Queen, J -> Jack, A -> Ace

    public Card(String mySuit, String myNum) {
        this.suit = mySuit;
        this.value = myNum;
    }

    public String getSuit() {return this.suit;}
    public String getValue() {return this.value;}
}