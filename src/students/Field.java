package students;


public class Field {
	
	//Class variables for height and width of field
	private static int height = 0;
	private static int width = 0;
	private static int[][] fieldDimensions; //This value holds a 2D array of height and width
	
	public Field(int height, int width) {

		this.height = height;
		this.width = width;
		fieldDimensions = new int[height][width];
	}
	
	public void tick() {
		for (int[] rowIndex : fieldDimensions) { //Outer loop to iterate over array elements of 2D array
			for (int columnIndex : rowIndex) { //Inner loop to iterate over int values on rowIndex arrays
				columnIndex.tick();
				
			}
		}
	}
	
}
