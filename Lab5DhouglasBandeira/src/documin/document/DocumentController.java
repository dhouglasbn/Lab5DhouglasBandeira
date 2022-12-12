package documin.document;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class DocumentController {

	private HashMap<String, Document> documentsMap;
	
	public DocumentController() {
		this.documentsMap = new HashMap<>();
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
	
	public int createText(
			String docTitle,
			String value,
			int priority
			) {
		Document document = this.getDocument(docTitle);
		if (!this.isPriorityInRange(priority)) {
			throw new IndexOutOfBoundsException("PRIORIDADE(1 - 5)");
		}
		
		Text text = new Text(value, priority);
		return document.createElement(text);
	}
	
	public int createTitle(
			String docTitle,
			String value,
			int priority,
			int level,
			boolean linkable
			) {
		Document document = this.getDocument(docTitle);
		
		if (!this.isPriorityInRange(priority)) {
			throw new IndexOutOfBoundsException("PRIORIDADE(1 - 5)");
		}
		if (!this.isLevelInRange(level)) {
			throw new IndexOutOfBoundsException("NÍVEL(1 - 5)");
		}
		
		Title title = new Title(value, priority, level, linkable);
		return document.createElement(title);
	}
	
	public int createList(
			String docTitle,
			String listValue,
			int priority,
			String spacer,
			String charList
			) {
		Document document = this.getDocument(docTitle);
		
		if (!this.isPriorityInRange(priority)) {
			throw new IndexOutOfBoundsException("PRIORIDADE(1 - 5)");
		}
		
		ListElement elements = new ListElement(listValue, priority, spacer, charList);
		return document.createElement(elements);
	}
	
	public int createWords(
			String docTitle,
			String wordsValue,
			int priority,
			String spacer,
			String rank
			) {
		Document document = this.getDocument(docTitle);
		String upperRank = rank.toUpperCase();
		
		if (!this.isPriorityInRange(priority)) {
			throw new IndexOutOfBoundsException("PRIORIDADE(1 - 5)");
		}
		if (
				upperRank != "NENHUM" &&
				upperRank != "ALFABÉTICA" &&
				upperRank != "TAMANHO"
				) {
			throw new IllegalArgumentException(
					"ORDEM(NENHUM - TAMANHO - ALFABÉTICA)"
					);
		}
		
		Words words = new Words(wordsValue, priority, spacer, upperRank);
		return document.createElement(words);
	}
	
	public int getElementsNumber(String title) {
		Document document = this.getDocument(title);
		
		return document.countElements();
	}
	
	// Falta testar
	public String[] getElements(String title) {
		Document document = this.getDocument(title);
		
		return document.showDocument();
	}
	
	public String getFullRepresentation(String docTitle, int elementPosition) {
		Document document = this.getDocument(docTitle);
		
		if (!document.isIndexInElementsRange(elementPosition)) {
			throw new IndexOutOfBoundsException("ELEMENTO INEXISTENTE");
		}
		
		return document.getElement(elementPosition).generateFullRepresentation();
	}
	
	public String getShortRepresentation(String docTitle, int elementPosition) {
		Document document = this.getDocument(docTitle);
		
		if (!document.isIndexInElementsRange(elementPosition)) {
			throw new IndexOutOfBoundsException("ELEMENTO INEXISTENTE");
		}
		
		return document.getElement(elementPosition).generateShortRepresentation();
	}
	
	public boolean removeElement(String docTitle, int elementPosition) {
		Document document = this.getDocument(docTitle);
		
		if (!document.isIndexInElementsRange(elementPosition)) {
			throw new IndexOutOfBoundsException("ELEMENTO INEXISTENTE");
		}
		
		return document.removeElement(elementPosition);
	}
	
	public void moveElementUp(String docTitle, int elementPosition) {
		Document document = this.getDocument(docTitle);
		
		if (!document.isIndexInElementsRange(elementPosition)) {
			throw new IndexOutOfBoundsException("ELEMENTO INEXISTENTE");
		}
		
		document.moveElementUp(elementPosition);
	}
	
	public void moveElementDown(String docTitle, int elementPosition) {
		Document document = this.getDocument(docTitle);
		
		if (!document.isIndexInElementsRange(elementPosition)) {
			throw new IndexOutOfBoundsException("ELEMENTO INEXISTENTE");
		}
		
		document.moveElementDown(elementPosition);
	}
	
	private boolean documentAlreadyExists(String title) {
		return this.documentsMap.containsKey(title);
	}
	
	private boolean isPriorityInRange(int priority) {
		if (priority < 1 || priority > 5) {
			return false;
		}
		return true;
	}
	
	private boolean isLevelInRange(int level) {
		if (level < 1 || level > 5) {
			return false;
		}
		return true;
	}
}
