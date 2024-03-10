package students.items;

public class Grain extends Food{

	private static final double seedCost = 1.0; //Cost of grain seed to buy before being grown
	private static int instanceCount = 0; //Count of number of grain objects
	
	/**
	 * Subclass Grain inherits from Food extending from Item
	 */
	public Grain() {
		super(2, 6, 2.0); //Grain has predetermiend values of maturity, expected lifespan and monetary value
		instanceCount++; //Increments the count of grain instances
	}
	
	/**
	 * Overrides toString method to return representation of grain depending on level of maturity
	 */
	@Override
	public String toString() {
		if (age < maturationAge) {
			return "g"; //representation for grain below maturity
		} else {
			return "G"; //representation for grain that has reached maturity
		}
	}
	
	/**
	 * Method to return the number of instantiated grains as a string
	 * @return number of instantiated grain instances
	 */
	public static String getGenerationCount() {
		return "Number of instantiated grain objects: " + instanceCount;
	}
	
	
}
