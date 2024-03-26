package students.items;

public abstract class Food extends Item{

	/**
	 * abstract class of Food derived from Item using the super method to inherit Item parameters
	 */
	public Food(int maturationAge, int expectedLifespan, double monetaryValue) {
		super(maturationAge, expectedLifespan, monetaryValue);
	}
	
	// Abstract method to get the seed costs
	public abstract double getSeedCost();
	
}
