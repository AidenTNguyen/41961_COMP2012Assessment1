package students.items;

public class Grain extends Food{

	/**
	 * Subclass Grain inherits from Food extending from Item
	 */
	public Grain() {
		super(2, 6, 2.0); //Grain has predetermiend values of maturity, expected lifespan and monetary value
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
	
	
}
