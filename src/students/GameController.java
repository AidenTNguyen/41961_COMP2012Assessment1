package students;

import students.interfaces.FieldInterface;
import students.interfaces.ItemInterface;
import students.items.Item;

// This class will control and regulate any boons or modifiers added to the game by implementing interfaces and intercepting method calls
public class GameController implements ItemInterface, FieldInterface {
	
	private FieldInterface field;
	private ItemInterface item;

	public GameController(FieldInterface field) {
		this.field = field;
	}
	
	public GameController(ItemInterface item) {
		this.item = item;
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
	
	
	
	public FieldInterface getField() {
		return this.field;
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
	
	
	
	// Follwing methods are intercepted methods \\

	
	
	@Override
	public double getValue() {
		double originalValue = item.getValue();
		
		double modifiedValue = originalValue * 5; //placeholder value
		
		return modifiedValue;	
	}

	/**
	 * Intercepts field's getFieldDimensions function
	 */
	@Override
	public Item[][] getFieldDimensions() {
		return field.getFieldDimensions();
	}

	/**
	 * Intercepts field's till function
	 */
	@Override
	public void till(int rowIndex, int columnIndex) {
		field.till(rowIndex, columnIndex);
		
	}

	/**
	 * Intercepts field's tick function
	 */
	@Override
	public void tick() {
		field.tick();
		
	}

	/**
	 * Intercepts field's getSummary funcction
	 */
	@Override
	public String getSummary() {
		return field.getSummary();
	}
}
