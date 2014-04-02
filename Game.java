// **************************************************************
// Programming Assignment #4 (Video Poker)
// Written by Kedar Gangopadhyay (kg2576)
// This is the Game class which contains [ ] methods
// **************************************************************

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	private Scanner input;
	private Player p;
	private Deck cards;
	private final int TOTAL_HAND = 5;
	private int replace = 0;
	
	public Game(String[] testHand) {
	} // end constructor
	
	public Game () {
		input = new Scanner(System.in);
		p = new Player();
		cards = new Deck();
	} // end constructor
	
	public void fillHand () { // deals top 5 cards from the deck and stores them in ArrayList
	
		for (int i=0; i < TOTAL_HAND; i++)
		{
			p.addCard(cards.deal());
		} // end loop
		
		System.out.println();
		System.out.println(returnHand());
		System.out.println("Replace: "+deckQuery());
		
		for (int j=0; j < replace; j++) // adds certain number of cards based on query
		{
			p.addCard(cards.deal());
		} // end loop
		
		do
		{
			p.removeCard(cards.resetDeck());
		}
		while (p.inHand() > 5);
			
		System.out.println(cards.getTop());
		System.out.println(returnHand());
		
	} // end method
	
	public ArrayList returnHand() { // @return p.getHand() ArrayList hand
		return p.getHand();
		
	} // end method
		
	public void play() {
		cards.shuffle();
		
		for (Card element : cards.returnDeck())
		{
			System.out.println(element);
		} // end loop
		
	} // end method
	
	public int deckQuery() { // @return replace how many cards to replace
				
		System.out.println("You have been dealt 5 cards.  How many will you keep (enter 1-5)?");
		int keep = input.nextInt();
		return replace = TOTAL_HAND - keep;

	} // end method
	
} // end class Game
