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
}
