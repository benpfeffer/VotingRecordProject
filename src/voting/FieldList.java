/*
 * This class converts user input into a list of fields to be sent into the query.
 * 
 */

package voting;

import java.util.ArrayList;

public class FieldList {
	public ArrayList<String> fields;
	public ArrayList<String> values;
	
	//Initialize field lists
	public FieldList() {
		fields = new ArrayList<String>();
		values = new ArrayList<String>();
	}
	
	//Add field with string value to field list
	public void addField(String field, String value) {
		fields.add(field);
		values.add(value);
	}
	
	//Add field with integer value to field list
	public void addField(String field, int value) {
		fields.add(field);
		values.add(Integer.toString(value));
	}
	
	//Get a value from the field
	public String getValue(String field) {
		int index = -1;
		for(int i = 0; i < fields.size(); i++) {
			if(fields.get(i) == field) {
				index = i;
				break;
			}
		} 
		if(index == -1) System.out.println("Could not find field " + field);
		return values.get(index);
	}
	
	//Get the field size
	public int size() {
		return fields.size();
	}
}