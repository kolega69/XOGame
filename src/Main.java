import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static char[][] chipCurrentMove = new char[3][3];
    private static int startRow;
    private static int startColumn;
    private static int currentVirtualChip;
    private static char gameKind;
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
        VirtualGameBoard virtualGameBoard = new VirtualGameBoard(COLUMNS_AMOUNT,ROWS_AMOUNT);


        MenInputCoordinates inputCoordinates = new MenInputCoordinates();

        for (int i = 1; i < 10; i++){

            char moveOrder;

            inputCoordinates.inputCoordinate();

            if (i % 2 == 0) {
                moveOrder = '0';
            } else {
                moveOrder = 'x';
            }

            move(inputCoordinates.getCoordinateX(), inputCoordinates.getCoordinateY(), moveOrder);
            gameBoard.setChipOnBoard(startColumn, startRow,chipCurrentMove);
            gameBoard.drawGameBoard();
        }

    }


    public static void move(int column, int row, char moveOrder){
        startColumn = (column * 6) + START_COLUMN - 6;
        startRow = (row * 4) + START_ROW - 4;

        Chip chip = new Chip(moveOrder);
        chipCurrentMove = chip.getChipReturn();

        if (moveOrder == 'x') {
            currentVirtualChip = VIRTUAL_CHIP_X;
        }
        else {
            currentVirtualChip = VIRTUAL_CHIP_0;
        }


    }
}
