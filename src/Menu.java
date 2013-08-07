import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private String message = "You choose ";
    private String warning = "You pressed invalid character, try again.";
    private BufferedReader reader;
    private String name;
    private String player1Name;
    private String player2Name;
	private char gameChoice;


    public Menu() throws IOException {

        reader= new BufferedReader(new InputStreamReader(System.in));

        while (true){

            System.out.println("For Human - Human game press 1");
            System.out.println();
            System.out.println("For Human - Computer game press 2");
            System.out.println();
            System.out.println("For Multiplayer game press 3");
            System.out.println();

            System.out.print("Please, choose game you want: ");

            gameChoice = reader.readLine().charAt(0);

            for (int i = 0; i < 5; i++) {
                System.out.println();
            }


            if (gameChoice == '1'){

                System.out.println(message + "game Human - Human.");
                System.out.println();
                System.out.print("X play first. ");
                setPlayerHuman("player1");
                player1Name = name;
                setPlayerHuman("player2");
                player2Name = name;
                break;

            }

            if (gameChoice == '2'){

                System.out.println(message + "game Human - Computer.");
                choosePlayerOrder();

                break;
            }

            if (gameChoice == '3'){

//                System.out.println("Sorry, this option will be able later");

                System.out.println(message + "Multiplayer game.");
	            System.out.println();
	            choosePlayerOrder();
	            System.out.println();

	            break;
            }

            System.out.println(warning);
            System.out.println();

        }

    }

    public void setPlayerHuman(String  number) throws IOException{

        System.out.print("Type " + number + " name: ");

        name = reader.readLine();

        System.out.println();

        if (name.equals("")){

            name = number;

        }

    }

    public void choosePlayerOrder() throws IOException{

        setPlayerHuman("player");

        while (true) {

            char choice;

            while (true){
                System.out.print("X play first. Do you want play X? y/n: ");

                String trying = reader.readLine();

                if (trying.length() != 0){

                    choice = trying.charAt(0);
                    break;

                }
            }

            System.out.println();

            if (choice == 'y') {

                player1Name = name;
                player2Name = "Computer";
                return;

            }

            if (choice == 'n') {

                player1Name = "Computer";
                player2Name = name;
                return;

            }

            System.out.println(warning);
        }

    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

	public char getGameChoice() {
		return gameChoice;
	}
}
