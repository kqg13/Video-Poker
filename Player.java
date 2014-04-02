// **************************************************************
// Programming Assignment #4 (Video Poker)
// Written by Kedar Gangopadhyay (kg2576)
// This is the Player class which contains [ ] methods
// **************************************************************

import java.util.ArrayList;

public class Player {

	private ArrayList<Card> hand; // the Player's cards
	private int currentInHand;
	
	public Player() {
		hand = new ArrayList<Card> ();
		currentInHand = 0;
	} // end constructor
	
	public ArrayList getHand() {
		return hand;
	} // end method
	
	public void addCard (Card c) { //@param c
		hand.add(c);
		currentInHand++;
	} // end method
	
	public void removeCard (Card c) { //@param c
		hand.remove(c);
		currentInHand--;
	} // end method
	
	public int inHand() { // @return currentInHand how many on hand
		return currentInHand;
	} // end method
	
	public int sizeOfHand() {
		return hand.size();
	}
	
} // end class Player
