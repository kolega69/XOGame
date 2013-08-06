package net;

import java.io.*;
import java.net.*;


public class TCPServer {

	private ServerSocket serverSocket = new ServerSocket(6543);
	private Socket connectionSocket = serverSocket.accept();
	private String coordinates;

	public TCPServer() throws Exception{

	}

	public void sendCoord(String coordinates) throws Exception{

		DataOutputStream sendClient =
				new DataOutputStream(connectionSocket.getOutputStream());

		sendClient.writeBytes(coordinates + '\n');

	}

	public String receiveCoord() throws Exception{

		BufferedReader readClient =
				new BufferedReader(
						new InputStreamReader(connectionSocket.getInputStream()));

		return readClient.readLine();
	}

}
