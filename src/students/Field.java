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
		
//		Soil creation logic v1
//		//Logic to fill the dimensions of the Field object with soil
//		int rowIndex = 0; //Index's to iterate through 2D array of objects
//		
//		for (Item[] arrayRowHolder : fieldDimensions) { 
//			
//			int columnIndex = 0; //Index representing x-axis of 2D array
//			
//			for (Item columnElement : arrayRowHolder) { 
//				fieldDimensions[rowIndex][columnIndex] = new Soil();
//				columnIndex ++;
//			rowIndex ++;
//				
//			}
//		
//		}
		
		
//		Soil creation logic v2
		for (int rowIndex = 0; rowIndex < height; rowIndex++) {
			
			for (int columnIndex = 0; columnIndex < width; columnIndex++) {
				
				fieldDimensions[rowIndex][columnIndex] = new Soil();
			}
			
		}
				
	}
//	
//	public void tick() {
//		for (int[] rowIndex : fieldDimensions[].length) {
//			for (int columnIndex : rowIndex) {
//				columnIndex.tick();
//				
//			}
//		}
//	}
	
	@Override
	public String toString() {
		String result = "";//placeholder string to hold the final String representation of the grid
		
		for (int columnIndex = 0; columnIndex <= width; columnIndex++) {
			result += (columnIndex + 1) + " "; //y-axis numbers			
		}
		result += "\n";
		
		for (int rowIndex = 0; rowIndex <= height; rowIndex++) {
			result += (rowIndex + 1) + "\n"; //x-axis number
			
			for (int columnIndex = 0)
				
			}
		}

		
	}
	
	
}
