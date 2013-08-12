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
    private String soketSide;
	private char whosFirst;


    public Menu() throws IOException {

        reader= new BufferedReader(new InputStreamReader(System.in));

        while (true){

            System.out.print("For Human - Human game press 1" + '\n'
                    + '\n'
                    + "For Human - Computer game press 2" + '\n'
                    + '\n'
                    + "For Multiplayer game press 3" + '\n'
                    + '\n'
                    + "Please, choose game you want: ");

            gameChoice = reader.readLine().charAt(0);

            for (int i = 0; i < 5; i++) {
                System.out.println();
            }


            if (gameChoice == '1'){

                System.out.print(message + "game Human - Human." + '\n'
                                + '\n'
                                + "X play first. ");

                player1Name = setPlayerHuman("player1");
                player2Name = setPlayerHuman("player2");

                break;

            }

            if (gameChoice == '2'){

                System.out.println(message + "game Human - Computer.");

	            player1Name = setPlayerHuman("your");
	            whosFirst = choosePlayerOrder();

                break;
            }

            if (gameChoice == '3'){

                System.out.println(message + "Multiplayer game.");
	            System.out.println();
	            soketSide = chooseSokeetSide();
	            player1Name = setPlayerHuman("your");
	            whosFirst = choosePlayerOrder();
	            System.out.println();

	            break;
            }

            System.out.println(warning);
            System.out.println();

        }

    }

    public String  setPlayerHuman(String  number) throws IOException{

        System.out.print("Type " + number + " name: ");

        name = reader.readLine();

        System.out.println();

        if (name.equals("")){
            name = number;
        }

	    return name;
    }

    public char choosePlayerOrder() throws IOException{

        while (true) {

            char choice;

            choice = makeChoice("X play first. Do you want play X? y/n: ");

            System.out.println();

            if (choice == 'y') {

                player1Name = name;
                return choice;

            }

            if (choice == 'n') {

                player1Name = "Computer";
                return choice;

            }

            System.out.println(warning);
        }

    }

    public String chooseSokeetSide() throws IOException{

        char choice;

        while (true) {

        choice = makeChoice("Would you like to create Server? y/n: ");

        if (choice == 'y') {
            return "server";
        }

        if (choice == 'n') {
            return "client";
        }

        System.out.println(warning);
    }

}

    public char makeChoice(String text) throws IOException{
        char choice;

        while (true){
            System.out.print(text);

            String trying = reader.readLine();

            if (trying.length() != 0){

                choice = trying.charAt(0);
                break;

            }
        }

        return choice;
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

	public char getWhosFirst() {
		return whosFirst;
	}

	public String getSoketSide() {
		return soketSide;
	}

}
