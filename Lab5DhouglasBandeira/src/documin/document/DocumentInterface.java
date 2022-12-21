package documin.document;

public interface DocumentInterface {
	public String getTitle();
	
	public int getTotalElementsSize();
	
	public Element getElement(int position);
	
	public int createElement(Element element);
	
	public int countElements();
	
	public void moveElementUp(int position);
	
	public void moveElementDown(int position);
	
	public boolean removeElement(int position);
	
	public String[] showDocument();
	
	public boolean isIndexInElementsRange(int index);
	
	public boolean isFull();
}
