package documin.document;

/** Representação abstrata de uma visão.
 * 
 * @author Dhouglas Bandeira
 *
 */
public abstract class Vision {
	
	/**
	 * documento da visão
	 */
	protected Document document;
	
	/** Constrói uma visão.
	 * 
	 * @param document
	 */
	public Vision(Document document) {
		this.document = document;
	}
	
	/** Pega as representações dos elementos do documento.
	 * 
	 * @return elements representations
	 */
	public abstract String[] generateRepresentation();
}
