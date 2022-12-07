package documin.document;

import java.util.ArrayList;

public class ListElement extends Element {
	
	private String spacer;
	
	private String charList;

	public ListElement(String value, int priority, String spacer, String charList) {
		super(value, priority);
		this.spacer = spacer;
		this.charList = charList;
	}
	
	public String generateFullRepresentation() {
		String representation = "";
		String[] list = this.getWordsArray();
		
		for(int index = 0; index < list.length; index++) {
			representation += this.charList + " " + list[index] + "\n";
		}
		return representation;
	}
	
	public String generateShortRepresentation() {
		String representation = "";
		String[] wordsList = this.getWordsArray();
		
		for(int index = 0; index < wordsList.length; index++) {
			representation += wordsList[index];
			if (index != wordsList.length - 1) {
				representation += ", ";
			}
		}
		representation += "\n";
		return representation;
	}
	
	private String[] getWordsArray() {
		String[] array = this.value.split(this.spacer);
		ArrayList<String> result = new ArrayList<>();
		for (String item: array) {
			if (!item.equals(this.spacer.trim())) {
				result.add(item);
			};
		}
		
		return result.toArray(new String[] {});
	}
}
