package documin.document;

import java.util.ArrayList;

/** Representação de um documento
 * que se comporta como um documento.
 * 
 * @author Dhoug
 *
 */
public class Document implements DocumentInterface {

	/**
	 * Título do documento
	 */
	private String title;
	
	/** 
	 * Limite de elementos
	 */
	private int elementsSize;
	
	/**
	 * Lista de elementos
	 */
	private ArrayList<Element> elements = new ArrayList<>();
	
	/**
	 * Status de documento é atalho
	 */
	private boolean isShortcut;
	
	/** Constrói um documento a partir de um título.
	 * 
	 * @param title
	 */
	public Document(String title) {
		this.title = title;
		this.elementsSize = -1;
		this.elements = new ArrayList<Element>();
		this.isShortcut = false;
	}
	
	/** Constrói um documento a partir de um título e
	 * um limite de elementos a serem registrados.
	 * 
	 * @param title
	 * @param elementsSize
	 */
	public Document(String title, int elementsSize) {
		this.title = title;
		this.elementsSize = elementsSize;
		this.elements = new ArrayList<Element>();
		this.isShortcut = false;
	}
	
	/** Pega o título do documento.
	 * 
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/** Verifica se o documento é atalho.
	 * 
	 * @return isShortcut
	 */
	public boolean isShortcut() {
		return this.isShortcut;
	}
	
	/** Altera status de atalho.
	 * 
	 * @param value
	 */
	public void setIsShortcut(boolean value) {
		this.isShortcut = value;
	}
	
	/** Pega o limite de elementos.
	 * 
	 * @return total elements size
	 */
	public int getTotalElementsSize() {
		return this.elementsSize;
	}
	
	/** Pega um elemento por posição
	 * 
	 * @param position
	 * @return element
	 */
	public Element getElement(int position) {
		return this.elements.get(position);
	}
	
	/** Cria um elemento na lista
	 *
	 * @param element
	 * @return element index
	 */
	public int createElement(Element element) {
		this.elements.add(element);
		return this.elements.indexOf(element);
	}
	
	/** Verifica se a lista de elementos está cheia
	 * 
	 * @return elementsList isFull status
	 */
	public boolean isFull() {
		return this.countElements() == this.elementsSize;
	}
	
	/** Conta quantos elementos têm na lista.
	 * 
	 * @return elements size
	 */
	public int countElements() {
		return this.elements.size();
	}
	
	/** move um elemento para cima.
	 * não faz nada se for o primeiro elemento.
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
	
	/** Move um elemento para baixo.
	 * Não faz nada se for o último elemento
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
	
	/** Remove um elemento pela posição.
	 * 
	 * @param position
	 */
	public boolean removeElement(int position) {
		this.elements.remove(position);
		return true;
	}
	
	/** Verifica se um index está no intervalo dos elementos.
	 * 
	 * @param index
	 * @return isIndexInRange
	 */
	public boolean isIndexInElementsRange(int index) {
		if (index < 0 || index >= this.countElements()) {
			return false;
		}
		return true;
	}
	
	/** Retorna um array das representações resumidas dos elementos.
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
}
