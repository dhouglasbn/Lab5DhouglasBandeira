package documin.document;

public class Title extends Element {
	
	private int level;
	
	private boolean linkable;
	
	
	public Title(String value, int priority, int level, boolean linkable) {
		super(value, priority);
		this.level = level;
		this.linkable = linkable; 
	}
	
	public String generateFullRepresentation() {
		String representation = this.level + ". " + this.value;
		if (this.linkable) {
			representation += " -- " + this.getLink();
		}
		return representation;
	}
	
	public String generateShortRepresentation() {
		return this.level + ". " + this.value;
	}
	
	public String getLink() {
		return this.level + "-" + this.value.trim().toUpperCase();
	}
}
