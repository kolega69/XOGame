package net;

import java.io.*;
import java.net.*;

public class TCPClient implements InterTCP{

	private final static String HOST_NAME = "Oleg_K";
	private final static int PORT = 6543;
	private String coordinates;
	private Socket client;

	public TCPClient() throws Exception {

		System.out.print("Connection to Server");
		while (true) {
			try {
				client = new Socket(HOST_NAME, PORT);
				break;
			} catch (IOException e) {
				System.out.print(".");
			}
		}

	}

    public Socket instanceTCP(){
         return client;
    }

	@Override
	public void sendCoord(String coordinates) throws Exception {

		DataOutputStream dataOut =
				new DataOutputStream(client.getOutputStream());

		dataOut.writeBytes(coordinates + '\n');

	}

	@Override
	public String receiveCoord() throws Exception{

		BufferedReader dataIn =
				new BufferedReader(
						new InputStreamReader(client.getInputStream()));

        coordinates = dataIn.readLine();

        return coordinates;

	}
}
