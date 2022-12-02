package documin.document;

import java.util.ArrayList;

public class Document {

	private String title;
	
	private int elementsSize;
	
	// Por enquanto é a impressão que eu tenho de elements
	private ArrayList<Element> elements = new ArrayList<>();
	
	public Document(String title, int elementsSize) {
		this.title = title;
		this.elementsSize = elementsSize;
		this.elements = new ArrayList<>();
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
	
	public void moveElementUp(int elementPosition) {
		
	}
	
	public void moveElementDown(int elementPosition) {
		
	}
	
	public boolean removeElement(int elementPosition) {
		this.elements.remove(elementPosition);
		return true;
	}
}
