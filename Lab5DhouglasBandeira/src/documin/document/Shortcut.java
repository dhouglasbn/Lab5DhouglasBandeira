package documin.document;

import java.util.ArrayList;


/** Representação de um atalhos.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class Shortcut extends Element implements DocumentInterface {

	/**
	 * Limite de elementos do atalho
	 */
	private int elementsSize;
	
	/**
	 * Lista de elementos
	 */
	private ArrayList<Element> elements = new ArrayList<>();
	
	/** Constrói um atalho.
	 * 
	 * @param value
	 * @param elementsSize
	 */
	public Shortcut(String value, int elementsSize) {
		super(value, 0);
		this.priority = this.getPriorityAverage();
		this.elementsSize = elementsSize;
		this.elements = new ArrayList<Element>();
	}
	
	/** Pega o título do atalho.
	 * 
	 * @return title
	 */
	public String getTitle() {
		return this.value;
	}
	
	/** Pega o limite de elementos.
	 * 
	 * @return elementsSize
	 */
	public int getTotalElementsSize() {
		return this.elementsSize;
	}
	
	/** Verifica se a lista de elementos está cheia.
	 * 
	 * @return elementsList is full
	 */
	public boolean isFull() {
		return this.countElements() == this.elementsSize;
	}
	
	/** Pega um elemento na lista.
	 * 
	 * @param position
	 * @return element
	 */
	public Element getElement(int position) {
		return this.elements.get(position);
	}
	
	/** Cria um elemento na lista.
	 * 
	 * @param element
	 * @return element position
	 */
	public int createElement(Element element) {
		this.elements.add(element);
		this.setPriority();
		return this.elements.indexOf(element);
	}
	
	/** Conta quantos elementos estão cadastrados.
	 * 
	 * @return elements size
	 */
	public int countElements() {
		return this.elements.size();
	}
	
	/** Move um elemento para cima,
	 * se for a primeira posição não faz nada.
	 * 
	 * @param position
	 */
	public void moveElementUp(int position) {
		if (position == 0) return;
		
		Element supElement = this.elements.get(position - 1);
		Element curElement = this.elements.get(position);
		
		this.elements.add(position - 1, curElement);
		this.elements.add(position, supElement);
	}
	
	/** Move um elemento da lista para baixo, 
	 * se for o último elemento não faz nada.
	 * 
	 * @param position
	 */
	public void moveElementDown(int position) {
		if (position == this.countElements() - 1) return;
		
		Element infElement = this.elements.get(position + 1);
		Element curElement = this.elements.get(position);
		
		this.elements.add(position + 1, curElement);
		this.elements.add(position, infElement);
	}
	
	/** Remove um elemento da lista.
	 * 
	 * @param position
	 * @return operation result
	 */
	public boolean removeElement(int position) {
		this.elements.remove(position);
		this.setPriority();
		return true;
	}
	
	/** Exibe os elementos do atalho.
	 * 
	 * @return elements shortRepresentation
	 */
	public String[] showDocument() {
		String[] representations = new String[this.countElements()];
		
		for (int index = 0; index < this.countElements(); index++) {
			representations[index] = this
					.elements
					.get(index)
					.generateShortRepresentation();
		}
		return representations;
	}
	
	/** Verifica se um index está no intervalo de elementos cadastrados.
	 * 
	 * @param index
	 * @return index is in range
	 */
	public boolean isIndexInElementsRange(int index) {
		if (index < 0 || index >= this.countElements()) {
			return false;
		}
		return true;
	}
	
	@Override
	public String generateFullRepresentation() {
		String result = "";
		Element element;
		
		for (int index = 0; index < this.countElements(); index++) {
			element = this.elements.get(index);
			if (element.getPriority() == 4 || element.getPriority() == 5) {				
				result += element.generateFullRepresentation();
			}
		}
		return result;
	}
	
	@Override
	public String generateShortRepresentation() {
		String result = "";
		Element element;
		
		for (int index = 0; index < this.countElements(); index++) {
			element = this.elements.get(index);
			if (element.getPriority() == 4 || element.getPriority() == 5) {				
				result += element.generateShortRepresentation();
			}
		}
		return result;
	}
	
	/** Atualiza a prioridade do atalho(média das prioridades
	 * dos elementos).
	 */
	private void setPriority() {
		this.priority = this.getPriorityAverage();
	}
	
	/** Pega a média das prioridades dos elementos do atalho.
	 * 
	 * @return elements priorities average
	 */
	private int getPriorityAverage() {
		int amount = 0;
		int elements = this.countElements();
		
		if (elements == 0) {
			return 0;
		}
		for (int index = 0; index < this.countElements(); index++) {
			amount += this.getElement(index).getPriority();
		}
		
		return amount / this.countElements();
	}
}
