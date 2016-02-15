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
Another two implementations uses IShuffler interface. This interface provide the nextCard method that receive the remaining cards to select and return one of them. If the card returned are not in the cards to select, the method raise a CardNotInDeckException exception.
The last implementarion uses the IDeckShuffle, this interface receive the cards in the deck and return them randomized.

In order to draw card from the deck the class provide the nextCard method. This method return the card in the top of the deck. 
The deck also proveide the hasCards method to validate first if the deck has cards or if it's empty.

In some games are common to return cards, generally to the top or bottom of the deck.
The class provide the addTop and addBottom methods to do this.

In other games will be useful to remove some cards before the start of the game. By example, to remove the joker's before a play of poker.
The removeCard method receive a card and remove the first occurrence of it.

## Shuffler implementations
The DeckLibrary provide three implementations of shufflers. Two of the IShuffler interface and one of IDeckShuffler.
The three implementations use java.util.Random to select randomly the cards order.

## Deck implementatios
The library also provide two implementations of common decks, one with french cards and other with spanish cards. 
The implementations are similar because both cards have ranks and suits.
The FrenchDeck default constructor inicialize the deck with the 52 cards.
The SpanishDeck defaut constructor also inicialize the 48 cards of this deck and provide a useful removeCards method.
This polymorfic method remove all the cards in the deck with the rank or suit received.
In some games like Truco the 8's and 9's are not allowed in the game (en.wikipedia.org/wiki/Truco).

# MTGDeck
This project use the DeckLibrary to do a simple representation of a Magic: The Gathering cards (en.wikipedia.org/wiki/Magic:_The_Gathering).
The main objective of this implementation is to extend the classes and interfaces provided by the library.
The MTGCard extends the Card class to represent the attributes shared for the cards in the game. Also have some subclasses like lands, creatures and spells.
The RouletteShuffler implements the IShuffler interface doing a fitness proportionate selection based on the priority of the cards (en.wikipedia.org/wiki/Fitness_proportionate_selection)
