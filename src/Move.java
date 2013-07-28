/**
 * User: Oleg
 * Date: 19.07.13
 * Time: 18:21
 */
/* Класс сопоставляет входящие координаты хода
* и выдает координаты необходимые для постановки фишки на доску.
* При этом в зависимости от очередности хода определяется тип
* фишки, который передается вместе с координатами.*/

 /*public class Move {

    private  char[][] chipCurrentMove = new char[3][3];
    private int startRow;
    private int startColumn;
    private int currentVirtualChip;
    private final int START_COLUMN = 1;
    private final int START_ROW = 0;
    private final int VIRTUAL_CHIP_X = 1;
    private final int VIRTUAL_CHIP_Zero = 10;

    public Move(int column, int row, char moveOrder) {

        startColumn = (column * 6) + START_COLUMN - 6;
        startRow = (row * 4) + START_ROW - 4;

        inventory.Chip chip = new inventory.Chip(moveOrder);
        chipCurrentMove = chip.getChipReturn();

        if (moveOrder == 'x') {
            currentVirtualChip = VIRTUAL_CHIP_X;
        }
        else {
            currentVirtualChip = VIRTUAL_CHIP_Zero;
        }
    }


    public int getChipStartColumn(){
        return startColumn;
    }
    public int getChipStartRow(){
        return startRow;
    }

    public char[][] getCurrentMoveChip (){
        return chipCurrentMove;
    }

    public int getCurrentVirtualChip(){
        return currentVirtualChip;
    }
}
                          */