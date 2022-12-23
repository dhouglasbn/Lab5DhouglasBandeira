package documin.document;

/** Representação de uma visão resumida.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class ShortVision extends Vision {

	/** Constrói uma visão resumida.
	 * 
	 * @param document
	 */
	public ShortVision(Document document) {
		super(document);
	}
	
	@Override
	public String[] generateRepresentation() {
		String[] result = new String[this.document.countElements()];
		
		for (int index = 0; index < result.length; index++) {
			result[index] = this
			.document
			.getElement(index)
			.generateShortRepresentation();
		}
		return result;
	}
}