package documin.document;

import java.util.ArrayList;

// para testar
public class Shortcut extends Element implements DocumentInterface {

	private int elementsSize;
	
	private ArrayList<Element> elements = new ArrayList<>();
	
	public Shortcut(String value) {
		super(value, 0);
		this.priority = this.getPriorityAverage();
		this.elementsSize = -1;
		this.elements = new ArrayList<Element>();
	}
	
	public Shortcut(String value, int elementsSize) {
		super(value, 0);
		this.priority = this.getPriorityAverage();
		this.elementsSize = elementsSize;
		this.elements = new ArrayList<Element>();
	}
	
	public String getTitle() {
		return this.value;
	}
	
	public int getTotalElementsSize() {
		return this.elementsSize;
	}
	
	public boolean isFull() {
		return this.countElements() == this.elementsSize;
	}
	
	public Element getElement(int position) {
		return this.elements.get(position);
	}
	
	public int createElement(Element element) {
		this.elements.add(element);
		this.setPriority();
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
		this.setPriority();
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
	
	public String generateFullRepresentation() {
		String result = "";
		
		for (Element element: this.elements) {
			if (element.getPriority() == 4 || element.getPriority() == 5) {				
				result += element.generateFullRepresentation();
			}
		}
		return result;
	}
	
	public String generateShortRepresentation() {
		String result = "";
		
		for (Element element: this.elements) {
			if (element.getPriority() == 4 || element.getPriority() == 5) {				
				result += element.generateShortRepresentation();
			}
		}
		return result;
	}
	
	private void setPriority() {
		this.priority = this.getPriorityAverage();
	}
	
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
