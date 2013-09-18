package virtuals.gardner;

import java.util.Arrays;

/**
 * Date: 03.09.13
 * Time: 15:33
 */
public class Gardner {

	private char[][] gameBoard;
	private char[][] rotateBoard;
	private boolean isFirst;
	private char myChip;
	private int numInTheRow;
	private int column;
	private int row;
	private int coordC, coordR;
	private final int[] MOVE_CELL = new int[2];
	

	public Gardner(int columnAmount, int rowAmount,
	               int numInTheRow, boolean isFirst) {

		gameBoard = new char[columnAmount][rowAmount];
		this.numInTheRow = numInTheRow;
		myChip = isFirst ? 'B' : 'W';
	}

    // делаем ход
	public int[]  letsPlay(int column, int row)
			throws CellIsNotEmptyException{

		if (!isCellEmpty(column, row)){
			String ex = column + " " + row;
			throw new  CellIsNotEmptyException(ex);
		}

        gameBoard[1][0] = 'B';
        gameBoard[1][1] = 'B';
        gameBoard[2][1] = 'B';

        System.out.println(isWin(1, 1, 'B'));


		return MOVE_CELL;
	}

	public void setMoveCell(int column, int row){
		this.column = column;
		this.row = row;
	}

	// Проверяет - пуста ли ячейка в которую хочет походить противник
	public boolean isCellEmpty(int column,int row){
		return gameBoard[column][row] == '\u0000';
	}

	// Проверка на победу
	public boolean isWin(int x, int y, char chip) {
		for (int i = 0; i < 4; i++) {
		String result = checkWin(x, y, chip, i);
		}
		return false;
	}
    public String checkWin(int xx, int yy, char chip, int direction) {
        String points = "";
        int x = 0, y = 0;
	    int countPoints = 0;
        System.out.println(direction);
        for (int i = 0; i < numInTheRow; i++) {
	        System.out.println("+++++");
	        for (int k = 0; k < numInTheRow; k++) {
                x = xx - (numInTheRow - 1) + i + k;
                switch (direction) {
                    case 0 :
                        y = yy;
                        break;
                    case 1 :
                        x = xx;
                        y = yy - (numInTheRow - 1) + i + k;
                        break;
                    case 2 :
                        y = x + (yy - xx);
                        break;
                    case 3 :
                        y = (yy + xx) - x;
                        break;
                }
	            System.out.println(x + " : " + y);
	            try {
		            if (gameBoard[x][y] == chip) {
			            countPoints++;
		            }
	            } catch (IndexOutOfBoundsException ex) {
	            }


            }
        }
        return points;
    }

	public int getCoordC() {
		return coordC;
	}

	public int getCoordR() {
		return coordR;
	}

	public class CellIsNotEmptyException extends Exception{
	
		public CellIsNotEmptyException(String ex) {
			super(ex);
		}
	
	}


}
