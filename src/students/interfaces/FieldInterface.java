package students.interfaces;

import students.items.Item;

public interface FieldInterface {

	Item[][] getFieldDimensions();
	
	void till(int rowIndex, int columnIndex);
	
	void tick();
	
	String getSummary();
	
}
