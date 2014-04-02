// **************************************************************
// Programming Assignment #4 (Video Poker)
// Written by Kedar Gangopadhyay (kg2576)
// This is the Deck class which contains [ ] methods
// **************************************************************

public class Deck {

	private Card [] theDeck;
	private int top; // the index of the top of the deck
	private final int TOTAL_CARDS = 52;
	
	public Deck () {
		theDeck = new Card [TOTAL_CARDS];
		top = 0;
		
		int suit = 1;
		int value = 1;
		
		for (int i = 0; i < theDeck.length; i++)
		{
			theDeck[i] = new Card (suit, value);
			value++;
			if (value > 13) { // new suit
				suit++;
				value = 1;
			} // end if
		} // end loop
	} // end constructor

	public Card[] returnDeck() { // @return theDeck an ordered deck
		return theDeck;
	}
	
	public void shuffle () { // shuffles an ordered deck
		int firstCard = 0;
		int secondCard = 0;

		for (int i = 0; i <= 1000; i++) // swaps two Card elements in theDeck
		{
			firstCard = (int) (Math.random () * TOTAL_CARDS);
			secondCard = (int) (Math.random () * TOTAL_CARDS);
			
			Card temp = theDeck[firstCard];
			theDeck[firstCard] = theDeck[secondCard];
			theDeck[secondCard] = temp;
		} // end loop
	} // end method

	public Card deal() { // @return theDeck[top++] next Card in deck
		return theDeck[top++];
	} // end method
	
	public Card resetDeck() {
		top = 0;
		return theDeck[top];
	} // end method
	
	public int getTop() { // @return
		return top;
	} // end method
	
} // end class Deck
