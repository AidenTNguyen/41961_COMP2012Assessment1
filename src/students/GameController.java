package students;

// This class will control and regulate any boons or modifiers added to the game
public class GameController {
	private static double winCost = 0.0;
	
	
	/**
	 * This method calculated the growth of the win condition
	 * @param initialAmount is the initial win cost
	 * @param growthRate how quickly the
	 * @return the new cost to win the round
	 */
	public static double calculateWinCost(double initialAmount, int growthRate) {
		
		double calculatedCost = initialAmount * (1 + growthRate);
		return calculatedCost;
	}
	
	public static void main(String[] args) {
		
		
	}
}
