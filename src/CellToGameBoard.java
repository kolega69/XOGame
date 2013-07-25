
public class CellToGameBoard {


	private char[][] cell;

	public CellToGameBoard(int columns, int rows){

		cell = new char[columns][rows];
		for (int r = 0; r < rows; r++){
			for (int c = 0; c < columns - 1; c++){
				if (r < rows - 1){
					cell[c][r] = ' ';
				} else {
					cell[c][r] = '-';
				}
			}

			cell[columns - 1][r] = '|';
		}
	}

	public char[][] getCell(){
		return cell;
	}
// пока что не применяется
	public void setChipInCell(char[][] chip){
		for (int r = 0; r < chip[0].length; r++){
			for (int c = 0; c < chip.length; c++){

			}
		}

	}
}
