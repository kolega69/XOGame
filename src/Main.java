/**
 * User: Oleg
 * Date: 19.07.13
 * Time: 16:27
 */
public class Main {

    private static char[][] chipCurrentMove = new char[3][3];
    private static int startRow;
    private static int startColumn;
    private static int currentVirtualChip;
    private static final int START_COLUMN = 1;
    private static final int START_ROW = 0;
    private static final int VIRTUAL_CHIP_X = 1;
    private static final int VIRTUAL_CHIP_Zero = 10;


    public static void main(String[] args) {


        GameBoard gameBoard = new GameBoard(3, 3, 6, 4);


        MenInputCoordinates inputCoordinates = new MenInputCoordinates();

        for (int i = 1; i < 10; i++){
            char moveOrder;
            try {
                inputCoordinates.inputCoordinate();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            if (i % 2 == 0) {
                moveOrder = 'x';
            } else {
                moveOrder = '0';
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
            currentVirtualChip = VIRTUAL_CHIP_Zero;
        }


    }
}
