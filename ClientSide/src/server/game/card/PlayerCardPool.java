package server.game.card;

import java.util.Collection;
import java.util.LinkedList;
import server.data_structures.BasicArrayAdapter;

public class PlayerCardPool implements BasicArrayAdapter<Card> {

	private LinkedList<Card> cards = null;

	public PlayerCardPool() {
		this.cards = new LinkedList<>();
	}

	@Override
	public int compareTo(Card o) {
		if (o == null)
			return -1;

		if (this.cards.getLast().getNumber() < o.getNumber())
			return 1;
		else if (this.cards.getLast().getNumber() > o.getNumber())
			return -1;

		return 0;
	}

	@Override
	public void add(Card t) {
		if (t != null)
			this.cards.add(t);
	}

	@Override
	public void addAll(Collection<? extends Card> collection) {
		if (collection != null)
			for (Card card : collection)
				this.cards.add(card);
	}

	@Override
	public void addAll(Card... items) {
		this.addAll(cards);
	}

	@Override
	public void clear() {
		this.cards.clear();
	}

	@Override
	public int getCount() {
		return this.cards.size();
	}

	@Override
	public Card getItem(int position) {
		return this.cards.get(position);
	}

	@Override
	public void insert(Card object, int index) {
		this.cards.add(object);
	}

}
