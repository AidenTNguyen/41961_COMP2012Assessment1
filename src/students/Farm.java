package students;

import java.util.Scanner; //For user input

public class Farm {
	
	private int fieldWidth = 0;
	private int fieldHeight = 0;
	private double startingFunds = 0.0;
	
	public Farm(int fieldWidth, int fieldHeight, double startingFunds) {
		
		this.fieldWidth = fieldWidth;
		this.fieldHeight = fieldHeight;
		this.startingFunds = startingFunds;
	}
	
	public void run() {
		
		Farm simFarm = new Farm(10, 10, 10.0);
		Field gameField = new Field(this.fieldWidth, this.fieldHeight); //Using Farm's height and width as the parameters for a field object
		
	}
	
}
