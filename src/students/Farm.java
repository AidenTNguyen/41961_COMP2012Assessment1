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
	
	
	
	public void run() { //Function to initiate the game
		
		Field gameField = new Field(this.fieldWidth, this.fieldHeight); //Using Farm's height and width as the parameters for a field object
		
		boolean activeGame = true;
		Scanner scannerObject = new Scanner(System.in);
		
		while (activeGame) {
			menuPrompt(gameField);
			String rawUserInput = scannerObject.nextLine().toLowerCase(); //Converts the user input to lower case for added formatting
			String finalUserInput = stringFinalizer(rawUserInput); //Formatted user input to be used below
			
			char commandChar = finalUserInput.charAt(0);
			int[] coordinates = getCoordinates(finalUserInput);
			
			if (commandChar == 't' || commandChar == 'h' || commandChar == 's') {
				
				if (coordinates[0] > gameField.height || coordinates[1] > gameField.width)
			}
			
//			if (finalUserInput.charAt(0) == 't') {
//				int[] coordinates = getCoordinates(finalUserInput);
//				gameField.till(coordinates[0], coordinates[1]);
//			}
//			
//			else if (finalUserInput.charAt(0) == 'h') {
//				//
//			}
//			
//			else if (finalUserInput.charAt(0) == 'p') {
//				//
//			}
			
			else if (finalUserInput.charAt(0) == 's') {
				//
			}
			
			else if (finalUserInput.charAt(0) == 'w') {
				//
			}
			
			else if (finalUserInput.charAt(0) == 'q') {
				activeGame = false;
			}
			
			else {
				System.out.println("Invalid input. Please try again.");
			}
		}
		
		scannerObject.close();
	}
	
	
	/**
	 * Function to print the field, current funds and menu options
	 * @param field designated for print
	 */
	private void menuPrompt(Field field) {
		
		System.out.print(field);
		
		System.out.println("\nBank balance: $" + startingFunds + "\n");
		
		System.out.println("Enter your next action:");
		System.out.println("  t [x] [y]: till");
		System.out.println("  h [x] [y]: harvest");
		System.out.println("  p [x] [y]: plant");
		System.out.println("  s: field summary");
		System.out.println("  w: wait");
		System.out.println("  q: quit");
		
	}
	
	
	/**
	 * This function removes leading and trailing whitespaces for use in menu prompt selection
	 * @param input
	 * @return formatted string
	 */
	private String stringFinalizer(String input) {
		
		String[] parts = input.split("\\s+");
		String finalString = String.join(" ", parts);
		return finalString;
	}
	
	
	/**
	 * This function separates the command part of a user input from the coordinates
	 * @param input from the user consisting of a command letter followed by two coordinates
	 * @return an array of two integers representing the coordinates extracted from the input
	 */
	private int[] getCoordinates(String input) {
		String[] parts = input.split("\\s+");
		int[] coordinates = new int[2];
		
		for (int index = 0; index < 2; index++) {
			coordinates[index] = Integer.parseInt(parts[index+1]); //converting the strings at index 1 and 2 into integers from parts into coordinates
		}
		return coordinates;
	}
	
	
	/**
	 * Function to return value of item if past maturity and to replace with UntilledSoil object
	 * @param rowIndex
	 * @param columnIndex
	 * @return string confirming harvest outcome
	 */
//	private static String harvest(int rowIndex, int columnIndex) {
//		
//		return "item has been harvested for $#";
//	}
	
	
	/**
	 * Function to replace current object in x & y with an item
	 * @param rowIndex
	 * @param columnIndex
	 * @return String confirming planting outcome
	 */
//	private static String plant(int rowIndex, int columnIndex) {
//		
//		return "Item has been successfully planted in x,y";
//	}
	
	
	/**
	 * Function to skip a turn
	 */
//	private void wait() {
//		
//	}
	
	
	/**
	 * Function to exit out of the game loop
	 */
//	private static void quit() {
//		
//	}
	
	
	
	public static void main(String[] args) {
		
		Farm simFarm = new Farm(10, 10, 10.0);
		simFarm.run();
	}
}
