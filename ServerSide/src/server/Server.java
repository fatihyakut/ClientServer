package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		System.out.println("Server Start");

		ServerSocket socket;
		try {
			socket = new ServerSocket(10500);
			while (true) {
				Socket client = socket.accept();
				new ServerThread(client).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}