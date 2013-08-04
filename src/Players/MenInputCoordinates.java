package players;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenInputCoordinates extends Player {

	String coordinates;

	public MenInputCoordinates() {
	}

	public MenInputCoordinates(String name) {
		super(name);
	}

	public void setCoordinate() throws Exception {

         inpCoordinate();

    }

    public void inpCoordinate() throws Exception {

        BufferedReader coordinate = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            while (true){

                System.out.print(getName() + " type field (for instance a1): ");
                coordinates = coordinate.readLine();
                if (coordinates.length() == 2){
                    break;
                }
            }
            coordC = coordinates.charAt(0);
            coordR = coordinates.charAt(1);
            if ((coordC >= 'a' && coordC <= 'c') && (coordR >= '1' && coordR <= '3')){
                break;

            }

        }

        coordC -= 97;
        coordR -= 49;

    }



}
