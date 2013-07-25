/**
 * User: Oleg
 * Date: 19.07.13
 * Time: 18:21
 */
/* Класс сопоставляет входящие координаты хода
* и выдает координаты необходимые для постановки фишки на доску.
* При этом в зависимости от очередности хода определяется тип
* фишки, который передается вместе с координатами.*/

 public class Move {

    private  char[][] chipCurrentMove = new char[3][3];
    private int startRow;
    private int startColumn;
    private char moveOrder;
    private int currentVirtualChip;
    private final int START_COLUMN = 1;
    private final int START_ROW = 0;
    private final int VIRTUAL_CHIP_X = 1;
    private final int VIRTUAL_CHIP_Zero = 10;

	public void setStartMoveOrder(){
        moveOrder = 'x';
	}

    public void setChipPlace(int c, int r){

        startColumn = (c * 6) + START_COLUMN - 6;
        startRow = (r * 4) + START_ROW - 4;
    }
    public int getChipStartColumn(){
        return startColumn;
    }
    public int getChipStartRow(){
        return startRow;
    }

    public void setCurrentMoveChip(){
	    Chip chip = new Chip();
        if (moveOrder == 'x') {
	        chipCurrentMove = chip.getChipXx();
            currentVirtualChip = VIRTUAL_CHIP_X;
            moveOrder = '0';
        }
        else {
            chipCurrentMove = chip.getChipOo();
            currentVirtualChip = VIRTUAL_CHIP_Zero;
            moveOrder = 'x';
        }


    }
    public char[][] getCurrentMoveChip (){
        return chipCurrentMove;
    }

    public int getCurrentVirtualChip(){
        return currentVirtualChip;
    }
}
