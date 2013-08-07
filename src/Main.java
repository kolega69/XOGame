import net.TCPClient;
import net.TCPObject;
import net.TCPServer;
import players.Computer;
import players.MenInputCoordinates;
import inventory.Chip;
import inventory.GameBoard;
import players.netPlayers.Recipient;
import players.netPlayers.Sender;
import virtuals.Validation;
import virtuals.VirtualGameBoard;

public class Main {

    private static char[][] chipCurrentMove = new char[3][3];
    private static int startRow;
    private static int startColumn;
    private static int currentVirtualChip;
	private static int column;
	private static int row;
	private static char moveOrder;

    private static final int START_COLUMN = 1;
    private static final int START_ROW = 0;
    private static final int VIRTUAL_CHIP_X = 1;
    private static final int VIRTUAL_CHIP_0 = 10;
    private static final int ROWS_AMOUNT = 3;
    private static final int COLUMNS_AMOUNT = 3;
    private static final int CELL_WIDTH = 6;
    private static final int CELL_HEIGHT = 4;

	private static MenInputCoordinates player1;
	private static MenInputCoordinates player2;
	private static MenInputCoordinates currentPlayer;
	private static TCPServer server;
	private static TCPClient client;


    public static void main(String[] args) throws Exception {

        System.out.println("TIC-TAC-TOE");
        System.out.println();

	    Menu menu = new Menu();
	    String player1Name = menu.getPlayer1Name();
	    String player2Name = menu.getPlayer2Name();
	    char typeOfGame = menu.getGameChoice();

        GameBoard gameBoard =
		        new GameBoard(COLUMNS_AMOUNT, ROWS_AMOUNT, CELL_WIDTH, CELL_HEIGHT);
	    System.out.println();
	    VirtualGameBoard virtualGameBoard =
			    new VirtualGameBoard(COLUMNS_AMOUNT, ROWS_AMOUNT);
        Validation validation = new Validation();

        currentPlayer = new MenInputCoordinates();
	    Computer computer = new Computer();

	    player1 = new MenInputCoordinates(player1Name);
	    player2 = new MenInputCoordinates(player2Name);


//	    server = new TCPServer();
//	    client = new TCPClient();

	    if (player1Name.equals("Computer")){
		    player1 = computer;
	    }  else if (player2Name.equals("Computer")){
		    player2 = computer;
	    }

        player1 = new Sender("ggg", "server");
        player2 = new Recipient("vvv", "server");

        for (int i = 1; i < 10; i++){

	        for (;;) {

		        if (typeOfGame == '1' || typeOfGame == '2') {
			        SwitchHumans(i);
		        }

//		        if (i % 2 != 0) {
//			        moveOrder = '1';
//			        currentPlayer = player1;
////			        reciveCoord(client);
//		        } else {
//			        moveOrder = '2';
//			        currentPlayer = player2;
////			        sendCoord(client);
//		        }
		        setCoord(currentPlayer);

		        if (validation.isEmpty(virtualGameBoard.getVirtualBoard()[column][row])) {
			        break;
		        }
//		        break;
	        }

	        System.out.println(column + " " + row);

            move(column, row, moveOrder);

            gameBoard.setChipOnBoard(startColumn, startRow,chipCurrentMove);

	        System.out.println();
	        gameBoard.drawGameBoard();
	        System.out.println();

            virtualGameBoard.setChipToVirtualBoard(column, row, currentVirtualChip);

	        String result = validation.isDrowOrWin(virtualGameBoard.getVirtualBoard());

	        if (result.equals("Win")){
		        System.out.println("W_I_N " + currentPlayer.getName() + " W_I_N");
		        return;
	        } else if (result.equals("Draw")){
		        System.out.println("D_R_A_W");
		        return;
	        }

        }

    }


    public static void move(int column, int row, char moveOrder){
        startColumn = ((column + 1) * 6) + START_COLUMN - 6;
        startRow = ((row + 1) * 4) + START_ROW - 4;

        Chip chip = new Chip(moveOrder);
        chipCurrentMove = chip.getChipReturn();

        if (moveOrder == '1') {
            currentVirtualChip = VIRTUAL_CHIP_X;
        }
        else {
            currentVirtualChip = VIRTUAL_CHIP_0;
        }

    }


	public static void sendCoord(TCPObject player) throws Exception{

//		currentPlayer.setCoordinate();
//		column = currentPlayer.getCoordC();
//		row = currentPlayer.getCoordR();
		setCoord(currentPlayer);
		String coordinates = Integer.toString(column) + Integer.toString(row);
		System.out.println(coordinates);
		player.sendCoord(coordinates);

	}

	public static void reciveCoord(TCPObject player) throws Exception {

		String coordinates =  player.receiveCoord();
		currentPlayer.stringToCoord(coordinates);
		column = currentPlayer.getCoordC() - 48;
		row = currentPlayer.getCoordR() - 48;

	}

	public static void setCoord(MenInputCoordinates player) throws Exception{
		player.setCoordinate();
		column = currentPlayer.getCoordC();
		row = currentPlayer.getCoordR();
	}

	public static void SwitchHumans(int i) {
		if (i % 2 != 0) {
			moveOrder = '1';
			currentPlayer = player1;
		} else {
			moveOrder = '2';
			currentPlayer = player2;
		}
	}
}


