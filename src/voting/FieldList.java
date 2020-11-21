package voting;

import java.util.ArrayList;

public class FieldList {
	public ArrayList<String> fields;
	public ArrayList<String> values;
	
	public FieldList() {
		fields = new ArrayList<String>();
		values = new ArrayList<String>();
	}
	
	public void addField(String field, String value) {
		fields.add(field);
		values.add(value);
	}
	
	public void addField(String field, int value) {
		fields.add(field);
		values.add(Integer.toString(value));
	}
	
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
	
	public int size() {
		return fields.size();
	}
}
