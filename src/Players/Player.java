package players;

import net.*;

public class Player {

	String name;
	int coordC;
	int coordR;
    InterTCP messenger;

	public Player() {
	}

	public Player(String name) {
		this.name = name;
	}

    public Player( String name, InterTCP messenger) throws Exception{

        this.name = name;

        this.messenger = messenger;

    }

    public String getName() {
		return name;
	}

	public int getCoordC() {
		return coordC;
	}

	public int getCoordR() {
		return coordR;
	}

    public void sendCoord() throws Exception {

        String coordinates = Integer.toString(coordC) + Integer.toString(coordR);
        messenger.sendCoord(coordinates);

    }

    public String receiveCoord() throws Exception {
        return messenger.receiveCoord();
    }
}
