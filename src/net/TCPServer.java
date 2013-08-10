package net;

import java.io.*;
import java.net.*;


public class TCPServer implements InterTCP{

	private static ServerSocket serverSocket;
	private Socket connectionSocket;

	public TCPServer() throws Exception{
        serverSocket = new ServerSocket(6543);
        connectionSocket = serverSocket.accept();
	}

	@Override
	public void sendCoord(String coordinates) throws Exception{

		DataOutputStream send =
				new DataOutputStream(connectionSocket.getOutputStream());

		send.writeBytes(coordinates + '\n');

	}

	@Override
	public String receiveCoord() throws Exception{

		BufferedReader read =
				new BufferedReader(
						new InputStreamReader(connectionSocket.getInputStream()));

		return read.readLine();
	}

}
