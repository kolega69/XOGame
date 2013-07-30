package virtuals;

/*
 алгоритм ходов компьютера для игры в крестики-нолики
 */


import java.util.Random;

public class StudentEngine {


	private int coordC;
	private int coordR;


	public void setCell(){

		Random random = new Random();
		coordC = random.nextInt(3);
		coordR = random.nextInt(3);


	}

	public int getCoordC() {
		return coordC;
	}

	public int getCoordR() {
		return coordR;
	}
}
