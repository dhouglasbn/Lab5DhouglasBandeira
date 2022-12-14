package documin.document;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentTest {
	
	private Document document;

	@BeforeEach
	void setUp() throws Exception {
		this.document = new Document("Documento de teste");
	}
	
	@Test
	void createElementTest() {
		String msg1 = "Espera-se que um elemento seja criado na posição 0";
		String msg2 = "Espera-se que um elemento seja criado na posição 1";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		int position1 = this.document.createElement(title);
		int position2 = this.document.createElement(text);
		
		assertEquals(0, position1, msg1);
		assertEquals(1, position2, msg2);
	}
	
	@Test
	void setIsShortcutTrue() {
		String msg = "Espera-se que o documento seja um atalho (true).";
		
		this.document.setShortcut(true);
		
		assertTrue(this.document.isShortcut(), msg);
	}
	
	@Test
	void setIsShortcutFalse() {
String msg = "Espera-se que o documento não seja um atalho (false).";
		
		this.document.setShortcut(false);
		
		assertFalse(this.document.isShortcut(), msg);
	}

	@Test
	void moveSecondElementUpTest() {
		String msg1 = "Espera-se que o elemento na posição 0 seja o texto";
		String msg2 = "Espera-se que o elemento na posição 1 seja o título";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.document.createElement(title);
		this.document.createElement(text);
		
		this.document.moveElementUp(1);
		
		Element element1 = this.document.getElement(0);
		Element element2 = this.document.getElement(1);
		
		assertEquals(text, element1, msg1);
		assertEquals(title, element2, msg2);
	}
	
	@Test
	void moveFirstElementUpTest() {
		String msg1 = "Espera-se que ao mover o elemento da posição 0, "
				+ "para cima ele continue na posição 0.";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.document.createElement(title);
		this.document.createElement(text);
		
		this.document.moveElementUp(0);
		
		Element element1 = this.document.getElement(0);
		
		assertEquals(title, element1, msg1);
	}
	
	@Test
	void moveFirstElementDownTest() {
		String msg1 = "Espera-se que o elemento na posição 0 seja o texto";
		String msg2 = "Espera-se que o elemento na posição 1 seja o título";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.document.createElement(title);
		this.document.createElement(text);
		
		this.document.moveElementDown(0);
		
		Element element1 = this.document.getElement(0);
		Element element2 = this.document.getElement(1);
		
		assertEquals(text, element1, msg1);
		assertEquals(title, element2, msg2);
	}
	
	@Test
	void moveSecondElementDownTest() {
		String msg = "Espera-se que o elemento na posição 1 continue sendo o texto.";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.document.createElement(title);
		this.document.createElement(text);
		
		this.document.moveElementDown(1);
		
		this.document.getElement(0);
		Element element2 = this.document.getElement(1);

		assertEquals(text, element2, msg);
	}
	
	@Test
	void removeElementTest() {
		String msg1 = "Espera-se que o elemento seja removido com sucesso.";
		String msg2 = "Espera-se que o elemento na posição 1 seja o título.";
		String msg3 = "Espera-se que o elemento na posição 2 seja os termos.";
		String msg4 = "Espera-se que após a remoção o documento possua 2 elementos.";
		int expectedValue = 2;
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		Words words = new Words("palavras / de / teste", 1, " / ", "NENHUM");
		
		this.document.createElement(title);
		this.document.createElement(text);
		this.document.createElement(words);
		
		boolean result = this.document.removeElement(1);
		
		Element element1 = this.document.getElement(0);
		Element element2 = this.document.getElement(1);
		int elementsAmount = this.document.countElements();

		assertTrue(result, msg1);
		assertEquals(title, element1, msg2);
		assertEquals(words, element2, msg3);
		assertEquals(expectedValue, elementsAmount, msg4);
	}
	
//	@Test
//	void showDocumentTest() {
//		
//	}
	
	@Test
	void isIndexInElementsRangeTest() {
		String msg = "Espera-se que 0 esteja no intervalo de indices dos elementos.";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.document.createElement(title);
		this.document.createElement(text);
		
		boolean result = this.document.isIndexInElementsRange(0);
		
		assertTrue(result, msg);
	}
	
	@Test
	void isIndexUnderElementsRangeTest() {
		String msg = "Espera-se que posições abaixo de 0 não estejam mais no "
				+ "intervalo de indices dos elementos";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.document.createElement(title);
		this.document.createElement(text);
		
		boolean result = this.document.isIndexInElementsRange(-1);
		
		assertFalse(result, msg);
	}
	
	@Test
	void isIndexOverElementsRangeTest() {
		String msg = "Espera-se que posições a partir do número de elementos"
				+ " não estejam mais no intervalo de indices dos elementos";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.document.createElement(title);
		this.document.createElement(text);
		
		int elementsNumber = this.document.countElements();
		
		boolean result = this.document.isIndexInElementsRange(elementsNumber);
		
		assertFalse(result, msg);
	}
	
	@Test
	void isLastIndexInElementsRangeTest() {
		String msg = "Espera-se que a posição antes do número de elementos esteja "
				+ "no intervalo de indices";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.document.createElement(title);
		this.document.createElement(text);
		
		int elementsNumber = this.document.countElements();
		
		boolean result = this.document.isIndexInElementsRange(elementsNumber - 1);
		
		assertTrue(result, msg);
	}
}
