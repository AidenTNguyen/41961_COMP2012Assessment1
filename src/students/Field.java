package students;
import students.items.*; //Importing all classes from student.items for use in field


public class Field {
	
	//Class variables for height and width of field
	private static int height = 0;
	private static int width = 0;
	private static Item[][] fieldDimensions; //This value holds a 2D array of objects
	
	
	
	/**
	 * Creates a new field object storing values of height and width for later use in creating a 2D object array
	 * @param height parameter taken for 2D object array
	 * @param width parameter taken for 2D object array
	 */
	public Field(int height, int width) {

		this.height = height;
		this.width = width;
		fieldDimensions = new Item[height][width];
		
		for (int rowIndex = 0; rowIndex < height; rowIndex++) {
			
			for (int columnIndex = 0; columnIndex < width; columnIndex++) {
				
				fieldDimensions[rowIndex][columnIndex] = new Soil();
			}
			
		}
				
	}
	
	
	/**
	 * Method to call upon the Item superclass to invoke the tick() method on each element in Field
	 */
	public void tick() {
		for (int rowIndex = 0; rowIndex < height; rowIndex ++) {
			for (int columnIndex = 0; columnIndex < width; columnIndex++) {
				fieldDimensions[rowIndex][columnIndex].tick();
				
				//If conditional to check whether the new age of the item means its dead
				if (fieldDimensions[rowIndex][columnIndex].died() == true) {
					fieldDimensions[rowIndex][columnIndex] = new UntilledSoil();
				}
				
				//If conditional to determine whether the Soil object will be turned into a Weed object
				if (fieldDimensions[rowIndex][columnIndex] instanceof Soil) {
					Double convertChance = Math.random();
					if (convertChance <= 0.2) {
						fieldDimensions[rowIndex][columnIndex] = new Weed();
					}
				}
			}		
		}
	}
	
	
	/**
	 * returns a string representation of the Field object's 2D grid with assorted x and y axis coordinate numbers
	 */
	@Override
	public String toString() {
		String result = "   ";//placeholder string to hold the final String representation of the grid
		
		for (int columnIndex = 0; columnIndex < width; columnIndex++) {
			result += (columnIndex + 1) + " "; //x-axis numbers			
		}
		result += "\n";
		
		for (int rowIndex = 0; rowIndex < height; rowIndex++) {
			result += (rowIndex + 1) + " "; //y-axis number
			if (rowIndex < 9) { //logic to add a space after the x-axis coordinates are printed so the "10" doesnt throw the format off
				result += " ";
			}
			
			for (int columnIndex = 0; columnIndex < width; columnIndex++) {
				result += fieldDimensions[rowIndex][columnIndex] + " ";
				
					if (columnIndex == (width - 1)) { //this if conditional is to move to the next line if all columns in the row have ben printed
						result += "\n";
					}
				}
			}
		
		return result;
		}
	
	
	/**
	 * Function to create a new Soil object at the designated location regardless of whats there
	 * @param xAxis
	 * @param yAxis
	 */
	public void till(int xAxis, int yAxis) {
		fieldDimensions[xAxis][yAxis] = new Soil();
	}
	
	
	/**
	 * Retrieves the item instance located at the inputted location
	 * @param xAxis
	 * @param yAxis
	 * @return item at [xAxis][yAxis]
	 */
	public Item get(int xAxis, int yAxis) {
		Item itemCopy = fieldDimensions[xAxis][yAxis];
		return itemCopy; //Ensures the user cannot modify the element at this location
	}

	
	/**
	 * Creates a new instance of a derived Item class at given location
	 * @param xAxis
	 * @param yAxis
	 * @param item a fruit of some kind.
	 */
	public void plant(int xAxis, int yAxis, Item item) {
		fieldDimensions[xAxis][yAxis] = item;
	}
	
	
	/**
	 * returns the total value of all items in the field
	 * @return total value
	 */
	public double getValue() {
		
		Double totalValue = 0.0;
		
		for (int rowIndex = 0; rowIndex < height; rowIndex ++) {
			for (int columnIndex = 0; columnIndex < width; columnIndex++) {
				totalValue += fieldDimensions[rowIndex][columnIndex].getValue();
			}
		}
		return totalValue;
	}
}
