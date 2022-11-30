package documin.document;

import java.util.ArrayList;

public class Document {

	private String title;
	
	private int elementsSize;
	
	// Por enquanto é a impressão que eu tenho de elements
	private ArrayList<String> elements = new ArrayList<>();
	
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
}
