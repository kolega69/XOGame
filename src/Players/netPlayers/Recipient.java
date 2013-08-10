package players.netPlayers;


import players.ISetCoordinates;
import players.MenInputCoordinates;
import net.InterTCP;

public class Recipient extends MenInputCoordinates implements ISetCoordinates{

    int coordC;
    int coordR;

    public Recipient(String name, InterTCP messenger) throws Exception {
        super(name, messenger);
    }

    @Override
    public void setCoordinate()throws Exception{

        String coordinate = receiveCoord();
        System.out.println(coordinate);
        stringToCoord(coordinate);
        coordC = getCoordC() - 48;
        coordR = getCoordR() - 48;
        System.out.println(coordC + " " + coordR);
    }
}
