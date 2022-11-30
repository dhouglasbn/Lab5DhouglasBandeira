package documin.document;

import java.util.HashMap;

public class DocumentController {

	private HashMap<String, Document> documentsMap;
	
	public DocumentController() {
		this.documentsMap = new HashMap<>();
	}
	
	public boolean createDocument(String title) {
		return true;
	}
	
	public void createDocument(String title, int elementsSize) {
		
	}
	
	public boolean deleteDocument(String title) {
		return true;
	}
	
	public int getElementsNumber(String title) {
		return 0;
	}
	
	public Element[] getElements(String title) {
		return null;
	}
}
