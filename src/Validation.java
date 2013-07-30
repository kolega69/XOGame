
public class Validation {

    private int[][] validationBoard;
	private boolean[] flag = new boolean[8];

    public boolean isEmpty(int chip) {

       return  (chip == 0);

    }

	public String isDrowOrWin(int[][] vBoard){

		validationBoard = vBoard;
		String result = "Continue";

		int drawFlag = 0;
		int boolIter = 0;

		for (int i = 0; i < 2; i++) {

			//проверяет горизонтали и вертикали
			for (int r = 0; r < validationBoard[1].length; r++) {

				if (!flag[boolIter]) {    // отсекает тупиковые проверки

					int sum = sumElements(r);

					if (sum == 3 || sum == 30) {
						result = "Win";
						drawFlag++;
					} else if (checkDraw(sum)){
						flag[boolIter] = true;
					} else {
						drawFlag++;
					}

				}

				boolIter++;

			}

			//проверяет диагонали
			if (!flag[boolIter]){

				int sum = sumDiagElements();

				if (sum == 3 || sum == 30) {       //немножко индусятины (пока что)
					result =  "Win";
					drawFlag++;
				} else if (checkDraw(sum)){
					flag[boolIter] = true;
				} else {
					drawFlag++;
				}

			}

			boolIter++;

			validationBoard = rotateViBoard();
			//
		}



		if (drawFlag == 0){

			result = "Draw";

		}

		return result;

	}

	public int[][] rotateViBoard() {  // поворот доски на 90 против часовой стрелки

		int[][] rotatedVB = new int[validationBoard.length][validationBoard[1].length];

		for (int r = 0; r < validationBoard.length; r++) {
			for (int c = 0; c < validationBoard[1].length; c++) {

				rotatedVB[c][r] = validationBoard[validationBoard[1].length - r - 1][c];

			}
		}

		return rotatedVB;

	}


	public int sumElements(int row) {

		int sum = 0;

		for (int column = 0; column < validationBoard.length; column++) {

			sum += validationBoard[column][row];
		}

		return sum;

	}

	public int sumDiagElements() {

		int sum = 0;

		for (int i = 0; i < validationBoard.length; i++) {

			sum += validationBoard[i][i];

		}

		return sum;

	}




	public boolean checkDraw(int sum) {

		return  (sum == 11 || sum == 12 || sum == 21);

	}

}
