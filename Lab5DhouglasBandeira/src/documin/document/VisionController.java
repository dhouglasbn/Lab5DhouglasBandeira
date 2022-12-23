package documin.document;

import java.util.ArrayList;

/** Representação do controlador das visões.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class VisionController {

	/**
	 * controlador de documentos
	 */
	private DocumentController documentController;
	
	/**
	 * Lista de visões
	 */
	private ArrayList<Vision> visionList;
	
	/** Constrói um controlador de visões.
	 * 
	 * @param documentController
	 */
	public VisionController(DocumentController documentController) {
		this.documentController = documentController;
		this.visionList = new ArrayList<Vision>();
	}
	
	/** Cria uma visão completa.
	 * 
	 * @param docTitle
	 * @return vision index
	 */
	public int createFullVision(String docTitle) {
		Document document = this.documentController.getDocument(docTitle);
		FullVision fullVision = new FullVision(document);
		
		this.visionList.add(fullVision);
		return this.visionList.size() - 1;
	}
	
	/** Cria uma visão resumida.
	 * 
	 * @param docTitle
	 * @return vision index
	 */
	public int createShortVision(String docTitle) {
		Document document = this.documentController.getDocument(docTitle);
		ShortVision shortVision = new ShortVision(document);
		
		this.visionList.add(shortVision);
		return this.visionList.size() - 1;
	}
	
	/** Cria uma visão de prioridade.
	 * 
	 * @param docTitle
	 * @param priority
	 * @return vision index
	 */
	public int createPriorityVision(String docTitle, int priority) {
		Document document = this.documentController.getDocument(docTitle);
		
		if (!this.isPriorityInRange(priority)) {
			throw new IllegalArgumentException("PRIORIDADE(1-5)!");
		}
		
		PriorityVision priorityVision = new PriorityVision(document, priority);
		
		this.visionList.add(priorityVision);
		return this.visionList.size() - 1;
	}
	
	/** Cria uma visão de títulos.
	 * 
	 * @param docTitle
	 * @return vision index
	 */
	public int createTitleVision(String docTitle) {
		Document document = this.documentController.getDocument(docTitle);
		TitleVision titleVision = new TitleVision(document);
		
		this.visionList.add(titleVision);
		return this.visionList.size() - 1;
	}
	
	/** exibe as representações dos elementos do documento da visão.
	 * 
	 * @param visionId
	 * @return elements representations
	 */
	public String[] showVision(int visionId) {
		if (!this.isIdInRange(visionId)) {
			throw new IllegalArgumentException("VISÃO INEXISTENTE!");
		}
		
		return this.visionList.get(visionId).generateRepresentation();
	}
	
	/** Verifica se um número de prioridade está no intervalo(1-5).
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
	
	/** Verifica se um id está no intervalo de visões cadastradas.
	 * 
	 * @param visionId
	 * @return vision is in range
	 */
	private boolean isIdInRange(int visionId) {
		if (visionId < 0 || visionId >= this.visionList.size()) {
			return false;
		}
		return true;
	}
}
