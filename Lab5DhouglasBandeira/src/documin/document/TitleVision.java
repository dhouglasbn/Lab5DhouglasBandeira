package documin.document;

/** Representação de uma visão de títulos.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class TitleVision extends Vision {

	/** Constrói uma visão de títulos.
	 * 
	 * @param document
	 */
	public TitleVision(Document document) {
		super(document);
	}
	
	@Override
	public String[] generateRepresentation() {
		String[] result = new String[this.countTitleElements()];
		int counter = 0;
		
		for (int index = 0; index < this.document.countElements(); index++) {
			Element element = this.document.getElement(index);
			if (element instanceof Title) {
				result[counter] = element.generateShortRepresentation();
				counter++;
			}
		}
		return result;
	}
	
	/** Conta quantos elementos são títulos no documento.
	 * 
	 * @return title elements number
	 */
	private int countTitleElements() {
		int result = 0;
		
		for (int index = 0; index < this.document.countElements(); index++) {
			Element element = this.document.getElement(index);
			if (element instanceof Title) {
				result++;
			}
		}
		return result;
	}
}