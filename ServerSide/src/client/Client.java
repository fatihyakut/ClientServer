package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import server.TestObject;

public class Client {
	public static void main(String[] args) throws IOException {
		System.out.println("Client Start");

		Socket socket = new Socket("localhost", 10500);

		InputStream is = socket.getInputStream();

		ObjectOutputStream oos = new ObjectOutputStream(
				socket.getOutputStream());

		oos.writeObject("fatih yakut");

		ObjectInputStream ois = new ObjectInputStream(is);

		TestObject obj = null;

		try {
			while ((obj = (TestObject) ois.readObject()) != null) {
				System.err.println("Answer : " + obj.toString());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			oos.close();
		}
		System.err.println("Client bitti!!");
	}
}