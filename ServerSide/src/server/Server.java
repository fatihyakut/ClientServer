package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		System.out.println("Receiver Start");

		@SuppressWarnings("resource")
		ServerSocket socket = new ServerSocket(9090);

		Socket client = socket.accept();

		ObjectOutputStream oos = new ObjectOutputStream(
				client.getOutputStream());

		ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

		String input = null;

		while ((input = (String) ois.readObject()) != null) {
			System.out.println("Input : " + input);
			oos.writeObject("Okudum");
		}

		oos.close();
		client.close();

	}
}