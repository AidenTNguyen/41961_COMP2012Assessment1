package students;

import java.text.DecimalFormat;

// This class will control and regulate any boons or modifiers added to the game
public class GameController {
	
	private static double winCost = 15;
	private static double growthRateMultiplier = 1.2; // This may be changed with a difficulty level system
	
	
	/**
	 * This method will return the cost to win the game
	 * @return a copy of the win cost
	 */
	public static Double getWinCost() {
		
		double copyCost = winCost;
		return copyCost; 
	}
	
	
	
	/**
	 * calculates the new win cost based on the initial amount and growth rate
	 * @param initialAmount is the initial win cost
	 * @param growthRate how quickly the
	 * @return the new cost to win the round
	 */
	private static void incrementWinCost() {
		
		double calculatedCost = winCost * growthRateMultiplier;
		
		String stringVersionOfCost = String.format("%.2f", calculatedCost); // Formatted version to 2 decimal places
		Double finalFormattedVersion = Double.parseDouble(stringVersionOfCost);
		
		winCost = finalFormattedVersion;
	}
	
	public static void main(String[] args) {
		
		for (int index = 0; index < 10; index++) {
			incrementWinCost();
			System.out.println(getWinCost());
		}
		
	}
}
