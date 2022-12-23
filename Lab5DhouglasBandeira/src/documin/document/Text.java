package documin.document;

/** Representação de um elemento de texto.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class Text extends Element {
	
	/** Constrói um texto.
	 * 
	 * @param value
	 * @param priority
	 */
	public Text(String value, int priority) {
		super(value, priority);
	}
	
	@Override
	public String generateFullRepresentation() {
		return this.value + "\n";
	}
	
	@Override
	public String generateShortRepresentation() {
		return this.value + "\n";
	}
}
