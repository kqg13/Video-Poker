Video-Poker
===========
This program implements a simulation of the popular casino game, usually called Video Poker.

The card deck contains 52 cards, 13 of each suit. At the beginning of the game, the deck is shuffled using a fair method.  The player plays a token for each game.  Then the top 5 cards of the deck are presented to the player.  The player has the option of rejecting none, some, or all of the cards.  The rejected cards are replaced from the top of the deck and the hand is scored.  The hand is scored according to the following payout schedule:

* No pair:          0
* One pair:         1
* Two pairs:        2
* Three of a Kind:  3
* Straight:         4
* Flush:            5
* Full House:       6
* Four of a Kind:   25
* Straight Flush:   50
* Royal Flush:      250

Compile
-------

To compile the Java classes for the program, execute the follow command:

  `javac *.java`

This generates five .class files in the current directory.  All classes were written in Java 7.

Run class
---------

To run the main class, execute the following command:

  `java VideoPoker`
