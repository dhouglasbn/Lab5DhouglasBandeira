package documin.document;

public class Text extends Element {
	
	public Text(String value, int priority) {
		super(value, priority);
	}
	
	public String generateFullRepresentation() {
		return this.value + "\n";
	}
	
	public String generateShortRepresentation() {
		return this.value + "\n";
	}
}
