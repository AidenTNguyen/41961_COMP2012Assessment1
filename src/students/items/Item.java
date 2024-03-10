package students.items;

/**
 * Represents the base class of all foods.
 */

public class Item {
	
	//Variables to be used in constructing of Item objects
	private int age = 0;
	private int maturationAge = 0;
	private int expectedLifespan = 0;
	private double monetaryValue = 0.0;
	
	/**
	 * Constructs a new Item object with age of maturity, death and monetary value
	 * @param age represents the current age of the item (starts at 0)
	 * @param maturationAge age of which the item reaches maturity
	 * @param deathAge the expected lifespan of the item
	 * @param monetaryValue the value of the item
	 */
	public Item(int maturationAge, int deathAge, double monetaryValue) {

		this.maturationAge = maturationAge;
		this.expectedLifespan = deathAge;
		this.monetaryValue = monetaryValue;
	}
	
	/**
	 * Increments age by 1
	 */
	protected void tick() {
		this.age += 1;
	}
	
	/**
	 * Sets Item age
	 * @param age representing item's age
	 */
	protected void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Retrieves item's monetary value IF its age has passed age of maturity, meaning it's fully grown and harvestable. Otherwise returns 0.0
	 * @return Item's monetary value
	 */
	protected double getValue() {
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
