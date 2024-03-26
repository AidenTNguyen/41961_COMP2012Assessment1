package students;

// This class will control and regulate any boons or modifiers added to the game
public class GameController {
	
	private static double winCost = 25.0;
	
	
	
	/**
	 * This method will return the cost to win the game
	 * @return winCost
	 */
	public static double getWinCost() {
		
		double initialGrowthRate = 1.5; // This may be changed with a difficulty level system
		
		double calculatedCost = calculateWinCost(winCost, initialGrowthRate);
		winCost = calculatedCost;

		return calculatedCost;
	}
	
	
	
	/**
	 * This method calculates the growth of the win condition
	 * @param initialAmount is the initial win cost
	 * @param growthRate how quickly the
	 * @return the new cost to win the round
	 */
	private static double calculateWinCost(double initialAmount, double growthRate) {
		
		double calculatedCost = initialAmount * growthRate;
		return calculatedCost;
	}
	
	public static void main(String[] args) {
		
		for (int index = 0; index < 10; index++) {
			System.out.println(getWinCost());
		}
		
	}
}
