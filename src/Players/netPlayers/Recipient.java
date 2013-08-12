package players.netPlayers;


import players.ISetCoordinates;
import players.MenInputCoordinates;
import net.InterTCP;

public class Recipient extends MenInputCoordinates implements ISetCoordinates
{

    int coordC;
    int coordR;
    String coordinate;

    public Recipient(String name, InterTCP messenger) throws Exception
	{
        super(name, messenger);
    }

    @Override
    public void setCoordinate()throws Exception
	{

        coordinate = receiveCoord();
        super.stringToCoord(coordinate);
        coordC = super.getCoordC();
        coordR = super.getCoordR();
    }

    @Override
    public int getCoordC() {
        return coordC - 48;
    }

    @Override
    public int getCoordR() {
        return coordR - 48;
    }


}
