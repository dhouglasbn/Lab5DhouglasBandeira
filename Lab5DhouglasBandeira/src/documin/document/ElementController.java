package documin.document;

public class ElementController {

	private DocumentController documentController;
	
	public ElementController(DocumentController documentController) {
		this.documentController = documentController;
	}
	
	public int createText(
			String docTitle,
			String value,
			int priority
			) {
		if (this.documentController.isDocumentFull(docTitle)) {
			throw new IllegalStateException("LIMITE DE ELEMENTOS ATINGIDO!");
		}
		if (!this.isPriorityInRange(priority)) {
			throw new IndexOutOfBoundsException("PRIORIDADE(1 - 5)");
		}
		
		Document document = this.documentController.getDocument(docTitle);
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

		if (this.documentController.isDocumentFull(docTitle)) {
			throw new IllegalStateException("LIMITE DE ELEMENTOS ATINGIDO!");
		}
		if (!this.isPriorityInRange(priority)) {
			throw new IndexOutOfBoundsException("PRIORIDADE(1 - 5)");
		}
		if (!this.isLevelInRange(level)) {
			throw new IndexOutOfBoundsException("NÍVEL(1 - 5)");
		}
		
		Document document = this.documentController.getDocument(docTitle);
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
		if (this.documentController.isDocumentFull(docTitle)) {
			throw new IllegalStateException("LIMITE DE ELEMENTOS ATINGIDO!");
		}
		if (!this.isPriorityInRange(priority)) {
			throw new IndexOutOfBoundsException("PRIORIDADE(1 - 5)");
		}
		
		Document document = this.documentController.getDocument(docTitle);
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
		String upperRank = rank.toUpperCase();
		
		if (this.documentController.isDocumentFull(docTitle)) {
			throw new IllegalStateException("LIMITE DE ELEMENTOS ATINGIDO!");
		}
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
		
		Document document = this.documentController.getDocument(docTitle);
		Words words = new Words(wordsValue, priority, spacer, upperRank);
		return document.createElement(words);
	}
	
	public int createShortcut(String docTitle, String shortcutTitle) {
		Document document = this.documentController.getDocument(docTitle);
		Document shortcutDoc = this.documentController.getDocument(shortcutTitle);
		
		if (this.documentController.isDocumentFull(docTitle)) {
			throw new IllegalStateException("LIMITE DE ELEMENTOS ATINGIDO!");
		}
		if (document.isShortcut()) {
			throw new IllegalStateException("ATALHO NÃO PODE TER ATALHO!");
		}
		if (this.documentHasShortcuts(shortcutTitle)) {
			throw new IllegalStateException("DOCUMENTO QUE TEM ATALHOS NÂO PODE SER ATALHO!");
		}
		
		Shortcut shortcut = new Shortcut(
				shortcutDoc.getTitle(),
				shortcutDoc.getTotalElementsSize()
				);
		shortcutDoc.setIsShortcut(true);
		return document.createElement(shortcut);
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
	
	private boolean documentHasShortcuts(String docTitle) {
		Document document = this.documentController.getDocument(docTitle);
		boolean hasShortcut = false;
		
		for (int index = 0; index < document.countElements(); index++) {
			Element element = document.getElement(index);
			if (element instanceof Shortcut) {
				hasShortcut = true;
				break;
			}
		}
		return hasShortcut;
	}
	
	public String getFullRepresentation(String docTitle, int elementPosition) {
		Document document = this.documentController.getDocument(docTitle);
		
		if (!document.isIndexInElementsRange(elementPosition)) {
			throw new IndexOutOfBoundsException("ELEMENTO INEXISTENTE");
		}
		
		return document.getElement(elementPosition).generateFullRepresentation();
	}
	
	public String getShortRepresentation(String docTitle, int elementPosition) {
		Document document = this.documentController.getDocument(docTitle);
		
		if (!document.isIndexInElementsRange(elementPosition)) {
			throw new IndexOutOfBoundsException("ELEMENTO INEXISTENTE");
		}
		
		return document.getElement(elementPosition).generateShortRepresentation();
	}
	
	public boolean removeElement(String docTitle, int elementPosition) {
		Document document = this.documentController.getDocument(docTitle);
		
		if (!document.isIndexInElementsRange(elementPosition)) {
			throw new IndexOutOfBoundsException("ELEMENTO INEXISTENTE");
		}
		
		return document.removeElement(elementPosition);
	}
	
	public void moveElementUp(String docTitle, int elementPosition) {
		Document document = this.documentController.getDocument(docTitle);
		
		if (!document.isIndexInElementsRange(elementPosition)) {
			throw new IndexOutOfBoundsException("ELEMENTO INEXISTENTE");
		}
		
		document.moveElementUp(elementPosition);
	}
	
	public void moveElementDown(String docTitle, int elementPosition) {
		Document document = this.documentController.getDocument(docTitle);
		
		if (!document.isIndexInElementsRange(elementPosition)) {
			throw new IndexOutOfBoundsException("ELEMENTO INEXISTENTE");
		}
		
		document.moveElementDown(elementPosition);
	}
	
	public int getElementsNumber(String title) {
		Document document = this.documentController.getDocument(title);
		
		return document.countElements();
	}
}
