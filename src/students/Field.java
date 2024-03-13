package students;
import students.items.Item; //Importing Item class from student.items package to use in a 2D array


public class Field {
	
	//Class variables for height and width of field
	private static int height = 0;
	private static int width = 0;
	private static Item[][] fieldDimensions; //This value holds a 2D array of objects
	
	public Field(int height, int width) {

		this.height = height;
		this.width = width;
		fieldDimensions = new Item[height][width];
		
		//Logic to fill the dimensions of the Field object with soil
		for (Item[] rowIndex : fieldDimensions) { //Outer loop to iterate over array elements of 2D array
			for (Item columnIndex : rowIndex) //Inner loop to iterate over int values on rowIndex arrays
	}
		
		
	
	public void tick() {
		for (int[] rowIndex : fieldDimensions) {
			for (int columnIndex : rowIndex) {
				columnIndex.tick();
				
			}
		}
	}
	
}
