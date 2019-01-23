/** @author Kedar Gangopadhyay
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
	private Player p;
	private Deck cards;

	// This is game bet that is debited from player's outstanding credit
	private final int GAME_BET = 1;

	// Game Hand
	private final String ROYAL_FLUSH			= "Royal Flush";
	private final String STRAIGHT_FLUSH		= "Straight Flush";
	private final String FOUR_OF_A_KIND		= "Four of a kind";
	private final String FULL_HOUSE				= "Full House";
	private final String FLUSH						= "Flush";
	private final String STRAIGHT					= "Straight";
	private final String THREE_OF_A_KIND	= "Three of a kind";
	private final String TWO_PAIRS				= "Two pairs";
	private final String ONE_PAIR					= "One pair";
	private final String NO_PAIR					= "No pair";

	public Game() {
		// Instantiate a Player here
		this.p = new Player();
		// Instantiate a Deck of Cards
		this.cards = new Deck();
	}

	public void play() {
		System.out.println("#####################################");
		System.out.println("###     WELCOME TO VIDEO POKER    ###");
		System.out.println("#####################################");

		while(true) {

			System.out.println("PLAYER CREDIT (1 credit to play): <"+ p.getAllCredit()+">");
			System.out.println("Enter value to continue: ");
			System.out.print("<0 - Exit Game> or <9 - Draw Cards> : ");

			// This loop will check if the player wants to continue the Game or Exit
			Scanner scan = new Scanner(System.in);
			while(true) {
				String tempValue = scan.nextLine();
				if(tempValue.equals("9")) {
					break;
				} else if(tempValue.equals("0")) {
					return;
				} else {
					System.out.print("Invalid entry. Please try again (Enter value: 0 or 9) - ");
				}
			}

			// Shuffle the cards in the Deck
			this.cards.shuffle();

			ArrayList<Card> playersHand = p.getPlayerHand();

			// If Players hand has less than 5 cards, add more cards from deck
			// This is used if less cards are entered from testHand
			if(playersHand.size()<5) {
				ArrayList<Card> tempCards = new ArrayList<Card>();
				for (int i = 0; i < (5 - playersHand.size()) ; i++) {
					tempCards.add(getNextPlayerCard());
				}

				// Two loops are used, so that the same card is not added to player's hand while using testHand
				for (Card card : tempCards) {
					p.addCard(card);
				}
			}

			System.out.println("----------------------------------");
			System.out.println("Below are the player's drawn cards");
			System.out.println("----------------------------------");

			for (int i = 1; i <= playersHand.size(); i++) {
				System.out.println(i+") " + playersHand.get(i-1));
			}
			System.out.println();

			// Remove GAME_BET from Player's credit
			p.removeCredit(GAME_BET);

			System.out.println("PLAYER CREDIT: <"+ p.getAllCredit()+">");
			System.out.println("Enter card's position to reject. ");
			System.out.println("<Option 0:   No cards to reject>");
			System.out.println("<Option 1-5: Replace card (position)>");
			System.out.println("<Option 9:   Deal Cards>");
			System.out.print("Enter Value here: ");

			ArrayList<Card> rejectedCards = new ArrayList<Card>();

			while(true) {
				String tempValue = scan.nextLine();
				if(tempValue.equals("1") || tempValue.equals("2") || tempValue.equals("3") || tempValue.equals("4") || tempValue.equals("5")){
					int tempInputValue = Integer.parseInt(tempValue);
					rejectedCards.add(playersHand.get(tempInputValue-1));
				} else if(tempValue.equals("0")) {
					rejectedCards.clear();
					break;
				} else if(tempValue.equals("9")) {
					break;
				} else {
					System.out.println("Invalid entry. Please try again (Enter value: 0-5,9) - ");
				}
			}

			// Replace card from Deck
			// Before replacing the card in deck, loop checks if the card exist in player's hand
			ArrayList<Card> tempCards = new ArrayList<Card>();
			for (int i=0; i< rejectedCards.size(); i++) {
				tempCards.add(getNextPlayerCard());
			}
			// Two loops are used, so that the same card is not added to player's hand while using testHand
			for (int i=0; i< rejectedCards.size(); i++) {
				p.replaceCard(rejectedCards.get(i), tempCards.get(i));
			}

			// Display player's hand
			playersHand = p.getPlayerHand();
			System.out.println("----------------------------------------");
			System.out.println("Below is the player's newly dealt cards");
			System.out.println("----------------------------------------");
			for (int i = 1; i <= playersHand.size(); i++) {
				System.out.println(i+") " + playersHand.get(i-1));
			}

			// Check Player's hand and score
			String winningHand = checkHand(playersHand);
			int score = 0;

			if(winningHand.equals(ROYAL_FLUSH)) {
				score = 250;
			} else if(winningHand.equals(STRAIGHT_FLUSH)) {
				score = 50;
			} else if(winningHand.equals(FOUR_OF_A_KIND)) {
				score = 25;
			} else if(winningHand.equals(FULL_HOUSE)) {
				score = 6;
			} else if(winningHand.equals(FLUSH)) {
				score = 5;
			} else if(winningHand.equals(STRAIGHT)) {
				score = 4;
			} else if(winningHand.equals(THREE_OF_A_KIND)) {
				score = 3;
			} else if(winningHand.equals(TWO_PAIRS)) {
				score = 2;
			} else if(winningHand.equals(ONE_PAIR)) {
				score = 1;
			}

			p.addCredits(score);

			// Display hand and score
			// Then remove all cards from player's hand for next game
			System.out.println();
			System.out.println("PLAYER HAND: *** " + winningHand +" ***");
			p.removeAllCards();

		} // end while
	}

	/**
	/* @return next card from deck
	*/
	private Card getNextPlayerCard() {
		Card tempCard;
		do {
			tempCard = this.cards.deal();
		} while (p.containCard(tempCard)); // checks whether Card exists in Player's hand
		return tempCard;
	}

	/**
	/* @return the hand
	*/
	public String checkHand(ArrayList<Card> hand) {
		if(hand.size()==5) {
			Collections.sort(hand);

			boolean isStraight = isStraight(hand);
			boolean isSameSuit = isSameSuit(hand);
			ArrayList<Integer> pairCount = pairCount(hand);

			// Check for Royal Flush
			if(isSameSuit && isStraight && hand.get(4).getValue()==13) {
				return ROYAL_FLUSH;
			} else if (isSameSuit && isStraight) {
				return STRAIGHT_FLUSH;
			} else if(pairCount.get(0)==4) {
				return FOUR_OF_A_KIND;
			} else if(pairCount.get(0)==3 && pairCount.get(1)==2) {
				return FULL_HOUSE;
			} else if(isSameSuit) {
				return FLUSH;
			} else if(isStraight) {
				return STRAIGHT;
			} else if(pairCount.get(0)==3) {
				return THREE_OF_A_KIND;
			}else if(pairCount.get(0)==2 && pairCount.get(1)==2) {
				return TWO_PAIRS;
			} else if(pairCount.get(0)==2) {
				return ONE_PAIR;
			} else {
				return NO_PAIR;
			}
		} else {
			return "INVALID number of cards";
		}
	}

	/**
	/* @return number of occurences of given value
	*/
	private ArrayList<Integer> pairCount(ArrayList<Card> hand) {

		int[] numOccurrence = new int[13];
		for (Card card : hand) {
			numOccurrence[card.getValue()-1] = numOccurrence[card.getValue()-1] + 1;
		}
		// List only the number of occurrence in sorted order
		ArrayList<Integer> cardOccurrence = new ArrayList<Integer>();
		for (int integer : numOccurrence) {
			cardOccurrence.add(integer);
		}

		Collections.sort(cardOccurrence, Collections.reverseOrder());
		return cardOccurrence;
	}

	/**
	/* @return whether the hand is a straight
	*/
	private boolean isStraight(ArrayList<Card> hand) {
		ArrayList<Integer> cardValue = new ArrayList<Integer>();

		// Get all card value and store in different Arraylist
		for (Card card : hand) {
			cardValue.add(card.getValue());
		}

		// Sort the card values
		Collections.sort(cardValue);
		int tempValue = 0;

		for (Integer integer : cardValue) {
			if(tempValue == 0) {
				tempValue = integer.intValue();
			} else if(tempValue+1 != integer.intValue()) {
				// This check is to validate order for 1, 10, 11, 12 & 13
				if(tempValue==1 && integer.intValue()==10) {
					tempValue = integer.intValue();
				} else {
					return false;
				}
			} else {
				tempValue = integer.intValue();
			}
		}
		return true;
	}

	/**
	/* @return whether we have same suit
	*/
	private boolean isSameSuit(ArrayList<Card> hand) {
		int suitValue = 0;
		for (Card card : hand) {
			if(suitValue == 0){
				suitValue = card.getSuit();
			} else if(suitValue != card.getSuit()) {
				return false;
			}
		}
		return true;
	}

} // end class Game
