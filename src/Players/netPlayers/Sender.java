package players.netPlayers;


import net.InterTCP;
import players.ISetCoordinates;
import players.MenInputCoordinates;

public class Sender extends MenInputCoordinates implements ISetCoordinates{

    public Sender(String name, InterTCP messenger) throws Exception {
        super(name, messenger);
    }

    @Override
    public void setCoordinate(int x, int y) throws Exception{
        super.setCoordinate(x, y);
        sendCoord();
    }
}
