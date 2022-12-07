package documin.document;

import java.util.ArrayList;

public class Document {

	private String title;
	
	private int elementsSize;
	
	// Por enquanto é a impressão que eu tenho de elements
	private ArrayList<Element> elements = new ArrayList<>();
	
	public Document(String title) {
		if (title.trim().isEmpty()) {
			throw new IllegalArgumentException("NÃO PODE SER VAZIO");
		}
		
		this.title = title;
		this.elementsSize = -1;
		this.elements = new ArrayList<>();
	}
	
	public Document(String title, int elementsSize) {
		if (title.trim().isEmpty()) {
			throw new IllegalArgumentException("NÃO PODE SER VAZIO");
		}
		
		this.title = title;
		this.elementsSize = elementsSize;
		this.elements = new ArrayList<>();
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getCurrentElementsSize() {
		return this.elements.size();
	}
	
	public int getTotalElementsSize() {
		return this.elementsSize;
	}
	
	public int createElement(Element element) {
		this.elements.add(element);
		return this.elements.size() - 1;
	}
	
	public int countElements() {
		return this.elements.size();
	}
	
	public void moveElementUp(int elementPosition) {
		
	}
	
	public void moveElementDown(int elementPosition) {
		
	}
	
	public boolean removeElement(int elementPosition) {
		this.elements.remove(elementPosition);
		return true;
	}
}
