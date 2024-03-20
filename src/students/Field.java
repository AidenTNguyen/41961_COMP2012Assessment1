package students;
import students.items.*; //Importing all classes from student.items for use in field


public class Field {
	
	//Class variables for height and width of field
	private int height = 0;
	private int width = 0;
	private Item[][] fieldDimensions; //This value holds a 2D array of objects
	
	private int totalAppleInstances = 0; //Variables to be used in getSummary() reflecting total instances of said item
	private int totalGrainInstances = 0;
	
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
	public void till(int yAxis, int xAxis) {
		fieldDimensions[yAxis][xAxis] = new Soil();
	}
	
	
	/**
	 * Retrieves the item instance located at the inputted location
	 * @param xAxis
	 * @param yAxis
	 * @return item at [xAxis][yAxis]
	 */
	public Item get(int yAxis, int xAxis) {
		Item itemCopy = fieldDimensions[yAxis][xAxis];
		return itemCopy; //Ensures the user cannot modify the element at this location
	}

	
	/**
	 * Creates a new instance of a derived Item class at given location
	 * @param xAxis
	 * @param yAxis
	 * @param item a fruit of some kind.
	 */
	public void plant(int yAxis, int xAxis, Item item) {
		fieldDimensions[yAxis][xAxis] = item;
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
	
	
	/**
	 * Returns a string detailing the Field object and it's value and quantities
	 * @return details on the Field object
	 */
	public String getSummary() {
		
		//variabes stores the number of item instances
		int appleInstances = 0;
		int grainInstances = 0;
		int soilInstances = 0;
		int untilledInstances = 0;
		int weedInstances = 0;
		
		Double totalValue = 0.0;
		
		for (int rowIndex = 0; rowIndex < height; rowIndex ++) {
			for (int columnIndex = 0; columnIndex < width; columnIndex++) {
				
				if (fieldDimensions[rowIndex][columnIndex] instanceof Apples) {
					
					appleInstances++;
					totalValue += fieldDimensions[rowIndex][columnIndex].getValue();
				}
				
				else if (fieldDimensions[rowIndex][columnIndex] instanceof Grain) {
					
					grainInstances++;
					totalValue += fieldDimensions[rowIndex][columnIndex].getValue();
				}
				
				//Soil is the only object without a value
				else if (fieldDimensions[rowIndex][columnIndex] instanceof Soil) {
					soilInstances++;
				}
				
				else if (fieldDimensions[rowIndex][columnIndex] instanceof UntilledSoil) {
					untilledInstances++;
					totalValue += fieldDimensions[rowIndex][columnIndex].getValue();
				}
				
				else {
					weedInstances++;
					totalValue += fieldDimensions[rowIndex][columnIndex].getValue();
				}
				
			}
		}
		
		String result = "";
		result += "Apples:          " + appleInstances + "\n";
		result += "Grains:          " + grainInstances + "\n";
		result += "Soil:            " + soilInstances + "\n";
		result += "Untilled:        " + untilledInstances + "\n";
		result += "Weed:            " + weedInstances + "\n";
		result += "For a total of: $" + totalValue;
		result += "\nTotal apples created: " + totalAppleInstances; //returns total number of apple objects in the field
		result += "\nTotal grain created: " + totalGrainInstances; //^
		
		return result;
	}
}

