package documin.document;

import java.util.HashMap;
import java.util.NoSuchElementException;

/** Representação de um controlador dos documentos.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class DocumentController {

	/**
	 * Mapa dos documentos, onde os títulos são as chaves.
	 */
	private HashMap<String, Document> documentsMap;
	
	/** Constrói um controlador de documentos.
	 * 
	 */
	public DocumentController() {
		this.documentsMap = new HashMap<String, Document>();
	}
	
	/** Cria um documento a partir de um título.
	 * 
	 * @param title
	 * @return operation result
	 */
	public boolean createDocument(String title) {
		if (title.isBlank()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		if (this.documentAlreadyExists(title)) return false;
		
		Document document = new Document(title);
		this.documentsMap.put(title, document);
		return true;	
	}
	
	/** Cria um documento a partir de um título e um limite de documentos.
	 * 
	 * @param title
	 * @param elementsSize
	 * @return operation result
	 */
	public boolean createDocument(String title, int elementsSize) {
		if (title.isBlank()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		if (this.documentAlreadyExists(title)) return false;
		
		Document document = new Document(title, elementsSize);
		this.documentsMap.put(title, document);
		return true;	
	}
	
	/** Deleta um documento a partir de seu título
	 * 
	 * @param void
	 */
	public void deleteDocument(String title) {
		this.getDocument(title);
		
		this.documentsMap.remove(title);
	}
	
	/** pega um documento.
	 * 
	 * @param title
	 * @return document
	 */
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
	
	/** Exibe um documento a partir de seu título.
	 * 
	 * @param title
	 * @return document elements representations
	 */
	public String[] showDocument(String title) {
		Document document = this.getDocument(title);
		
		return document.showDocument();
	}
	
	/** Verifica se o documento está cheio.
	 * 
	 * @param title
	 * @return document is full
	 */
	public boolean isDocumentFull(String title) {
		return this.getDocument(title).isFull();
	}
	
	/** Verifica se o documento está cadastrado.
	 * 
	 * @param title
	 * @return document exists
	 */
	private boolean documentAlreadyExists(String title) {
		return this.documentsMap.containsKey(title);
	}
}
