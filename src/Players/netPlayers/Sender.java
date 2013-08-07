package players.netPlayers;


import players.MenInputCoordinates;

public class Sender extends MenInputCoordinates{

    public Sender(String name, String messenger) throws Exception {
        super(name, messenger);
    }

    @Override
    public void setCoordinate() throws Exception{
        super.setCoordinate();
        sendCoord();
    }
}
