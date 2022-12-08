package documin.document;

import java.util.ArrayList;

public class Document {

	private String title;
	
	private int elementsSize;
	
	// Por enquanto é a impressão que eu tenho de elements
	private ArrayList<Element> elements = new ArrayList<>();
	
	public Document(String title) {
		this.title = title;
		this.elementsSize = -1;
		this.elements = new ArrayList<>();
	}
	
	public Document(String title, int elementsSize) {
		this.title = title;
		this.elementsSize = elementsSize;
		this.elements = new ArrayList<>();
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getTotalElementsSize() {
		return this.elementsSize;
	}
	
	public Element getElement(int position) {
		return this.elements.get(position);
	}
	
	public int createElement(Element element) {
		this.elements.add(element);
		return this.elements.indexOf(element);
	}
	
	public int countElements() {
		return this.elements.size();
	}
	
	public void moveElementUp(int position) {
		if (position == 0) return;
		
		Element supElement = this.elements.get(position - 1);
		Element curElement = this.elements.get(position);
		
		this.elements.add(position - 1, curElement);
		this.elements.add(position, supElement);
	}
	
	public void moveElementDown(int position) {
		if (position == this.countElements() - 1) return;
		
		Element infElement = this.elements.get(position + 1);
		Element curElement = this.elements.get(position);
		
		this.elements.add(position + 1, curElement);
		this.elements.add(position, infElement);
	}
	
	public boolean removeElement(int position) {
		this.elements.remove(position);
		return true;
	}
	
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
	
	public boolean isIndexInElementsRange(int index) {
		if (index < 0 || index >= this.countElements()) {
			return false;
		}
		return true;
	}
}
