package collegeboard.elevens;

import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};


	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ElevensBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
		if (I_AM_DEBUGGING) {
			System.out.println(this);
			System.out.println("----------");
		}
	}
	
	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	
	private boolean containsPairSum11(List<Integer> selectedCards) {
		
		for (int i = 0; i < selectedCards.length; i++) {

			for (int j = i + 1; j < selectedCards.length; j++) {

				if (cards[selectedCards[i]].pointValue() + cards[selectedCards[j]].pointValue() == 11) {

					return true;

				}

			}

		}

		return false;

	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		
		boolean containsJ = false;
		boolean containsQ = false;
		boolean containsK = false;

		for (int i = 0; i < selectedCards.length; i++) {
		
			if (cards[selectedCards[i]].rank().equals("jack")) {

				containsJ = true;

			}

			else if (cards[selectedCards[i]].rank().equals("queen")) {

				containsQ = true;

			}

			else if (cards[selectedCards[i]].rank().equals("king")) {

				containsK = true;

			}

		}

		return containsJ && containsQ && containsK;

	}

	
	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	public boolean isLegal(List<Integer> selectedCards) {

		return containsPairSum11(selectedCards) || containsJQK(selectedCards);

	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	public boolean anotherPlayIsPossible() {
		
		// I'm trying to make allCards contain all of the cards currently on the board
		// but I don't think I did it properly.
		int allCards[] = new int[cards.length()];
		for (int i = 0; i < cards.length(); i++) {

			allCards[i] = i;

		}
		return containsPairSum11(allCards) || containsJQK(allCards);

	}	
}
