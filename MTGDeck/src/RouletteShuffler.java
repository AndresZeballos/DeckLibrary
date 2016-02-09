import java.util.List;
import java.util.Random;

import com.MTG.deck.MTGCard;
import com.decks.IShuffler;

public class RouletteShuffler<T extends MTGCard> implements IShuffler<T> {

	@Override
	public T nextCard(List<T> cards) {
		int totalWeight = 0;
		for (MTGCard c : cards) {
			totalWeight += c.getPriority();
		}
		Random rand = new Random(1234);
		Double selected = rand.nextDouble() * totalWeight;
		int i = 0;
		while (selected >= cards.get(i).getPriority()) {
			selected -= cards.get(i).getPriority();
			i++;
		}
		return cards.get(i);
	}

}
