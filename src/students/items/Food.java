package students.items;

public abstract class Food extends Item{

	/**
	 * super class of Food extending from Item using the super method to copy inherit Item parameters
	 */
	public Food(int maturationAge, int expectedLifespan, double monetaryValue) {
		super(maturationAge, expectedLifespan, monetaryValue);
	}
	
}
