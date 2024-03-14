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
		int rowIndex = 0; //Index's to iterate through 2D array of objects
		
		for (Item[] arrayRowHolder : fieldDimensions) { //Outer loop to iterate over array elements of 2D array
			
			int columnIndex = 0; //Index resets to 0 everytime loop returns to outer loop
			
			for (Item columnElement : arrayRowHolder) { //Inner loop to iterate over Item elements held in arrayRowHolder
				fieldDimensions[rowIndex][columnIndex] = new Soil();
				columnIndex ++;
			rowIndex ++;
				
			}
		
		}
				
	}
	
	@Override
	public String toString() {
		return 
	}
		
		
//	
//	public void tick() {
//		for (int[] rowIndex : fieldDimensions[].length) {
//			for (int columnIndex : rowIndex) {
//				columnIndex.tick();
				
			}
		}
	}
	
}
