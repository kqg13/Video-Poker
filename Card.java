// **************************************************************
// Programming Assignment #4 (Video Poker)
// Written by Kedar Gangopadhyay (kg2576)
// This is the Card class which contains [ ] methods
// **************************************************************

public class Card {
	private int suit; // use integer 1-4 to encode the suit
	private int value; // use integers 1-13 to encode the values
	
	public Card (int s, int v) { // @param s the suits @param v the values
		suit = s;
		value = v;
	} // end constructor
	
	public int Suit () { // @return the suit
		return suit;
	} // end method
	
	public int Value () { // @return the value
		return value;
	} // end method
	
	public String toString () { // @return cardName the individual card
		String VALUE_NAME, SUIT_NAME;
		String cardName;
		
		switch (suit)
		{
		case 1: SUIT_NAME = "Clubs"; break;
		case 2: SUIT_NAME = "Diamonds"; break;
		case 3: SUIT_NAME = "Hearts"; break;
		case 4: SUIT_NAME = "Spades"; break;
		default: SUIT_NAME = " "; break;
		} // end suit switch
	
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
		} // end value switch
		
		cardName = VALUE_NAME + " of " + SUIT_NAME;
		return cardName;
	
	} //end method
	
} // end class Card
