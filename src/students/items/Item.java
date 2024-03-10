package students.items;

/**
 * Represents the base class of all foods.
 */

public class Item {
	
	//Variables to be used in constructing of Item objects
	protected int age = 0;
	protected int maturationAge = 0;
	protected int expectedLifespan = 0;
	protected double monetaryValue = 0.0;
	
	/**
	 * Constructs a new Item object with age of maturity, death and monetary value
	 * @param age represents the current age of the item (starts at 0)
	 * @param maturationAge age of which the item reaches maturity
	 * @param expectedLifespan the expected lifespan of the item
	 * @param monetaryValue the value of the item
	 */
	public Item(int maturationAge, int expectedLifespan, double monetaryValue) { //monetaryValue set as a double as money usually involved decimals

		this.maturationAge = maturationAge;
		this.expectedLifespan = expectedLifespan;
		this.monetaryValue = monetaryValue;
	}
	
	/**
	 * Increments age by 1
	 */
	public void tick() {
		this.age += 1;
	}
	
	/**
	 * Sets Item age
	 * @param age representing item's age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * method to determine whether item is dead or alive depending on age
	 * @return returns "Dead" or "Alive" depending on if age > expectedLifespan
	 */
	public String died() {
		if (age > expectedLifespan) {
			return "Dead";
		}
		return "Alive";
		
	/**
	 * Retrieves item's monetary value IF its age has passed age of maturity, meaning it's fully grown and harvestable. Otherwise returns 0.0
	 * @return Item's monetary value
	 */
	}
	public double getValue() {
		if (this.age > this.maturationAge) {
			return this.monetaryValue;
		}
		return 0.0; //Item is not yet fully mature
	}
	
	/**
	 * Overriden equals method to compare items of the 'Item' class and associated subclasses
	 */
	@Override
	public boolean equals(Object otherItem) {
		
		//If the object is compared with itself than return true
		if (this == otherItem) {
			return true;
		}
		
		//If the otherItem references Null than this returns false
		if (otherItem == null) {
			return false;
		}
		
		//Checks if the two items have the same age, age of maturity and expected lifespan
		Item other = (Item) otherItem;
		return age == other.age &&
				maturationAge == other.maturationAge &&
				expectedLifespan == other.expectedLifespan &&
				Double.compare(monetaryValue, other.monetaryValue) == 0;
	}
	
	/**
	 * Overriden toString method to return subclasses and their string representations
	 */
	@Override
	public String toString() {
		return "Name: " + getClass().getSimpleName() //Returning the name of the class
				+ "\nAge: " + age
				+ "\nAge of Maturity: " + maturationAge
				+ "\nExpected Lifespan (Years): " + expectedLifespan
				+ "\nMonetary Value: $" + monetaryValue;
	}
	
}
