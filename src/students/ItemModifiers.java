package students;

public abstract class ItemModifiers {
	
	/**
	 * Generates a random number between minRange (inclusive) and maxRange(exclusive)
	 * @param minRange
	 * @param maxRange
	 * @return final double value
	 */
	private double getRandomPercentage(double minRange, double maxRange) {
		double initialRandomNum = Math.random();
		double randomPercentage = (initialRandomNum * (maxRange - minRange)) + minRange; // Turns the initialRandomNum to a number between the ranges
		return Math.floor(randomPercentage * 100) / 100; // Rounds that randomPercentage to 2 decimal points
	}

}
