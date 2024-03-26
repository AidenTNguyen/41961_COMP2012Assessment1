package students;

import java.util.Scanner; //For user input

import students.items.*;

public class Farm {
	
	private int fieldWidth = 0;
	private int fieldHeight = 0;
	private double Funds = 0.0;
	private Field gameField;
	
	/**
	 * Farm class constructed with a width & height parameter to be used in creating a new Field object
	 * @param fieldWidth
	 * @param fieldHeight
	 * @param startingFunds dictates how much money the player starts with
	 * @param gameField new Field object to be used in the game
	 */
	public Farm(int fieldWidth, int fieldHeight, double startingFunds) {
		
		this.fieldWidth = fieldWidth;
		this.fieldHeight = fieldHeight;
		this.Funds = startingFunds;
		
		this.gameField = new Field(fieldWidth, fieldHeight); //Using Farm's height and width as the parameters for a field object
	}
	
	
	
	public void run() { //Function to initiate the game
		
		boolean activeGame = true;
		Scanner scannerObject = new Scanner(System.in);
		
		while (activeGame) {
			
			try { // Slows the game pace for user's to process the result of their actions
				Thread.sleep(1000); //1000 = 1 second wait
			} catch (InterruptedException interrupted) {
				System.out.print("Thread sleep was interrupted");
			}

			
			menuPrompt(gameField);
			String rawUserInput = scannerObject.nextLine().toLowerCase(); //Converts the user input to lower case for added formatting
			String finalUserInput = stringFinalizer(rawUserInput); //Formatted user input to be used below
			
			char commandChar = finalUserInput.charAt(0);
			
			if (commandChar == 't' || commandChar == 'h' || commandChar == 'p') { //If conditional to check whether or not user input is for a command that requires coordinates
				
				int[] coordinates = getCoordinates(finalUserInput);
				
				if (coordinates == null || coordinates[0] > fieldHeight || coordinates[1] > fieldWidth) { // is the user's coordinate inputs outside the bounds of the field
					
					System.out.println("Error: Invalid coordinates. Coordinates must be integers and within the bounds of the field.\n");
					
				} 
				
				else 
					{
						if (commandChar == 't') { // Till
							gameField.till(coordinates[0], coordinates[1]);
						}
						
						else if (commandChar == 'h') { // Harvest
							harvest(coordinates[0], coordinates[1]);
							
						}
						
						else { // Plant
							
						}
						
					}
				
			}
			
			//Rest of the user options that dont require coordinates
			else if (commandChar == 's') {
				//
			}
			
			else if (commandChar == 'w') {
				//
			}
			
			else if (commandChar == 'q') {
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
		
		System.out.println("\nBank balance: $" + Funds + "\n");
		
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
		
		for (int index = 1; index >= 0; index--) { // User will input x axis first while programming conventions of 2D arrays are typically y axis first hence the reversal
			try {
				coordinates[index] = Integer.parseInt(parts[index+1]) - 1; //converting the strings at index 1 and 2 into integers from parts into coordinates // Also subtracts 1 the integer value to reflect java index values
			} 
			
			catch (ArrayIndexOutOfBoundsException noIntegers) {
				System.out.println("##Not enough coordinates entered##\n");
				return null;
						
			}
			catch (NumberFormatException invalidInteger) {
				System.out.println("##Invalid coordinates entered##\n");
				return null; // Error to be handled by the caller
			}

		}
		return coordinates;
	}
	
	
	
	/**
	 * Harvests the item at a specified location in the field thereby adding the value to the player's funds
	 * Harvested item is then turned into an UntilledSoil object
	 * If the item is not mature it will still be harvested but will be worth $0.0 and return a message
	 * @param rowIndex
	 * @param columnIndex
	 * @return string confirming harvest outcome
	 */
	private String harvest(int rowIndex, int columnIndex) {
		
		Item[][] fieldArray = gameField.getFieldDimensions();
		String harvestedItem = fieldArray[rowIndex][columnIndex].toString();
		
		double returnValue = fieldArray[rowIndex][columnIndex].getValue();
		Funds += returnValue;
		
		if (Double.compare(returnValue, 0) == 0) { // is the return Value equal to 0?
			System.out.println("The item was not mature.");
		}
		
		fieldArray[rowIndex][columnIndex] = new UntilledSoil();
		return "Sold '" + harvestedItem + "' for $" + returnValue;
	}
	
	
	/**
	 * Function to replace current object in x & y with an item
	 * @param rowIndex
	 * @param columnIndex
	 * @return String confirming planting outcome
	 */
//	private String plant(int rowIndex, int columnIndex) {
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
