/**
 * User: Oleg
 * Date: 19.07.13
 * Time: 15:46
 */
public class GameBoard {

	private int numberOfRows;
	private int numberOfColumns;
	private char[][] gameBoard;
	private final int NUMBER_START_COLUMNS = 2;
	private final int NUMBER_START_ROWS = 1;

    public GameBoard(int columns, int rows, int columnAmountCell, int rowAmountCell){
	    char letter = 'a';
	    char digit = '1';
	    numberOfColumns = columns * columnAmountCell + NUMBER_START_COLUMNS;
	    numberOfRows = rows * rowAmountCell + NUMBER_START_ROWS;

	    gameBoard = new char[numberOfColumns][numberOfRows];

	    for (int i = 0; i < numberOfRows; i++){
		    gameBoard[0][i] = ' ';
	    }
	    for (int i = ((numberOfRows - NUMBER_START_ROWS)/ rows - NUMBER_START_ROWS - 1);
	                   i < numberOfRows; i += (numberOfRows / rows)){
		    gameBoard[0][i] = digit;
		    digit++;
	    }
	    for (int i = ((numberOfColumns - NUMBER_START_COLUMNS) / columns - NUMBER_START_COLUMNS + 1);
	                   i < numberOfColumns; i += (numberOfColumns / columns)){
		    gameBoard[i][0] = letter;
		    letter++;
	    }

		for (int r = 0; r < rows; r++ ) {
			for (int c = 0; c < columns; c++){

				setCellToBoard(c, r, columnAmountCell, rowAmountCell);
			}
		}
	    drawGameBoard();
    }

	// Перенос ячейки(квадрата) в определенное место доски
	public void setCellToBoard(int column, int row, int columnAmountCell, int rowAmountCell){

		CellToGameBoard cell = new CellToGameBoard(columnAmountCell, rowAmountCell);

		for (int r = 0; r < rowAmountCell; r++){
			int rowBoard = (row * rowAmountCell) + r;
			for (int c = 0; c < columnAmountCell; c++){
				int columnBoard = (column * columnAmountCell) + c;

				gameBoard[columnBoard + NUMBER_START_COLUMNS][rowBoard + NUMBER_START_ROWS] = cell.getCell()[c][r];
			}
		}
	}


	public  void drawGameBoard(){

		for (int r = 0; r < numberOfRows - 1; r++) {
			for (int c = 0; c < numberOfColumns - 1; c++){
				System.out.print(gameBoard[c][r]);
			}
			System.out.println();
		}
	}
// в дальнейшем постановку фишки уберу - она будет устанавливаться в ячейку
// сейчас параметры вставки фишки устанавливаются вручную
    public void setChipOnBoard(int startColumn, int startRow, char[][] chip) {

        for (int row = 0; row <= 2; row++ ){
            for (int column = 0; column <= 2; column++){
                gameBoard[startColumn + column + NUMBER_START_COLUMNS]
		                [startRow + row + NUMBER_START_ROWS] = chip[row][column];
            }

        }

    }


}
