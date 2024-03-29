package students;

import students.interfaces.FieldInterface;
import students.interfaces.ItemInterface;
import students.items.*;
import students.buffs.*;

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
	private static int maxTurns = 20; // May be changed later by player buffs
	private static double appleModifier = 1.0;
	private static double grainModifier = 1.0;
	
	
	/**
	 * This method will return the cost to win the game
	 * @return a copy of the win cost
	 */
	public static Double getWinCost() {
		
		double copyCost = winCost;
		return copyCost; 
	}
	
	/**
	 * @return Returns a copy of the max turns variable
	 */
	public static int getMaxTurns() {
		int maxTurnsCopy = maxTurns;
		return maxTurnsCopy;
	}
	
	
	/**
	 * Method to return the toString representation of the field stored in the gameController
	 * @return the field string representation
	 */
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
	
	// Following methods are related to the buff system \\
	
	/**
	 * Returns nothing but prints out a list of buffs from the player to choose from
	 */
	public static double[] getBuffsList() {
		
		AppleBuff appleBoon = new AppleBuff(20, 200); // The ranges may be modified by a future system
		GrainBuff grainBoon = new GrainBuff(20, 200);
		
		double appleModifierPercentage = appleBoon.getModifierPercentage();
		double grainModifierPercentage = grainBoon.getModifierPercentage();
		
		System.out.println("Please select one of the following boons!");
		System.out.println("1. Increase the value of Apples by %" + appleModifierPercentage);
		System.out.println("2. Increase the value of Grains by %" + grainModifierPercentage);
		
		double[] buffHolder = new double[2]; // This would probably be turned into a for loop if the number of items and buffs were to increase, it won't.
		buffHolder[0] = appleModifierPercentage;
		buffHolder[1] = grainModifierPercentage;
		
		return buffHolder;
	}
	
	/**
	 * This function will actually increase the value of the item with its generated percentage
	 * @param item of type ItemModifier superclass
	 */
	public static void applyItemBuff(ItemModifiers item) {
		
		if (item instanceof AppleBuff) {
			appleModifier += //
		}
		
	}
	
	
	// Following methods are intercepted methods \\

	
	/**
	 * Intercepts the Item's classes getValue function to modify the final value before being returned
	 */
	@Override
	public double getValue() {
		
		if (item instanceof Apples) { // This is an area of the program that would be best encapsulated from future complexity by separating into its own class. But, i feel like i've added enough so this is good for what is there.
			return item.getValue() * appleModifier;
		}
		else if (item instanceof Grain) {
			return item.getValue() * grainModifier;
		}
		
		return 0.0; // Item doesn't exist, somehow.

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
