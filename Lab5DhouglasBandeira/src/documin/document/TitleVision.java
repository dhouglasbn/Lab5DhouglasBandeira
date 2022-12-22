package documin.document;

public class TitleVision extends Vision {

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