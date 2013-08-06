package players;

import net.TCPClient;

public class HumanClient extends MenInputCoordinates{

	TCPClient client;

	public HumanClient() throws Exception{
		super();
		client = new TCPClient();
	}

	public void setCoordinate() throws Exception{

		inpCoordinate();
        client.sendCoord(coordinates);

	}
	// скорее всего надо будет сделать наследование от сервера
	public void receiveFromServer() throws Exception{

		String coordinates = client.receiveCoord();

		coordC = coordinates.charAt(0) - 49;
		coordR = coordinates.charAt(1) - 49;
		System.out.println(coordC + " " + coordR);

	}
}
