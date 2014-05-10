package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import server.game.player.Player;
import server.game.player.PlayerList;

public class Client extends Player {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7021425959357283528L;
	private static Client client;
	private int serverPortNumber;
	private String serverIP;

	private Client(String userName) {
		super(userName);
		// TODO Auto-generated constructor stub

	}

	public static void main(String[] args) {

		if (args.length != 3) {
			System.err.println("IncorrectInput");
			System.exit(0);
			return;
		}
		System.out.println("Client Start");

		String serverIP = args[0];
		int serverPortNumber = Integer.parseInt(args[1]);
		String userName = args[2];

		client = new Client(userName);
		client.serverIP = serverIP;
		client.serverPortNumber = serverPortNumber;

		Socket socket = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			socket = new Socket(client.serverIP, client.serverPortNumber);
			InputStream is = socket.getInputStream();

			oos = new ObjectOutputStream(socket.getOutputStream());

			oos.writeObject(client.getUserName());

			ois = new ObjectInputStream(is);

			PlayerList obj = null;

			while ((obj = (PlayerList) ois.readObject()) != null) {
				for (Player p : obj.values()) {
					System.out.println("Ýsim : " + p.getUserName()
							+ ", Durum : " + p.getState());
				}

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.err.println("Client bitti!!");

	}

	public static Client getInstance() {
		if (client != null)
			return client;

		client = new Client("fatih yakut");
		return client;
	}

	public int getServerPortNumber() {
		return serverPortNumber;
	}

	public String getServerIP() {
		return serverIP;
	}

}