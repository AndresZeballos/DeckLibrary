import java.util.ArrayList;

import com.MTG.creatures.Creature;
import com.MTG.deck.MTGCard;
import com.MTG.deck.RouletteShuffler;
import com.MTG.lands.Land;
import com.MTG.lands.LandType;
import com.MTG.spells.Sorcer;
import com.decks.Deck;
import com.decks.exceptions.CardNotInDeckException;

public class Main {

	public static Deck<MTGCard> createDeck() {
		ArrayList<MTGCard> cards = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			cards.add(new Land(LandType.Plains));
		}
		for (int i = 0; i < 10; i++) {
			cards.add(new Sorcer("A Spell", 5));
		}
		for (int i = 0; i < 10; i++) {
			cards.add(new Creature("A Creature", 3, 2, 2));
		}
		Deck<MTGCard> deck = new Deck<MTGCard>(cards);
		// deck.shuffle();
		return deck;
	}

	public static void main(String[] args) {
		Deck<MTGCard> deck = createDeck();
		try {
			deck.shuffle(new RouletteShuffler<MTGCard>());
			System.out.println(deck);
		} catch (CardNotInDeckException e) {
			e.printStackTrace();
		}
	}

}
