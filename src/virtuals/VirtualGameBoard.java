package virtuals;

public class VirtualGameBoard {

    private int[][] virtualBoard;

    public VirtualGameBoard(int column, int row) {

        virtualBoard = new int[column][row];

        for (int r = 0; r < row; r++){
            for (int c = 0; c < column; c++){

                virtualBoard[c][r] = 0;

            }

        }

    }

    public void setChipToVirtualBoard(int column, int row, int currentChip){

        virtualBoard[column][row] = currentChip;

    }

    public int[][] getVirtualBoard() {

        return virtualBoard;

    }

}



