package documin.document;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShortcutTest {

	private Shortcut shortcut;
	
	@BeforeEach
	void setUp() throws Exception {
		this.shortcut = new Shortcut("atalho de exemplo", -1);
	}

	@Test
	void createElementTest() {
		String msg1 = "Espera-se que um elemento seja criado na posição 0";
		String msg2 = "Espera-se que um elemento seja criado na posição 1";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		int position1 = this.shortcut.createElement(title);
		int position2 = this.shortcut.createElement(text);
		
		assertEquals(0, position1, msg1);
		assertEquals(1, position2, msg2);
	}

	@Test
	void moveSecondElementUpTest() {
		String msg1 = "Espera-se que o elemento na posição 0 seja o texto";
		String msg2 = "Espera-se que o elemento na posição 1 seja o título";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.shortcut.createElement(title);
		this.shortcut.createElement(text);
		
		this.shortcut.moveElementUp(1);
		
		Element element1 = this.shortcut.getElement(0);
		Element element2 = this.shortcut.getElement(1);
		
		assertEquals(text, element1, msg1);
		assertEquals(title, element2, msg2);
	}
	
	@Test
	void moveFirstElementUpTest() {
		String msg1 = "Espera-se que ao mover o elemento da posição 0, "
				+ "para cima ele continue na posição 0.";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.shortcut.createElement(title);
		this.shortcut.createElement(text);
		
		this.shortcut.moveElementUp(0);
		
		Element element1 = this.shortcut.getElement(0);
		
		assertEquals(title, element1, msg1);
	}
	
	@Test
	void moveFirstElementDownTest() {
		String msg1 = "Espera-se que o elemento na posição 0 seja o texto";
		String msg2 = "Espera-se que o elemento na posição 1 seja o título";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.shortcut.createElement(title);
		this.shortcut.createElement(text);
		
		this.shortcut.moveElementDown(0);
		
		Element element1 = this.shortcut.getElement(0);
		Element element2 = this.shortcut.getElement(1);
		
		assertEquals(text, element1, msg1);
		assertEquals(title, element2, msg2);
	}
	
	@Test
	void moveSecondElementDownTest() {
		String msg = "Espera-se que o elemento na posição 1 continue sendo o texto.";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.shortcut.createElement(title);
		this.shortcut.createElement(text);
		
		this.shortcut.moveElementDown(1);
		
		this.shortcut.getElement(0);
		Element element2 = this.shortcut.getElement(1);

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
		
		this.shortcut.createElement(title);
		this.shortcut.createElement(text);
		this.shortcut.createElement(words);
		
		boolean result = this.shortcut.removeElement(1);
		
		Element element1 = this.shortcut.getElement(0);
		Element element2 = this.shortcut.getElement(1);
		int elementsAmount = this.shortcut.countElements();

		assertTrue(result, msg1);
		assertEquals(title, element1, msg2);
		assertEquals(words, element2, msg3);
		assertEquals(expectedValue, elementsAmount, msg4);
	}
	
	@Test
	void showDocumentTest() {
		String msg = "Espera-se que seja retornada as representações"
				+ " curtas dos elementos do atalho.";
		String expectedFirstValue = "lista, de, exemplo\n";
		String expectedSecondValue = "termos / de / exemplo\n";
		
		ListElement list = new ListElement("lista | de | exemplo", 1, " | ", "-");
		Words words = new Words("termos / de / exemplo", 1, " / ", "NENHUM");
		this.shortcut.createElement(list);
		this.shortcut.createElement(words);
		
		String[] result = this.shortcut.showDocument();
		
		assertEquals(expectedFirstValue, result[0], msg);
		assertEquals(expectedSecondValue, result[1], msg);
	}
	
	@Test
	void isIndexInElementsRangeTest() {
		String msg = "Espera-se que 0 esteja no intervalo de indices dos elementos.";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.shortcut.createElement(title);
		this.shortcut.createElement(text);
		
		boolean result = this.shortcut.isIndexInElementsRange(0);
		
		assertTrue(result, msg);
	}
	
	@Test
	void isIndexUnderElementsRangeTest() {
		String msg = "Espera-se que posições abaixo de 0 não estejam mais no "
				+ "intervalo de indices dos elementos";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.shortcut.createElement(title);
		this.shortcut.createElement(text);
		
		boolean result = this.shortcut.isIndexInElementsRange(-1);
		
		assertFalse(result, msg);
	}
	
	@Test
	void isIndexOverElementsRangeTest() {
		String msg = "Espera-se que posições a partir do número de elementos"
				+ " não estejam mais no intervalo de indices dos elementos";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.shortcut.createElement(title);
		this.shortcut.createElement(text);
		
		int elementsNumber = this.shortcut.countElements();
		
		boolean result = this.shortcut.isIndexInElementsRange(elementsNumber);
		
		assertFalse(result, msg);
	}
	
	@Test
	void isLastIndexInElementsRangeTest() {
		String msg = "Espera-se que a posição antes do número de elementos esteja "
				+ "no intervalo de indices";
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		this.shortcut.createElement(title);
		this.shortcut.createElement(text);
		
		int elementsNumber = this.shortcut.countElements();
		
		boolean result = this.shortcut.isIndexInElementsRange(elementsNumber - 1);
		
		assertTrue(result, msg);
	}
	
	@Test
	void isDocumentFull() {
		String msg = "Espera-se que com a mesma quantidade de elementos registrados "
				+ "que a quantidade total de elementos, o atalho esteja cheio";
		
		Shortcut newShortcut = new Shortcut("teste", 3);
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		Words words = new Words("termos / de / exemplo", 1, " / ", "NENHUM");
		
		newShortcut.createElement(title);
		newShortcut.createElement(text);
		newShortcut.createElement(words);
		
		boolean result = newShortcut.isFull();
		
		assertTrue(result, msg);
	}
	
	@Test
	void isntDocumentFull() {
		String msg = "Espera-se que com a quantidade de elementos registrados "
				+ "menor que a quantidade total de elementos, o documento esteja cheio";
		
		Shortcut newShortcut = new Shortcut("teste", 3);
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		newShortcut.createElement(title);
		newShortcut.createElement(text);
		
		boolean result = newShortcut.isFull();
		
		assertFalse(result, msg);
	}

	@Test
	void generateFullRepresentation() {
		String msg = "Espera-se que seja retornado a representação "
				+ "dos elementos acima de prioridade 4 do atalho.";
		String expectedValue = "3. teste\n"
				+ "Total termos: 3\n"
				+ "- termos, de, exemplo\n";
		
		Title title = new Title("teste", 4, 3, false);
		Text text = new Text("testeeee", 1);
		Words words = new Words("termos / de / exemplo", 5, " / ", "NENHUM");
		
		this.shortcut.createElement(title);
		this.shortcut.createElement(text);
		this.shortcut.createElement(words);
		
		String result = this.shortcut.generateFullRepresentation();
		
		assertEquals(expectedValue, result, msg);
	}
	
	@Test
	void generateShortRepresentation() {
		String msg = "Espera-se que seja retornado a representação "
				+ "dos elementos acima de prioridade 4 do atalho.";
		String expectedValue = "3. teste\n"
				+ "termos / de / exemplo\n";
		
		Title title = new Title("teste", 4, 3, false);
		Text text = new Text("testeeee", 1);
		Words words = new Words("termos / de / exemplo", 5, " / ", "NENHUM");
		
		this.shortcut.createElement(title);
		this.shortcut.createElement(text);
		this.shortcut.createElement(words);
		
		String result = this.shortcut.generateShortRepresentation();
		
		assertEquals(expectedValue, result, msg);
	}
}
