import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MenInputCoordinates {

    private char coordY;
    private char coordX;
	private String coordinates;

    public void inputCoordinate() throws Throwable{

        BufferedReader coordinate = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            while (true){
	            System.out.print("Type field (for instance a1): ");
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
    }

    public int getCoordinateY() {
        return coordY - 48;
    }
    public int getCoordinateX(){
        return coordX - 96;
    }
}