package players;


import net.TCPServer;


public class HumanServer extends MenInputCoordinates{

	private TCPServer server;

	public HumanServer() throws Exception{
		super();
		server = new TCPServer();
	}


    public void setCoordinate() throws Exception {

        inpCoordinate();
		server.sendCoord(coordinates);
	}

	public void receiveCoord() throws Exception{

		String coordinates = server.receiveCoord();

		coordC = coordinates.charAt(0) - 49;
		coordR = coordinates.charAt(1) - 49;

		System.out.println(coordC + " " + coordR);
	}

}
