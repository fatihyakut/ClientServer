package server.data_structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import server.game.player.Player;

public class PlayerArray implements ArrayAdapter<Player> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8573143131408314731L;
	private ArrayList<Player> players = null;

	public PlayerArray(ArrayList<Player> players) {
		this.players = players;
	}

	@Override
	public void add(Player t) {
		this.players.add(t);
	}

	@Override
	public void addAll(Collection<? extends Player> collection) {

		for (Player p : collection) {
			this.players.add(p);
		}
	}

	@Override
	public void addAll(Player... items) {

		for (Player p : items) {
			this.players.add(p);
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
	public Player getItem(int position) {
		return this.players.get(position);
	}

	@Override
	public int getPosition(Player item) {
		return this.players.indexOf(item);
	}

	@Override
	public void sort(Comparator<? super Player> comparator) {
		Collections.sort(players, comparator);
	}

	@Override
	public void remove(Player object) {
		this.players.remove(object);
	}

	@Override
	public void remove(int index) {
		this.players.remove(index);
	}

	@Override
	public void insert(Player object, int index) {
		this.players.add(index, object);
	}

}
