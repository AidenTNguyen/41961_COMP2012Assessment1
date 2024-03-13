package students.items;

public class Apples extends Food {
	
	private static final double seedCost = 2.0; //Cost of grain seed to buy before being grown
	private static int instanceCount = 0; //Count of number of apple objects
	
	/**
	 * Subclass Apple inherits from Food extending from Item
	 */
	public Apples() {
		super(3, 5, 3.0); //Apple has predetermined values of maturity, expected lifespan and monetary value
		instanceCount++; //Increments the count of apple instances
	}
	
	/**
	 * Overrides toString method to return representation of apple depending on level of maturity
	 */
	@Override
	public String toString() {
		if (age < maturationAge) {
			return "a"; //representation for apples below maturity
		} else {
			return "A"; //representation for apple that has reached maturity
		}
	}
	
	/**
	 * Method to return the number of instantiated apples as a string
	 * @return number of instantiated apple instances
	 */
	public static String getGenerationCount() {
		return "Number of instantiated apple objects: " + instanceCount;
	}
	
	
}