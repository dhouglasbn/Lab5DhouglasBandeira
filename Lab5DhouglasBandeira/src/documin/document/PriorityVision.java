package documin.document;

/** Representação de uma visão de prioridade.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class PriorityVision extends Vision {
	
	/**
	 * Prioridade da visão
	 */
	private int priority;

	/** Constrói uma visão de prioridade.
	 * 
	 * @param document
	 * @param priority
	 */
	public PriorityVision(Document document, int priority) {
		super(document);
		this.priority = priority;
	}
	
	/** Pega prioridade da visão.
	 * 
	 * @return priority
	 */
	public int getPriority() {
		return this.priority;
	}
	
	@Override
	public String[] generateRepresentation() {
		String[] result = new String[this.countPriorityElements()];
		int counter = 0;
		
		for (int index = 0; index < this.document.countElements(); index++) {
			Element element = this.document.getElement(index);
			if (element.getPriority() >= this.priority) {
				result[counter] = element.generateFullRepresentation();
				counter++;
			}
		}
		return result;
	}
	
	/** Conta quantos elementos do documento possuem prioridade
	 * igual ou acima da prioridade da visão.
	 * @return
	 */
	private int countPriorityElements() {
		int result = 0;
		
		for (int index = 0; index < this.document.countElements(); index++) {
			Element element = this.document.getElement(index);
			if (element.getPriority() >= this.priority) {
				result++;
			}
		}
		return result;
	}
}