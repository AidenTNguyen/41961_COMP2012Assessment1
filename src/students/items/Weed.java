package students.items;

public class Weed extends Food {

	/**
	 * Super constructor for the class Weed with predetermined values of -1 for maturation and death age as well as value
	 */
	public Weed() {
		super(-1, -1, -1); //As a placeholder for infinity -1 will be used for both maturation age and death age
	}
	
	/**
	 * Overriden toString method to represent Weed class
	 */
	@Override
	public String toString() {
		return "#";
	}

}
