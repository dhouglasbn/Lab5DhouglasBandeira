package documin.document;

/** Representação abstrata dos elementos
 * 
 * @author Dhouglas Bandeira
 *
 */
public abstract class Element {

	/**
	 * prioridade do elemento
	 */
	protected int priority;
	
	/**
	 * Valor do elemento
	 */
	protected String value;
	
	/** Constrói um elemento a partir de
	 * um valor e uma prioridade
	 * 
	 * @param value
	 * @param priority
	 */
	public Element(String value, int priority) {
		this.value = value;
		this.priority = priority;
	}
	
	/** Pega o valor
	 * 
	 * @return value
	 */
	public String getValue() {
		return this.value;
	}
	
	/** Pega a prioridade
	 * 
	 * @return priority
	 */
	public int getPriority() {
		return this.priority;
	}
	
	/** Gera a representação completa do elemento.
	 * 
	 * @return fullRepresentation
	 */
	public abstract String generateFullRepresentation();
	
	/** Gera a representação resumida do elemento.
	 * 
	 * @return short Representation
	 */
	public abstract String generateShortRepresentation();
}
