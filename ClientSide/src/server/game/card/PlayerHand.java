package server.game.card;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;

import server.data_structures.ArrayAdapter;

public class PlayerHand implements ArrayAdapter<Card>, Comparable<Card> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -706252777135678667L;
	private LinkedList<Card> cards = null;

	public PlayerHand() {
		this.cards = new LinkedList<>();
	}

	@Override
	public int getPosition(Card item) {
		return this.cards.indexOf(item);
	}

	@Override
	public void sort(Comparator<? super Card> comparator) {
		// do nothing!!
	}

	@Override
	public void remove(Card object) {
		this.cards.remove(object);
	}

	@Override
	public void remove(int index) {
		this.cards.remove(index);
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
