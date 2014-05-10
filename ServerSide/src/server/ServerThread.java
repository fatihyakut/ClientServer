package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import server.TestObject;

public class ServerThread extends Thread {

	private Socket client;

	public ServerThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());

			ois = new ObjectInputStream(client.getInputStream());

			String input = null;

			while ((input = (String) ois.readObject()) != null) {
				System.out.println("Input : " + input);
				TestObject t = new TestObject();
				t.setName("Ayýdoþ");
				t.setAge(10);
				oos.writeObject(t);
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
