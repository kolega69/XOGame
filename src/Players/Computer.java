package players;

import virtuals.StudentEngine;

public class Computer extends MenInputCoordinates implements ISetCoordinates{

	StudentEngine studentEngine;

	public Computer() {
		this("^_^ StudentEngine ^_^");
	}

	public Computer(String name) {
		super(name);
		studentEngine = new StudentEngine();
	}

	@Override
	public void setCoordinate() {

        studentEngine.setCell();

	    coordR = studentEngine.getCoordR();
		coordC = studentEngine.getCoordC();

//		System.out.println(coordC + " " + coordR);

	}

}
