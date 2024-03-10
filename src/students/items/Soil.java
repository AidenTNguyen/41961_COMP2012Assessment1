package students.items;

public class Soil extends Food{
	
	/**
	 * Super constructor for the class Soil with predetermined values of -1 for maturation and death age as well as value
	 */
	public Soil() {
		super(-1, -1, 0); //As a placeholder for infinity -1 will be used for both maturation age and death age
	}
	
	/**
	 * Overriden toString method to represent Soil class
	 */
	@Override
	public String toString() {
		return ".";
	}

}

