package students;

import java.util.Scanner; //For user input

public class Farm {
	
	private int fieldWidth = 0;
	private int fieldHeight = 0;
	private double startingFunds = 0.0;
	
	/**
	 * Farm class constructed with a width & height parameter to be used in creating a new Field object
	 * @param fieldWidth
	 * @param fieldHeight
	 * @param startingFunds dictates how much money the player starts with
	 */
	public Farm(int fieldWidth, int fieldHeight, double startingFunds) {
		
		this.fieldWidth = fieldWidth;
		this.fieldHeight = fieldHeight;
		this.startingFunds = startingFunds;
	}
	
	
	
	public void run() {
		
		Field gameField = new Field(this.fieldWidth, this.fieldHeight); //Using Farm's height and width as the parameters for a field object
		menuPrompt();
	}
	
	
	
	private static void menuPrompt() {
		
		System.out.println("Enter your next action:");
		System.out.println("  t [x] [y]: till");
		System.out.println("  h [x] [y]: harvest");
		System.out.println("  p [x] [y]: plant");
		System.out.println("  s: field summary");
		System.out.println("  w: wait");
		System.out.println("  q: quit");
		
	}
	
	public static void main(String[] args) {
		
		Farm simFarm = new Farm(10, 10, 10.0);
		simFarm.run();
	}
}
