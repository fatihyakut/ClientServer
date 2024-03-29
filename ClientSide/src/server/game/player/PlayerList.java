package server.game.player;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import server.data_structures.BasicHashAdapter;

public class PlayerList implements BasicHashAdapter<String, Player> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2667538588628200320L;

	private HashMap<String, Player> players = null;

	public PlayerList() {
		this.players = new HashMap<>(20);
	}

	@Override
	public void insert(String key, Player value) {
		this.players.put(key, value);
	}

	@Override
	public void addAll(Collection<? extends String> keys,
			Collection<? extends Player> values) {
		if (keys.size() != values.size())
			return;

		for (Iterator<?> keyİterator = keys.iterator(), valueIterator = values
				.iterator(); keyİterator.hasNext() && valueIterator.hasNext();) {
			this.players.put((String) keyİterator.next(),
					(Player) valueIterator.next());

		}
	}

	@Override
	public void clear() {
		this.players.clear();
	}

	@Override
	public int getCount() {
		return this.players.size();
	}

	@Override
	public Player getItem(String key) {
		return this.getItem(key);
	}

	@Override
	public Player remove(String key) {
		return this.players.remove(key);
	}

	@Override
	public Collection<Player> values() {
		return this.players.values();
	}

}
