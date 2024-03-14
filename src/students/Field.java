package students;
import students.items.*; //Importing all classes from student.items for use in field.


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
		for (int[] rowIndex : fieldDimensions) { //Outer loop to iterate over array elements of 2D array
			for (int columnIndex : rowIndex) { //Inner loop to iterate over int values on rowIndex arrays
				fieldDimensions[rowIndex][columnIndex] = new Soil();
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
