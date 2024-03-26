package students;

import java.text.DecimalFormat;

import student.interfaces.ItemInterface;
import students.items.Item;

// This class will control and regulate any boons or modifiers added to the game by implementing interfaces and intercepting method calls
public class GameController implements ItemInterface {
	
	private ItemInterface Item;

	public GameController(ItemInterface Item) {
		this.Item = Item;
	}
	
	
	private static double winCost = 15;
	private static double growthRateMultiplier = 1.5; // This may be changed with a difficulty level system
	
	
	
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
	public static void incrementWinCost() {
		
		double calculatedCost = winCost * growthRateMultiplier;
		
		String stringVersionOfCost = String.format("%.2f", calculatedCost); // Formatted version to 2 decimal places
		Double finalFormattedVersion = Double.parseDouble(stringVersionOfCost);
		
		winCost = finalFormattedVersion;
	}
	
	

	
	public double getValue() {
		double originalValue = Item.getValue();
		
		double modifiedValue = originalValue * 5; //placeholder value
		
		return modifiedValue;
		
		
	}
}
