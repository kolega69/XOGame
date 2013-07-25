
public class VirtualGameBoard {
   /* private int checkResult;
    private int[][] virtualBoard = new int[3][3];
    private char winFlag = 'a';
    private char[] chekFlag = new char[8];

    public void virtualBoarsErase() {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                virtualBoard[i][j] = 0;
            }
        }
    }

    public void setVirtualBoardCell(int column, int row, int currentChip){
        virtualBoard[column][row] = currentChip;
    }

    public void scanBoard(){
        int i = 0;
        for (int row = 0; row < 3; row++){
            checkResult = 0;
            for (int column = 0; column < 3; column++){
                checkResult += virtualBoard[column][row];
            }
            i++;
            checkResult(checkResult, i);
        }
        for (int column = 0; column < 3; column++){
            checkResult = 0;
            for (int row = 0; row < 3; row++){
                checkResult += virtualBoard[column][row];
            }
            i++;
            checkResult(checkResult, i);
        }
        checkResult = 0;
        for (int rc = 0; rc < 3; rc++){
            checkResult += virtualBoard[rc][rc];
            i++;
            checkResult(checkResult, i);
        }
        for (int rc = 0; rc < 3; rc++){  ???????????
            checkResult += virtualBoard[rc][rc];
            i++;
            checkResult(checkResult, i);
        }
    }
    public void checkResult(int checkResult, int i){
        if (chekFlag[i] == 'l'){
            return;
        }
        if (checkResult != 0){
            if (checkResult == 3 || checkResult == 30){
                winFlag = 'w';
                return;
            }
            if ((checkResult != 1 && checkResult != 10) && (checkResult != 2 && checkResult != 20)){
                chekFlag[i] = 'l';
            }
        }
        chekFlag[i] = 'c';
    } */
}

