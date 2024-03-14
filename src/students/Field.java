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
		
		//Logic to fill the dimensions of the Field object with soil
		int rowIndex = 0;
		int columnIndex = 0;
		for (Item[] arrayRowHolder : fieldDimensions) { //Outer loop to iterate over array elements of 2D array
			for (Item arrayColumnHolder : arrayRowHolder) { //Inner loop to iterate over int values on rowIndex arrays
				fieldDimensions[rowIndex][columnIndex] = new Soil();
				columnIndex ++;
			rowIndex ++;
				
			}
		}
				
	}
		
		
	
	public void tick() {
		for (int[] rowIndex : fieldDimensions[].length) {
			for (int columnIndex : rowIndex) {
				columnIndex.tick();
				
			}
		}
	}
	
}
