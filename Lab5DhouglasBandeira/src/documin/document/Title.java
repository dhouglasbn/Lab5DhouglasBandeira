package documin.document;

/** Representação de um elemento de título.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class Title extends Element {
	
	/**
	 * Nível do título
	 */
	private int level;
	
	/**
	 * status de linkável do título
	 */
	private boolean linkable;
	
	/** Constrói um título.
	 * 
	 * @param value
	 * @param priority
	 * @param level
	 * @param linkable
	 */
	public Title(String value, int priority, int level, boolean linkable) {
		super(value, priority);
		this.level = level;
		this.linkable = linkable; 
	}
	
	@Override
	public String generateFullRepresentation() {
		String representation = this.level + ". " + this.value;
		if (this.linkable) {
			representation += " -- " + this.getLink();
		}
		representation += "\n";
		return representation;
	}
	
	@Override
	public String generateShortRepresentation() {
		return this.level + ". " + this.value + "\n";
	}
	
	/** Gera um link do título.
	 * 
	 * @return title link
	 */
	private String getLink() {
		String shortTitle = String.join("", this.value.split(" ")).toUpperCase();
		return this.level + "-" + shortTitle;
	}
}
