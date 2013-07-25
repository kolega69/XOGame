/**
 * User: Oleg
 * Date: 19.07.13
 * Time: 16:27
 */
public class Main {

    public static void main(String[] args) {





        GameBoard gameBoard = new GameBoard(3, 3, 6, 4);

        Move move = new Move();
        move.setStartMoveOrder();
        MenInputCoordinates inputCoordinates = new MenInputCoordinates();

        for (int i = 0; i < 9; i++){
            try {
                inputCoordinates.inputCoordinate();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

            move.setChipPlace(inputCoordinates.getCoordinateX(), inputCoordinates.getCoordinateY());
            move.setCurrentMoveChip();
            gameBoard.setChipOnBoard(move.getChipStartColumn(), move.getChipStartRow(),move.getCurrentMoveChip());
            gameBoard.drawGameBoard();
        }


    }
}
