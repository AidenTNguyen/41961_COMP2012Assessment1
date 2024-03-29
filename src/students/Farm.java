package students;

import java.util.Scanner; //For user input
import students.interfaces.*;

import students.items.*;

public class Farm {
	
	private int fieldWidth = 0;
	private int fieldHeight = 0;
	private double Funds = 10.0;
	private GameController gameField;
	
	/**
	 * Farm class constructed with a width & height parameter to be used in creating a new Field object
	 * @param fieldWidth
	 * @param fieldHeight
	 * @param startingFunds dictates how much money the player starts with
	 * @param gameField new Field object to be used in the game
	 */
	public Farm(int fieldWidth, int fieldHeight) {
		
		this.fieldWidth = fieldWidth;
		this.fieldHeight = fieldHeight;
		
		FieldInterface fieldDimensions = new Field(fieldWidth, fieldHeight); //Using Farm's height and width as the parameters for a field object
		this.gameField = new GameController(fieldDimensions);
	}
	
	
	Scanner scannerObject = new Scanner(System.in);
	
	public void run() { //Function to initiate the game
		
		boolean activeGame = true;
		int maxTurns = GameController.getMaxTurns();
		
		int rounds = 1;
		
		while (activeGame) { // This while loop is for the whole game flow to repeat
			
			int turns = 1;
			double winCost = GameController.getWinCost();
			
			while (!winCondition(winCost) && turns <= maxTurns) { // While win condition is not true and turns are within the maximum turns
				
				try { // Slows the game pace for user's to process the result of their actions
					Thread.sleep(1000); //1000 = 1 second wait
				} catch (InterruptedException interrupted) {
					System.out.print("Thread sleep was interrupted");
				}
	
				System.out.println("\nRound: " + rounds + "\nTurn: " + turns + " / " + maxTurns);
				menuPrompt();
				String rawUserInput = scannerObject.nextLine().toLowerCase(); //Converts the user input to lower case for added formatting
				
				while (rawUserInput.isEmpty() || !Character.toString(rawUserInput.charAt(0)).matches("[a-zA-Z]")) {
					System.out.println("Invalid input. Please try again.");
					rawUserInput = scannerObject.nextLine().toLowerCase();
				}
				
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
								progressTurn();
								gameField.till(coordinates[0], coordinates[1]);
								turns++;
							}
							
							else if (commandChar == 'h') { // Harvest
								harvest(coordinates[0], coordinates[1]);
								progressTurn();
								turns++;
								
							}
							
							else { // Plant
								plant(coordinates[0],coordinates[1]);
								progressTurn();
								turns++;
								
							}
							
						}
					
				}
				
				//Rest of the user options that dont require coordinates
				else if (commandChar == 's') {
					summary();
				}
				
				else if (commandChar == 'w') {
					progressTurn();
					turns++;
				}
				
				else if (commandChar == 'q') {
					activeGame = false;
				}
				
				else {
					System.out.println("Invalid input. Please try again.");
				}
			}
			

			if (turns > maxTurns) {
				// Game loss because of max turns reached
				System.out.println("You have reached the turn limit, Game Over.\nwould you like to play again? (y/n)");
			}
			else {
				// Win condition is met
				System.out.println("Would you like to proceed to the next round?\n(y/n)");
			}
			String playAgain = scannerObject.nextLine().toLowerCase();
			
			boolean validInput = false;
			while (!validInput) {
				if (playAgain.equals("y")) {
					
					if (rounds <= maxTurns) { // Won Game
						newGame(true);
						Funds = 10.0;
						turns = 1;
						rounds++;
					}
					else { // Lost Game
						newGame(false);
						Funds = 10.0;
						turns = 1;
						rounds = 1;
					}
					
					validInput = true;
				}
				else if (playAgain.equals("n")) {
					activeGame = false;
					validInput = true;
				}
				else {
					System.out.println("Invalid input, please enter 'y' or 'n'.");
					playAgain = scannerObject.nextLine().toLowerCase();
				}
			}
			
		}
		scannerObject.close();
	}
	
	
	/**
	 * checks if the current player funds meet or exceed the win cost
	 * @param winCost
	 * @return boolean
	 */
	private boolean winCondition(double requiredWinCost) {
		if (Funds >= requiredWinCost) {
			System.out.println("**Congratulations you've beaten this round**!\n");
			return true;
		}
		return false;
	}
	
	
	
	/**
	 * Increases the win cost and allows the player to select from a number of buffs IF they won the round
	 */
	private void newGame(boolean ifWon) {
		if (ifWon) {
			GameController.incrementWinCost();
			buffOffers();
		}
		FieldInterface fieldDimensions = new Field(fieldWidth, fieldHeight);
		this.gameField = new GameController(fieldDimensions); // Resets the field
	}
	
	/**
	 * This function will be called in newGame to list a number of buffs for the player to choose
	 */
	private void buffOffers() {
		
		double[] buffHolder = GameController.getBuffsList();
		
		boolean exitLoop = false;
		while (!exitLoop) {
			
			int userChoice = scannerObject.nextInt();
			
			if (userChoice == 1) {
				GameController.applyItemBuff(1, buffHolder[0]);
				exitLoop = true;
			} 
			
			else if (userChoice == 2) {
				GameController.applyItemBuff(2, buffHolder[1]);
				exitLoop = true;
			}
			
			else {
				System.out.println("Invalid input, please select one of the valid options.");
			}
			
		}
	}
	
	
	
	/**
	 * Function to print the field, current funds and menu options
	 * @param field designated for print
	 */
	private void menuPrompt() {
		
		double winCost = GameController.getWinCost();
		FieldInterface field = gameField.getField();
		System.out.print(field);
		
		System.out.println("\nBank balance: $" + Funds);
		System.out.println("Your current goal is: $" + winCost + "\n");
		
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
		
		for (int index = 0; index < 2; index++) { // User will input x axis first while programming conventions of 2D arrays are typically y axis first hence the reversal
			try {
				coordinates[index] = Integer.parseInt(parts[index + 1]) - 1; //converting the strings at index 1 and 2 into integers from parts into coordinates // Also subtracts 1 the integer value to reflect java index values
			} 
			
			catch (NumberFormatException invalidInteger) {
				System.out.println("\n##Invalid coordinates entered##");
				return null; // Error to be handled by the caller
			}
			
			catch (ArrayIndexOutOfBoundsException noIntegers) {
				System.out.println("\n##Not enough coordinates entered##");
				return null;
						
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
	private void harvest(int rowIndex, int columnIndex) {
		
		Item[][] fieldArray = gameField.getFieldDimensions();
		ItemInterface harvestedItem;
	
		ItemInterface selectedItem = fieldArray[rowIndex][columnIndex]; // Casting the item at the position to an ItemInterface object
		harvestedItem = new GameController(selectedItem); // Using the Item constructor in GameController to store an ItemInterface object
		
		double returnValue = harvestedItem.getValue();
		Funds += returnValue;
		
		if (Double.compare(returnValue, 0) == 0) { // is the return Value equal to 0?
			System.out.println("The item was not mature.");
		}
		
		fieldArray[rowIndex][columnIndex] = new UntilledSoil();
		
		System.out.println("Sold '" + selectedItem.toString() + "' for $" + returnValue + "\n");
	}
	
	
	
	/**
	 * This replaces a Soil object with a player selected Item to be planted.
	 * If an invalid choice is made then the game will wait a turn
	 * If they try to plant an item on a coordinate that is not Soil the game will wait a turn
	 * @param rowIndex
	 * @param columnIndex
	 */
	private void plant(int rowIndex, int columnIndex) {
		
		Item[][] fieldArray = gameField.getFieldDimensions();
		
		if	(!(fieldArray[rowIndex][columnIndex] instanceof Soil)) { // Is the selected position a soil object?
			System.out.println("You cannot plant on anything other than Soil.\n");
			return;
		}
		
		System.out.println("- 'a' to buy an apple for $" + Apples.getSeedCost());
		System.out.println("- 'g' to buy an apple for $" + Grain.getSeedCost());
		
		String userChoice = scannerObject.nextLine().toLowerCase();
		String formattedInput = userChoice.replaceAll("\\s", ""); // If the user adds spaces by accident it gets removed
		
		switch (formattedInput) {
			// Apples
			case "a":
				if (Funds >= Apples.getSeedCost()) {
					fieldArray[rowIndex][columnIndex] = new Apples();
					Funds -= Apples.getSeedCost();
				} else {
					System.out.println("You have insufficient funds for this purchase.");
				}
				break;
				
			// Grain
			case "g":
				if (Funds >= Grain.getSeedCost()) {
					fieldArray[rowIndex][columnIndex] = new Grain();
					Funds -= Grain.getSeedCost();
				} else {
					System.out.println("You have insufficient funds for this purchase.");
				}
				break;
			
			default:
				System.out.println("That item does not exist.");
				break;
		}
	}

	
	
	/**
	 * Prints the summary of the current gameField
	 */
	private void summary() {
		System.out.print(gameField.getSummary());
		
		try { // Slows the game pace for user's to process the result of their actions
			Thread.sleep(2000); //1000 = 1 second wait
		} catch (InterruptedException interrupted) {
			System.out.print("Thread sleep was interrupted");
		}
	}
	
	
	/**
	 * Function to skip a turn
	 */
	private void progressTurn() {
		gameField.tick();
		System.out.println("Turn progressed.");
	}
	
	
	
	
	public static void main(String[] args) {
		
		Farm simFarm = new Farm(10, 10);
		simFarm.run();
	}
}
