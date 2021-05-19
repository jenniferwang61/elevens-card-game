
package collegeboard.elevens;

public class CardTester {
	/**
	* The main method in this class checks the Card operations for consistency.
	*  @param args is not used.
	*/
	public static void main(String[] args) {
		Card card1 = new Card("nine", "hearts", 9);
		Card card2 = new Card("ten", "hearts", 10);
		Card card3 = new Card("eleven", "hearts", 11);
		System.out.println(card1.rank() + card1.suit() + card1.pointValue());
		System.out.println(card2.rank() + card2.suit() + card2.pointValue());
		System.out.println(card3.rank() + card3.suit() + card3.pointValue());
		System.out.println("" + card1.matches(card2) + card1.matches(card3) + card2.matches(card3));
		System.out.println(card1.toString());
		System.out.println(card2.toString());
		System.out.println(card3.toString());
	}
}
 
 