package net;

import java.io.*;
import java.net.*;


public class TCPServer extends TCPObject{

	private ServerSocket serverSocket = new ServerSocket(6543);
	private Socket connectionSocket = serverSocket.accept();
	private String coordinates;

	public TCPServer() throws Exception{

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
