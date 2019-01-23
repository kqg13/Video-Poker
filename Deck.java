/** @author Kedar Gangopadhyay
*/

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
      }
    }
  }

  /**
  * @return an ordered Deck
  */
  public Card[] returnDeck() {
    return theDeck;
  }

  public void shuffle () {
    int firstCard = 0;
    int secondCard = 0;

    for (int i = 0; i <= 1000; i++) // swaps two Card elements in the Deck
    {
      firstCard = (int) (Math.random () * TOTAL_CARDS);
      secondCard = (int) (Math.random () * TOTAL_CARDS);

      Card temp = theDeck[firstCard];
      theDeck[firstCard] = theDeck[secondCard];
      theDeck[secondCard] = temp;
    }
  }

  /**
  * @return next Card in the Deck
  */
  public Card deal() {
    return theDeck[top++];
  }

  /**
  * @return a resetted Deck
  */
  public Card resetDeck() {
    top = 0;
    return theDeck[top];
  }

  /**
  * @return top of the Deck
  */
  public int getTop() {
    return top;
  }

} // end class Deck
