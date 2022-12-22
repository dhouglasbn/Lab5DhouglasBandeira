package documin.document;

import java.util.ArrayList;

public class VisionController {

	private DocumentController documentController;
	
	private ArrayList<Vision> visionList;
	
	public VisionController(DocumentController documentController) {
		this.documentController = documentController;
		this.visionList = new ArrayList<Vision>();
	}
	
	public int createFullVision(String docTitle) {
		Document document = this.documentController.getDocument(docTitle);
		FullVision fullVision = new FullVision(document);
		
		this.visionList.add(fullVision);
		return this.visionList.size() - 1;
	}
	
	public int createShortVision(String docTitle) {
		Document document = this.documentController.getDocument(docTitle);
		ShortVision shortVision = new ShortVision(document);
		
		this.visionList.add(shortVision);
		return this.visionList.size() - 1;
	}
	
	public int createPriorityVision(String docTitle, int priority) {
		Document document = this.documentController.getDocument(docTitle);
		
		if (!this.isPriorityInRange(priority)) {
			throw new IllegalArgumentException("PRIORIDADE(1-5)!");
		}
		
		PriorityVision priorityVision = new PriorityVision(document, priority);
		
		this.visionList.add(priorityVision);
		return this.visionList.size() - 1;
	}
	
	public int createTitleVision(String docTitle) {
		Document document = this.documentController.getDocument(docTitle);
		TitleVision titleVision = new TitleVision(document);
		
		this.visionList.add(titleVision);
		return this.visionList.size() - 1;
	}
	
	public String[] showVision(int visionId) {
		if (!this.isIdInRange(visionId)) {
			throw new IllegalArgumentException("VISÃO INEXISTENTE!");
		}
		
		return this.visionList.get(visionId).generateRepresentation();
	}
	
	private boolean isPriorityInRange(int priority) {
		if (priority < 1 || priority > 5) {
			return false;
		}
		return true;
	}
	
	private boolean isIdInRange(int visionId) {
		if (visionId < 0 || visionId >= this.visionList.size()) {
			return false;
		}
		return true;
	}
}
