package documin.document;

public abstract class Element {

	private int priority;
	
	private String value;
	
	public Element(String value, int priority) {
		this.value = value;
		this.priority = priority;
	}
	
	public abstract String generateFullRepresentation();
	
	public abstract String generateShortRepresentation();
}
