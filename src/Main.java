import Players.MenInputCoordinates;
import inventory.Chip;
import inventory.GameBoard;

import java.io.IOException;

public class Main {

    private static char[][] chipCurrentMove = new char[3][3];
    private static int startRow;
    private static int startColumn;
    private static int currentVirtualChip;
    private static final int START_COLUMN = 1;
    private static final int START_ROW = 0;
    private static final int VIRTUAL_CHIP_X = 1;
    private static final int VIRTUAL_CHIP_0 = 10;
    private static final int ROWS_AMOUNT = 3;
    private static final int COLUMNS_AMOUNT = 3;
    private static final int CELL_WIDTH = 6;
    private static final int CELL_HEIGHT = 4;


    public static void main(String[] args) throws IOException {

        System.out.println("TIC-TAC-TOE");
        System.out.println();

	    Menu menu = new Menu();

        GameBoard gameBoard = new GameBoard(COLUMNS_AMOUNT, ROWS_AMOUNT, CELL_WIDTH, CELL_HEIGHT);
	    System.out.println();
	    VirtualGameBoard virtualGameBoard = new VirtualGameBoard(COLUMNS_AMOUNT, ROWS_AMOUNT);
        Validation validation = new Validation();

        MenInputCoordinates inputCoordinates = new MenInputCoordinates();
	    MenInputCoordinates player1 = new MenInputCoordinates();
	    MenInputCoordinates player2 = new MenInputCoordinates();

        for (int i = 1; i < 10; i++){

            char moveOrder;
	        int column;
	        int row;

	        for (;;) {

		        if (i % 2 == 0) {
			        moveOrder = '2';
			        player2.inputCoordinate(menu.getPlayer2Name());
			        column = player2.getCoordX();
			        row = player2.getCoordY();
		        } else {
			        moveOrder = '1';
			        player1.inputCoordinate(menu.getPlayer1Name());
			        column = player1.getCoordX();
			        row = player1.getCoordY();
		        }

		        if(validation.isEmpty(virtualGameBoard.getVirtualBoard()[column][row])){

                    break;

                }

            }



            move(column, row, moveOrder);

            gameBoard.setChipOnBoard(startColumn, startRow,chipCurrentMove);

	        System.out.println();
	        gameBoard.drawGameBoard();
	        System.out.println();

            virtualGameBoard.setChipToVirtualBoard(column, row, currentVirtualChip);

	        String result = validation.isDrowOrWin(virtualGameBoard.getVirtualBoard());

	        if (result.equals("Win")){
		        System.out.println("Player" + moveOrder + " win");
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

}
