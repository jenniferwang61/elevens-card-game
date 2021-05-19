package collegeboard.elevens;

public class DeckTester {
    
    /**
     * The main method in this class checks the Deck operations for consistency.
     *  @param args is not used.
     */
    public static void main(String[] args) {
        String[ ] ranks1 = {"one", "two", "three"};
        String[ ] ranks2 = {"four", "five", "six"};
        String[ ] ranks3 = {"seven", "eight", "nine"};
        String[ ] suits1 = {"A", "B"};
        String[ ] suits2 = {"C", "D"};
        String[ ] suits3 = {"E", "F"};
        int[ ] pv1 = {1, 2, 3};
        int[ ] pv2 = {4, 5, 6};
        int[ ] pv3 = {7, 8, 9};
        /* ^^ Do I have to write the arrays out like that? Is is possible to write the following:
        Deck deck0 = new Deck({"ten", "eleven", "twelve"}, {"G", "H"}, {10, 11, 12});
        To be clear, I already wrote that and I got a bunch of syntax errors. Is there any way around it otherwise?
        */ 
        Deck deck1 = new Deck(ranks1, suits1, pv1);
        Deck deck2 = new Deck(ranks2, suits2, pv2);
        Deck deck3 = new Deck(ranks3, suits3, pv3);
        System.out.println("" + deck1.isEmpty() + deck2.isEmpty() + deck3.isEmpty());
        System.out.println("" + deck1.size() + deck2.size() + deck3.size());
        System.out.println("" + deck1.deal() + deck2.deal() + deck3.deal());
        System.out.println("" + deck1.size() + deck2.size() + deck3.size());

        String[ ] ranksReal = {"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
        String[ ] suitsReal = {"diamonds", "clubs", "hearts", "spades"};
        int[ ] pvReal = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Deck deckReal = new Deck(ranksReal, suitsReal, pvReal);
        System.out.println(deckReal.toString());
        deckReal.shuffle();
        System.out.println(deckReal.toString());
        // Why is the print order so weird?
    }
}