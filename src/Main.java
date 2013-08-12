import net.InterTCP;
import net.TCPClient;
import net.TCPServer;
import players.*;
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
	private static ISetCoordinates currentPlayer;
	private static InterTCP soketSide;


    public static void main(String[] args) throws Exception {

        System.out.println("TIC-TAC-TOE");
        System.out.println();

	    Menu menu = new Menu();
	    String player1Name = menu.getPlayer1Name();
	    String player2Name = menu.getPlayer2Name();

	    switch (menu.getGameChoice()){

		    case '1':
			    player1 = new MenInputCoordinates(player1Name);
			    player2 = new MenInputCoordinates(player2Name);
			    break;

		    case '2':
			    if (menu.getWhosFirst() == 'y') {
				    player1 = new MenInputCoordinates(player1Name);
				    player2 = new Computer();
			    } else {
				    player1 = new Computer();
				    player2 = new MenInputCoordinates(player1Name);
			    }
			    break;

		    case '3':
			    if (menu.getSoketSide().equals("server")){
				    soketSide = new TCPServer();
			    } else {
				    soketSide = new TCPClient();
			    }

			    if (menu.getWhosFirst() == 'y') {
				    player1 = new Sender(player1Name, soketSide);
				    player2 = new Recipient(player2Name, soketSide);
			    } else {
				    player1 = new Recipient(player2Name, soketSide);
				    player2 = new Sender(player1Name, soketSide);
			    }
			    break;

	    }

        GameBoard gameBoard =
		        new GameBoard(COLUMNS_AMOUNT, ROWS_AMOUNT, CELL_WIDTH, CELL_HEIGHT);
	    System.out.println();
	    VirtualGameBoard virtualGameBoard =
			    new VirtualGameBoard(COLUMNS_AMOUNT, ROWS_AMOUNT);
        Validation validation = new Validation();

        for (int i = 1; i < 10; i++){

	        for (;;) {

			    SwitchHumans(i);

		        setCoord(currentPlayer);

		        int currentCell =  virtualGameBoard.getVirtualBoard()[column][row];
		        if (validation.isEmpty(currentCell)) {
			        break;
		        }

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

	public static void setCoord(ISetCoordinates player) throws Exception{
		player.setCoordinate();
		column = player.getCoordC();
		row = player.getCoordR();
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


