package server.game.card;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import server.data_structures.ArrayAdapter;

public class CardDeck implements ArrayAdapter<Card> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4184593435718615538L;
	private LinkedList<Card> cards = null;

	public CardDeck() {
		this.cards = new LinkedList<>();
	}

	@Override
	public void add(Card t) {
		this.cards.add(t);
	}

	@Override
	public void addAll(Collection<? extends Card> collection) {
		for (Card card : collection) {
			this.cards.add(card);
		}
	}

	@Override
	public void addAll(Card... items) {
		this.addAll(items);
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
	public int getPosition(Card item) {
		return this.cards.indexOf(item);
	}

	@Override
	public void sort(Comparator<? super Card> comparator) {
		// DO NOTHING!!!
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
	public void insert(Card object, int index) {
		this.cards.add(index, object);
	}

	public void showAll() {
		for (Card c : cards)
			System.out.println(c);

	}

}
