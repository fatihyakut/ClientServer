package server;

import java.io.IOException;
import java.net.ServerSocket;

import server.game.player.Player;
import server.game.player.PlayerList;

public class Server {

	private static String[] s = { "fatih", "ünal", "ömer", "vedat", "murat",
			"mehmet", "mal melih", "özge" };
	private static Server server = null;

	private int portNumber = 0;
	private PlayerList p;

	private Server(int portNumber, PlayerList playerList) {
		this.portNumber = portNumber;
		this.p = playerList;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Server Start");

		if (args.length != 1) {
			System.err.println("Incorrect Input!!");
			System.exit(0);
		}

		ServerSocket listener = null;
		try {
			int portNumber = Integer.parseInt(args[0]);
			server = new Server(portNumber, new PlayerList());

			for (String name : s)
				server.p.insert(name, new Player(name));

			listener = new ServerSocket(portNumber);

			while (true) {
				new ServerThread(listener.accept()).start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			listener.close();
		}
	}

	public static Server getServer() {
		return server;
	}

	public int getPortNumber() {
		return portNumber;
	}

	public PlayerList getPlayerList() {
		return p;
	}
}