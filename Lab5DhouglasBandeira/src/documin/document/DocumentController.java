package documin.document;

import java.util.HashMap;

public class DocumentController {

	private HashMap<String, Document> documentsMap;
	
	public DocumentController() {
		this.documentsMap = new HashMap<>();
	}
	
	public boolean createDocument(String title) {
		boolean result = false;
		try {
			if (this.documentAlreadyExists(title)) return result;
			Document document = new Document(title);
			this.documentsMap.put(title, document);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
		return true;			
	}
	
	public boolean createDocument(String title, int elementsSize) {
		boolean result = false;
		try {
			if (this.documentAlreadyExists(title)) return result;
			Document document = new Document(title, elementsSize);
			this.documentsMap.put(title, document);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return true;	
	}
	
	public void deleteDocument(String title) {
		this.documentsMap.remove(title);
	}
	
	public int getElementsNumber(String title) {
		Document document = this.documentsMap.get(title);
		return 0;
	}
	
	public Element[] getElements(String title) {
		return null;
	}
	
	private boolean documentAlreadyExists(String title) {
		return this.documentsMap.containsKey(title);
	}
}
