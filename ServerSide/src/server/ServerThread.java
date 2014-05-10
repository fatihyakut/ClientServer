package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import server.game.player.Player;
import server.game.player.PlayerList;

public class ServerThread extends Thread {

	private Socket client;

	public ServerThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());

			ois = new ObjectInputStream(client.getInputStream());

			String input = null;

			while ((input = (String) ois.readObject()) != null) {
				oos.writeObject(Server.getServer().getPlayerList());

				Server.getServer().getPlayerList()
						.insert(input, new Player(input));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
