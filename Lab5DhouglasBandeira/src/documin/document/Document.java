package documin.document;

import java.util.ArrayList;

public class Document implements DocumentInterface {

	private String title;
	
	private int elementsSize;
	
	private ArrayList<Element> elements = new ArrayList<>();
	
	private boolean isShortcut;
	
	public Document(String title) {
		this.title = title;
		this.elementsSize = -1;
		this.elements = new ArrayList<Element>();
		this.isShortcut = false;
	}
	
	public Document(String title, int elementsSize) {
		this.title = title;
		this.elementsSize = elementsSize;
		this.elements = new ArrayList<Element>();
		this.isShortcut = false;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public boolean isShortcut() {
		return this.isShortcut;
	}
	
	public void setIsShortcut(boolean value) {
		this.isShortcut = value;
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
	
	public boolean isFull() {
		return this.countElements() == this.elementsSize;
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
	
	public boolean isIndexInElementsRange(int index) {
		if (index < 0 || index >= this.countElements()) {
			return false;
		}
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
}
