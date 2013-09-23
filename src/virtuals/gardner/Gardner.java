package virtuals.gardner;

import java.util.Arrays;
import java.util.HashSet;

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
	public int[]  letsPlay(int x, int y)
			throws CellIsNotEmptyException{

		if (!isCellEmpty(x, y)){
			String ex = x + " " + y;
			throw new  CellIsNotEmptyException(ex);
		}


		System.out.println(isWin(0, 0, 'B'));


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
		HashSet<String> win = new HashSet<>();
		for (int i = 0; i < 4; i++) {
			win.addAll(checkWin(x, y, chip, i));
			if ((win.size()) > 1) {
				return true;
			}
		}
        String[] coordinate = win.toArray(new String[0]);
        String[] xy = coordinate[0].split(" ");
        int[] xAndY = new int[2];
        for (int i = 0; i < xAndY.length; i++){
            xAndY[i] = Integer.parseInt(xy[i]);
            System.out.println(xAndY[i]);
        }
		return false;
	}
    public HashSet<String> checkWin(int xx, int yy, char chip, int direction) {
        int x = 0, y = 0;
	    HashSet<String> emptySell = new HashSet<>();
	    HashSet<String> emptySum = new HashSet<>();

	    start:
        for (int i = 0; i < numInTheRow; i++) {
	        for (int k = 0; k < numInTheRow; k++) {
		        x = xx - (numInTheRow - 1) + i + k;
		        switch (direction) {
			        case 0:
				        y = yy;
				        break;
			        case 1:
				        x = xx;
				        y = yy - (numInTheRow - 1) + i + k;
				        break;
			        case 2:
				        y = x + (yy - xx);
				        break;
			        case 3:
				        y = (yy + xx) - x;
				        break;
		        }
		        try {
			        if (gameBoard[x][y] != chip & gameBoard[x][y] != '\u0000') {
				        emptySell.clear();
				        continue start;
			        }
			        if (gameBoard[x][y] == '\u0000') {
				        emptySell.add(x + " " + y);
			        }
		        } catch (IndexOutOfBoundsException ex) {
			        emptySell.clear();
			        continue start;
		        }
	        }
	        /* при отсутствии пустых полей - победа*/
	        if (emptySell.size() == 0) {
		        System.out.println(emptySell.size());
		        for (int g = 0; g < 3; g++) {
			        emptySum.add("win" + g);
		        }
		        return emptySum;
	        }
	        /*если пустых полей больше одного,
		     * то очистить счетчик пустых полей*/
	        if (emptySell.size() > 1) {
		        emptySell.clear();
	        }
	        emptySum.addAll(emptySell);
	        emptySell.clear();
        }
//	    emptySum.addAll(emptySell);
	    return emptySum;
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
