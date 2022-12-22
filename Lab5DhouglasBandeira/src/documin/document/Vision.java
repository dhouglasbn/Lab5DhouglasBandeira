package documin.document;

public abstract class Vision {
	
	protected Document document;
	
	public Vision(Document document) {
		this.document = document;
	}
	
	public abstract String[] generateRepresentation();
}
