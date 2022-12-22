package documin.document;

public class PriorityVision extends Vision {
	
	private int priority;

	public PriorityVision(Document document, int priority) {
		super(document);
		this.priority = priority;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	@Override
	public String[] generateRepresentation() {
		String[] result = new String[this.countPriorityElements()];
		int counter = 0;
		
		for (int index = 0; index < this.document.countElements(); index++) {
			Element element = this.document.getElement(index);
			if (element.getPriority() >= this.priority) {
				result[counter] = element.generateFullRepresentation();
				counter++;
			}
		}
		return result;
	}
	
	private int countPriorityElements() {
		int result = 0;
		
		for (int index = 0; index < this.document.countElements(); index++) {
			Element element = this.document.getElement(index);
			if (element.getPriority() >= this.priority) {
				result++;
			}
		}
		return result;
	}
}