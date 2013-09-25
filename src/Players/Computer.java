package players;

import virtuals.StudentEngine;
import virtuals.gardner.Gardner;
import virtuals.gardner.Gardner.CellIsNotEmptyException;


public class Computer extends MenInputCoordinates implements ISetCoordinates{

	StudentEngine studentEngine;
	Gardner gardner;

	public Computer() {
		this("^_^ Gardner ^_^");
	}

	public Computer(int x, int y, int numInTheRow, boolean isFirst) {
		this("Gardner");
		gardner = new Gardner(x, y, numInTheRow, isFirst);
	}

	public Computer(String name) {
		super(name);
		studentEngine = new StudentEngine();
	}

	@Override
	public void setCoordinate(int x, int y) {

//        studentEngine.setCell();
//
//	    coordR = studentEngine.getCoordR();
//		coordC = studentEngine.getCoordC();

        int[] move = new int[2];
        try {
            move = gardner.findMove(x, y);
        } catch (CellIsNotEmptyException ex) {

        }
        coordC = move[0];
        coordR = move[1];

    }

}
