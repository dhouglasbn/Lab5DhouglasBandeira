package documin.document;

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
		String[] list = this.value.split(this.spacer);
		
		for(int index = 0; index < list.length; index++) {
			representation += this.charList + " " + list[index] + "\n";
		}
		return representation;
	}
	
	public String generateShortRepresentation() {
		String representation = "";
		String[] list = this.value.split(this.spacer);
		
		for(int index = 0; index < list.length; index++) {
			representation += list[index] + ", ";
		}
		representation += "\n";
		return representation;
	}
}
