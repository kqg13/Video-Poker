/** @author Kedar Gangopadhyay
*/

import java.util.ArrayList;

public class Player {

	private ArrayList<Card> hand; // the player's cards
	private int credits;
	private final int INITIAL_CREDIT = 50;

	public Player() {
		// Instantiate a Player here
		this.hand = new ArrayList<Card>();
		// Add initial credit to Player
		this.credits = INITIAL_CREDIT;
	}

	public void addCard(Card c) {
		hand.add(c);
	}

	public void removeCard(Card c) {
		hand.remove(c);
	}

	public void removeAllCards() {
		hand.clear();
	}

	// Replaces oldCard with newCard at the same position
	public void replaceCard(Card oldCard, Card newCard) {
		int index = hand.indexOf(oldCard);
		hand.set(index, newCard);
	}

	/**
	/* @return whether the hand contains the Card
	*/
	public boolean containCard(Card card){
		return hand.contains(card);
	}

	/**
	/* @return the Player's hand
	*/
	public ArrayList<Card> getPlayerHand(){
		return hand;
	}

	public void addCredits(int credit){
		this.credits += credit;
	}

	/**
	/* @return the Player's credits
	*/
	public int getAllCredit(){
		return this.credits;
	}

	public void removeCredit(int credit){
		this.credits -= credit;
	}
} // end class Player
