/**
*	@author Kedar Gangopadhyay
*/

public class Card implements Comparable<Card> {
	private int suit; // use integer 1-4 to encode suit
	private int value; // use integers 1-13 to encode values

	public Card (int s, int v) {
		this.suit = s;
		this.value = v;
	}

	/**
	* @return suit of the Card
	*/
	public int getSuit () {
		return this.suit;
	}

	/**
	* @return value of the Card
	*/
	public int getValue () {
		return this.value;
	}

	/**
	* @return the individual name of card
	*/
	public String toString () {
		String VALUE_NAME, SUIT_NAME;
		String cardName;

		switch (suit)
		{
		case 1: SUIT_NAME = "Clubs"; break;
		case 2: SUIT_NAME = "Diamonds"; break;
		case 3: SUIT_NAME = "Hearts"; break;
		case 4: SUIT_NAME = "Spades"; break;
		default: SUIT_NAME = " "; break;
		}

		switch (value)
		{
		case 1: VALUE_NAME = "Ace"; break;
		case 2: VALUE_NAME = "Two"; break;
		case 3: VALUE_NAME = "Three"; break;
		case 4: VALUE_NAME = "Four"; break;
		case 5: VALUE_NAME = "Five"; break;
		case 6: VALUE_NAME = "Six"; break;
		case 7: VALUE_NAME = "Seven"; break;
		case 8: VALUE_NAME = "Eight"; break;
		case 9: VALUE_NAME = "Nine"; break;
		case 10: VALUE_NAME = "Ten"; break;
		case 11: VALUE_NAME = "Jack"; break;
		case 12: VALUE_NAME = "Queen"; break;
		case 13: VALUE_NAME = "King"; break;
		default: VALUE_NAME = " "; break;
		}

		cardName = VALUE_NAME + " of " + SUIT_NAME;
		return cardName;
	}

	/**
	* @return BEFORE, AFTER, or EQUAL comparison of two cards
	*/
	public int compareTo(Card c) {
			final int BEFORE = -1;
			final int EQUAL = 0;
			final int AFTER = 1;

			if(this.suit == c.getSuit()) {
				if(this.value == c.getValue()) {
					return EQUAL;
				} else if(this.value < c.getValue()) {
					return BEFORE;
				} else {
					return AFTER;
				}
			} else if (this.suit < c.getSuit()) {
				return BEFORE;
			} else {
				return AFTER;
			}
	}

} // end class Card
