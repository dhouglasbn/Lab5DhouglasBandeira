package documin.document;

public class ShortVision extends Vision {

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