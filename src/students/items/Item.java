package students.items;

/**
 * Represents the base class of all foods.
 */

public class Item {
	
	//Variables to be used in constructing of Item objects
	private int age = 0;
	private int maturationAge = 0;
	private int deathAge = 0;
	private double monetaryValue = 0.0;
	
	/**
	 * Constructs a new Item object with age of maturity, death and monetary value
	 * @param age represents the current age of the item (starts at 0)
	 * @param maturationAge age of which the item reaches maturity
	 * @param deathAge the expected lifespan of the item
	 * @param monetaryValue the value of the item
	 */
	public Item(int age, int maturationAge, int deathAge, double monetaryValue) {
		
		this.age = age;
		this.maturationAge = maturationAge;
		this.deathAge = deathAge;
		this.monetaryValue = monetaryValue;
	}
	
}
