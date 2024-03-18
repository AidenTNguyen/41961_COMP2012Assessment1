package students.items;

public class UntilledSoil extends Food {

	/**
	 * Super constructor for the class UntilledSoil with predetermined values of -1 for maturation and death age as well as value
	 */
	public UntilledSoil() {
		super(-1, -1, -1.0); //As a placeholder for infinity -1 will be used for both maturation age and death age
	}
	
	/**
	 * Overriden toString method to represent UntilledSoil class
	 */
	@Override
	public String toString() {
		return "/";
	}

}

