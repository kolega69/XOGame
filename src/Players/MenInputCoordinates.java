package Players;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenInputCoordinates extends Player {

    public void inputCoordinate(String name) throws IOException {

        String coordinates;

        BufferedReader coordinate = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            while (true){

	            System.out.print(name + " type field (for instance a1): ");
	            coordinates = coordinate.readLine();
	            if (coordinates.length() == 2){
		            break;
	            }
            }
            coordX = coordinates.charAt(0);
	        coordY = coordinates.charAt(1);
            if ((coordX >= 'a' && coordX <= 'c') && (coordY >= '1' && coordY <= '3')){
	            break;

            }

        }

	    coordX -= 97;
	    coordY -= 49;

    }

}
