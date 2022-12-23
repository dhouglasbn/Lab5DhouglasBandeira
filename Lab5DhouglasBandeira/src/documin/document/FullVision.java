package documin.document;

/** Representação de uma visão completa.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class FullVision extends Vision {

	/** Constrói uma visão completa a partir de um documento.
	 * 
	 * @param document
	 */
	public FullVision(Document document) {
		super(document);
	}
	
	@Override
	public String[] generateRepresentation() {
		String[] result = new String[this.document.countElements()];
		
		for (int index = 0; index < result.length; index++) {
			result[index] = this
			.document
			.getElement(index)
			.generateFullRepresentation();
		}
		return result;
	}
}
