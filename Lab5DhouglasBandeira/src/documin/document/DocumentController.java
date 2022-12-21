package documin.document;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class DocumentController {

	private HashMap<String, Document> documentsMap;
	
	public DocumentController() {
		this.documentsMap = new HashMap<String, Document>();
	}
	
	public boolean createDocument(String title) {
		if (title.isBlank()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		if (this.documentAlreadyExists(title)) return false;
		
		Document document = new Document(title);
		this.documentsMap.put(title, document);
		return true;	
	}
	
	public boolean createDocument(String title, int elementsSize) {
		if (title.isBlank()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		if (this.documentAlreadyExists(title)) return false;
		
		Document document = new Document(title, elementsSize);
		this.documentsMap.put(title, document);
		return true;	
	}
	
	public void deleteDocument(String title) {
		if (title.isBlank()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		
		this.documentsMap.remove(title);
	}
	
	public Document getDocument(String title) {
		if (title.isBlank()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		
		Document document = this.documentsMap.get(title);
		if (document == null) {
			throw new NoSuchElementException("O DOCUMENTO NÂO ESTÁ CADASTRADO");
		}
		return document;
	}
	
	public String[] showDocument(String title) {
		Document document = this.getDocument(title);
		
		return document.showDocument();
	}
	
	public boolean isDocumentFull(String title) {
		return this.getDocument(title).isFull();
	}
	
	private boolean documentAlreadyExists(String title) {
		return this.documentsMap.containsKey(title);
	}
}
