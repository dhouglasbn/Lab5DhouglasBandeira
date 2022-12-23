package documin.document;

/** Representação do controlador dos elementos.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class ElementController {

	/**
	 * controlador de documentos
	 */
	private DocumentController documentController;
	
	/** Cria um controlador de elementos a partir de um
	 * controlador de documentos.
	 * 
	 * @param documentController
	 */
	public ElementController(DocumentController documentController) {
		this.documentController = documentController;
	}
	
	/** Cria um texto.
	 * 
	 * @param docTitle
	 * @param value
	 * @param priority
	 * @return elemento index
	 */
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
	
	/** Cria um título.
	 * 
	 * @param docTitle
	 * @param value
	 * @param priority
	 * @param level
	 * @param linkable
	 * @return element index
	 */
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
	
	/** Cria uma lista.
	 * 
	 * @param docTitle
	 * @param listValue
	 * @param priority
	 * @param spacer
	 * @param charList
	 * @return element index
	 */
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
	
	/** Cria termos.
	 * 
	 * @param docTitle
	 * @param wordsValue
	 * @param priority
	 * @param spacer
	 * @param rank
	 * @return element index
	 */
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
	
	/** Cria um atalho.
	 * 
	 * @param docTitle
	 * @param shortcutTitle
	 * @return element index
	 */
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
	
	/** Pega a representação completa de um elemento.
	 * 
	 * @param docTitle
	 * @param elementPosition
	 * @return element fullRepresentation
	 */
	public String getFullRepresentation(String docTitle, int elementPosition) {
		Document document = this.documentController.getDocument(docTitle);
		
		if (!document.isIndexInElementsRange(elementPosition)) {
			throw new IndexOutOfBoundsException("ELEMENTO INEXISTENTE");
		}
		
		return document.getElement(elementPosition).generateFullRepresentation();
	}
	
	/** Pega a representação resumida de um elemento.
	 * 
	 * @param docTitle
	 * @param elementPosition
	 * @return element shortRepresentation
	 */
	public String getShortRepresentation(String docTitle, int elementPosition) {
		Document document = this.documentController.getDocument(docTitle);
		
		if (!document.isIndexInElementsRange(elementPosition)) {
			throw new IndexOutOfBoundsException("ELEMENTO INEXISTENTE");
		}
		
		return document.getElement(elementPosition).generateShortRepresentation();
	}
	
	/** Remove um elemento da lista.
	 * 
	 * @param docTitle
	 * @param elementPosition
	 * @return operation result
	 */
	public boolean removeElement(String docTitle, int elementPosition) {
		Document document = this.documentController.getDocument(docTitle);
		
		if (!document.isIndexInElementsRange(elementPosition)) {
			throw new IndexOutOfBoundsException("ELEMENTO INEXISTENTE");
		}
		
		return document.removeElement(elementPosition);
	}
	
	/** Move um elemento para cima em um documento.
	 * 
	 * @param docTitle
	 * @param elementPosition
	 */
	public void moveElementUp(String docTitle, int elementPosition) {
		Document document = this.documentController.getDocument(docTitle);
		
		if (!document.isIndexInElementsRange(elementPosition)) {
			throw new IndexOutOfBoundsException("ELEMENTO INEXISTENTE");
		}
		
		document.moveElementUp(elementPosition);
	}
	
	/** Move um elemento para baixo em um documento.
	 * 
	 * @param docTitle
	 * @param elementPosition
	 */
	public void moveElementDown(String docTitle, int elementPosition) {
		Document document = this.documentController.getDocument(docTitle);
		
		if (!document.isIndexInElementsRange(elementPosition)) {
			throw new IndexOutOfBoundsException("ELEMENTO INEXISTENTE");
		}
		
		document.moveElementDown(elementPosition);
	}
	
	/** Pega o número de elementos de um documento.
	 * 
	 * @param title
	 * @return elements number
	 */
	public int getElementsNumber(String title) {
		Document document = this.documentController.getDocument(title);
		
		return document.countElements();
	}
	
	/** Verifica se o número da prioridade está no intervalo(1-5).
	 * 
	 * @param priority
	 * @return priority is in range
	 */
	private boolean isPriorityInRange(int priority) {
		if (priority < 1 || priority > 5) {
			return false;
		}
		return true;
	}
	
	/** Verifica se o nível do título está no interval(1-5).
	 * 
	 * @param level
	 * @return level is in range
	 */
	private boolean isLevelInRange(int level) {
		if (level < 1 || level > 5) {
			return false;
		}
		return true;
	}
	
	/** Verifica se um documento possui atalhos.
	 * 
	 * @param docTitle
	 * @return document has shortcuts
	 */
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
}
