# DeckLibrary
A simple deck representation and some individuals implementations

The DeckLibrary contains the representation of a deck of cards, two interfaces to define the shufflers allowed and two concrete implementations, spanish and french cards.

## Card Class
This abstract class represents the cards to be used in the deck.
To extends it must implements the equals() method.
A particular representation must define how to identificate when two cards are the same.
By example, in some games, cards have name that identicate it, in others, the cards have suit and rank.

## Deck Class
The Deck class use generics to manipulate any class that extends the Card class.
The Deck provide methods useful to manipulte the cards on it.

The class provide two constructors, one that recives a list of cards and another without parameters.

To start a game generaly the deck is shuffled. 
The class provide five alternatives to shuffle the deck, three to shuffle all the cards and two to shuffle the cards remaining in the deck.
The defaults methods to shuffle are shuffle() and shuffleRemain(), both use Collections.shuffle() method to randomize the cards. 
//Another two methods uses



