package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Client {
	public static void main(String[] args) throws IOException {
		System.out.println("Sender Start");

		Socket socket = new Socket("localhost", 9090);

		InputStream is = socket.getInputStream();

		ObjectOutputStream oos = new ObjectOutputStream(
				socket.getOutputStream());

		oos.writeObject("fatih yakut");

		ObjectInputStream ois = new ObjectInputStream(is);

		String answer = null;

		try {
			while ((answer = (String) ois.readObject()) != null) {
				System.err.println("Answer : " + answer);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			oos.close();
		}
		System.err.println("Client bitti!!");
		// ServerSocketChannel ssChannel = ServerSocketChannel.open();
		// ssChannel.configureBlocking(true);
		// int port = 12345;
		// ssChannel.socket().bind(new InetSocketAddress(port));
		//
		// String obj = "testtext";
		// while (true) {
		// SocketChannel sChannel = ssChannel.accept();
		//
		// ObjectOutputStream oos = new ObjectOutputStream(sChannel.socket()
		// .getOutputStream());
		// oos.writeObject(obj);
		// oos.close();
		//
		// System.out.println("Connection ended");
		// }
	}
}