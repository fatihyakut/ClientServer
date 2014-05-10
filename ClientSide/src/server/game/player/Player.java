package server.game.player;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import server.game.player.state.PlayerState;

public class Player implements Observer, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3000609562688518761L;
	private PlayerState state = null;
	private String userName;
	private PrintWriter writer;

	public Player(String userName) {
		// TODO Auto-generated constructor stub
		this.userName = userName;
		this.state = null;
	}

	public PlayerState getState() {
		return state;
	}

	public String getUserName() {
		return userName;
	}

	public PrintWriter getWriter() {
		return writer;
	}

	public void setState(PlayerState state) {
		this.state = state;
	}

	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
