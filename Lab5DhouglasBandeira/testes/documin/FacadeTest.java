package documin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

/** Representação de um test case da facade.
 * 
 * @author Dhouglas Bandeira
 *
 */
class FacadeTest {
	
	private Facade facade;
	
	@BeforeEach
	void setUp() {
		this.facade = new Facade();
	}
	
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	public static final String BLANK_TITLE_MSG = "TÍTULO NÃO PODE SER VAZIO";
	
	public static final String INEXISTENT_DOCUMENT = "O DOCUMENTO NÂO ESTÁ CADASTRADO";

	@Test
	void createDocumentTest() {
		String msg = "Espera-se que um documento seja criado com sucesso";
		
		boolean result = this.facade.createDocument("Documento teste");
		assertTrue(result, msg);
	}
	
	@Test
	void createLimitedDocumentTest() {
		String msg = "Espera-se que um documento com limite de elementos "
				+ "seja criado com sucesso";
		
		boolean result = this.facade.createDocument("Documento teste", 2);
		
		assertTrue(result, msg);
	}
	
	@Test
	void createBlankTitleDocumentTest() {
		String msg = "Espera-se que um documento de titulo vazio não seja criado.";
		boolean result = false;
		
		this.facade.createDocument("Documento teste");

		expectedException.expect(Exception.class);
		expectedException.expectMessage(BLANK_TITLE_MSG);
		
		result = this.facade.createDocument("  ");
		assertFalse(result, msg);
	}
	
	@Test
	void createAlreadyExistentLimitedDocumentTest() {
		String msg = "Espera-se que um documento limitado de titulo vazio "
				+ "não seja criado.";
		boolean result = false;
		
		this.facade.createDocument("Documento teste");

		expectedException.expect(Exception.class);
		expectedException.expectMessage(BLANK_TITLE_MSG);
		
		result = this.facade.createDocument("  ", 2);
		assertFalse(result, msg);
	}
	
	@Test
	void deleteDocumentTest() {
		String msg = "Se após deletar um documento, a criação de outro de mesmo "
				+ "título for bem sucedida, a remoção aconteceu com sucesso.";
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		this.facade.deleteDocument(docTitle);
		boolean result = this.facade.createDocument(docTitle);
		
		assertTrue(result, msg);
	}
	
	@Test
	void deleteBlankTitleDocumentTest() {
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(BLANK_TITLE_MSG);
		
		this.facade.deleteDocument("  ");
	}
	
	@Test
	void countElementsTest() {
		String msg = "Espera-se que seja retornado o número exato de elementos "
				+ "do documento(1).";
		int expectedResult = 1;
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		this.facade.createText(docTitle, "Texto exemplo", 1);
		
		int result = this.facade.countElements(docTitle);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void countInexistentDocumentElementsTest() {
		String docTitle = "Documento teste";
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(INEXISTENT_DOCUMENT);
		
		this.facade.countElements(docTitle);
	}
	
	@Test
	void showDocumentTest() {
		String msg = "Espera-se que seja exibido as representações resumidas "
				+ "dos elementos do documento.";
		String[] expectedResult = {
				"Texto exemplo\n",
				"1. Título teste\n"
		};
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		this.facade.createText(docTitle, "Texto exemplo", 1);
		this.facade.createTitle(docTitle, "Título teste", 1, 1, true);
		
		String[] result = this.facade.showDocument(docTitle);
		
		assertArrayEquals(expectedResult, result, msg);
	}
	
	@Test
	void showInexistentDocumentTest() {
		String docTitle = "Documento teste";
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(INEXISTENT_DOCUMENT);
		
		this.facade.showDocument(docTitle);
	}
	
	@Test
	void createTextTest() {
		String msg = "Espera-se que um texto seja criado com sucesso no documento, "
				+ "retornando o index do elemento dentro do documento.";
		int expectedResult = 0;
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		int result = this.facade.createText(docTitle, "Texto exemplo", 1);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void createTextInInexistentDocumentTest() {
		String docTitle = "Documento teste";
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(INEXISTENT_DOCUMENT);
		
		this.facade.createText(docTitle, "Texto exemplo", 1);
	}
	
	@Test
	void createTitleTest() {
		String msg = "Espera-se que um título seja criado com sucesso no documento, "
				+ "retornando o index do elemento dentro do documento.";
		int expectedResult = 0;
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		int result = this
				.facade
				.createTitle(docTitle, "Título exemplo", 1, 2, true);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void createTitleInInexistentDocumentTest() {
		String docTitle = "Documento teste";
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(INEXISTENT_DOCUMENT);
		
		this.facade.createTitle(docTitle, "Título exemplo", 1, 2, true);
	}
	
	@Test
	void createListTest() {
		String msg = "Espera-se que uma lista seja criada com sucesso no documento, "
				+ "retornando o index do elemento dentro do documento.";
		int expectedResult = 0;
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		int result = this
				.facade
				.createList(docTitle, "Lista / de / exemplo", 1, " / ", "-");
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void createListInInexistentDocumentTest() {
		String docTitle = "Documento teste";
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(INEXISTENT_DOCUMENT);
		
		this.facade.createList(docTitle, "Lista / de / exemplo", 1, " / ", "-");
	}
	
	@Test
	void createWordsTest() {
		String msg = "Espera-se que temos sejam criadas com sucesso no documento, "
				+ "retornando o index do elemento dentro do documento.";
		int expectedResult = 0;
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		int result = this
				.facade
				.createWords(docTitle, "Termos / de / exemplo", 1, " / ", "NENHUM");
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void createWordsInInexistentDocumentTest() {
		String docTitle = "Documento teste";
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(INEXISTENT_DOCUMENT);
		
		this
		.facade
		.createWords(docTitle, "Termos / de / exemplo", 1, " / ", "NENHUM");
	}
	
	@Test
	void getFullRepresentationTest() {
		String msg = "Espera-se que seja gerada a representação completa de um "
				+ "elemento do documento.";
		String expectedResult = "1. Título exemplo -- 1-TÍTULOEXEMPLO\n";
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		this.facade.createTitle(docTitle, "Título exemplo", 1, 1, true);
		
		String result = this.facade.getFullRepresentation(docTitle, 0);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void getFullRepresentationFromInexistentDocumentTest() {
		String docTitle = "Documento teste";
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(INEXISTENT_DOCUMENT);
		
		this
		.facade
		.getFullRepresentation(docTitle, 0);
	}
	
	
	@Test
	void getShortRepresentationTest() {
		String msg = "Espera-se que seja gerada a representação resumida de um "
				+ "elemento do documento.";
		String expectedResult = "1. Título exemplo\n";
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		this.facade.createTitle(docTitle, "Título exemplo", 1, 1, true);
		
		String result = this.facade.getShortRepresentation(docTitle, 0);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void getShortRepresentationFromInexistentDocumentTest() {
		String docTitle = "Documento teste";
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(INEXISTENT_DOCUMENT);
		
		this
		.facade
		.getShortRepresentation(docTitle, 0);
	}
	
	@Test
	void removeElementTest() {
		String msg = "Espera-se que um elemento seja removido com sucesso.";
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		this.facade.createTitle(docTitle, "Título exemplo", 1, 1, true);
		
		boolean result = this.facade.removeElement(docTitle, 0);
		
		assertTrue(result, msg);
	}
	
	@Test
	void removeElementFromInexistentDocumentTest() {
		String docTitle = "Documento teste";
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(INEXISTENT_DOCUMENT);
		
		this
		.facade
		.removeElement(docTitle, 0);
	}
	
	@Test
	void moveElementUpTest() {
		String msg = "Espera-se que um elemento seja movido para cima com sucesso.";
		String expectedResult = "Texto exemplo\n";
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		this.facade.createTitle(docTitle, "Título exemplo", 1, 1, true);
		this.facade.createText(docTitle, "Texto exemplo", 1);
		
		this.facade.moveElementUp(docTitle, 1);
		
		String result = this
				.facade
				.getShortRepresentation(docTitle, 0);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void moveElementFromInexistentDocumentUpTest() {
		String docTitle = "Documento teste";
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(INEXISTENT_DOCUMENT);
		
		this
		.facade
		.moveElementUp(docTitle, 1);
	}
	
	@Test
	void moveElementDownTest() {
		String msg = "Espera-se que um elemento seja movido para baixo com sucesso.";
		String expectedResult = "1. Título exemplo\n";
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		this.facade.createTitle(docTitle, "Título exemplo", 1, 1, true);
		this.facade.createText(docTitle, "Texto exemplo", 1);
		
		this.facade.moveElementDown(docTitle, 0);
		
		String result = this.facade.getShortRepresentation(docTitle, 1);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void mvoeElementFromInexistentDocumentDownTest() {
		String docTitle = "Documento teste";
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(INEXISTENT_DOCUMENT);
		
		this
		.facade
		.moveElementDown(docTitle, 0);
	}
	
	@Test
	void createFullVisionTest() {
		String msg = "Espera-se que uma visão completa seja criada com sucesso, "
				+ "retornando sua posição nos registros(0).";
		int expectedResult = 0;
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		
		int result = this.facade.createFullVision(docTitle);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void createFullVisionOnInexistentDocumentTest() {
		String docTitle = "Documento teste";
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(INEXISTENT_DOCUMENT);
		
		this
		.facade
		.createFullVision(docTitle);
	}
	
	@Test
	void createShortVisionTest() {
		String msg = "Espera-se que uma visão resumida seja criada com sucesso, "
				+ "retornando sua posição nos registros(0).";
		int expectedResult = 0;
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		
		int result = this.facade.createShortVision(docTitle);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void createShortVisionOnInexistentDocumentTest() {
		String docTitle = "Documento teste";
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(INEXISTENT_DOCUMENT);
		
		this
		.facade
		.createShortVision(docTitle);
	}
	
	@Test
	void createPriorityVisionTest() {
		String msg = "Espera-se que uma visão prioritária seja criada com sucesso, "
				+ "retornando sua posição nos registros(0).";
		int expectedResult = 0;
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		
		int result = this.facade.createPriorityVision(docTitle, 1);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void createPriorityVisionOnInexistentDocumentTest() {
		String docTitle = "Documento teste";
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(INEXISTENT_DOCUMENT);
		
		this
		.facade
		.createPriorityVision(docTitle, 1);
	}
	
	@Test
	void createTitleVisionTest() {
		String msg = "Espera-se que uma visão de títulos seja criada com sucesso, "
				+ "retornando sua posição nos registros(0).";
		int expectedResult = 0;
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		
		int result = this.facade.createTitleVision(docTitle);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void createTitleVisionOnInexistentDocumentTest() {
		String docTitle = "Documento teste";
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(INEXISTENT_DOCUMENT);
		
		this
		.facade
		.createTitleVision(docTitle);
	}
	
	@Test
	void showVisionTest() {
		String msg = "Espera-se que a representação de uma visão seja retornada "
				+ "com sucesso.";
		String[] expectedResult = {
				"Texto exemplo\n",
				"1. Título exemplo -- 1-TÍTULOEXEMPLO\n",
				"- Lista\n"
				+ "- de\n"
				+ "- exemplo\n",
				"Total termos: 3\n"
				+ "- termos, de, exemplo\n"
		};
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		
		this
		.facade
		.createText(docTitle, "Texto exemplo", 1);
		this
		.facade
		.createTitle(docTitle, "Título exemplo", 1, 1, true);
		this
		.facade
		.createList(docTitle, "Lista / de / exemplo", 1, " / ", "-");
		this
		.facade
		.createWords(docTitle, "Termos / de / exemplo", 1, " / ", "NENHUM");
		
		this.facade.createFullVision(docTitle);
		String[] result = this.facade.showVision(0);
		
		assertArrayEquals(expectedResult, result, msg);
	}
	
	@Test
	void showInexistentVisionTest() {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("VISÃO INEXISTENTE!");
		
		this
		.facade
		.showVision(-1);
	}
}
