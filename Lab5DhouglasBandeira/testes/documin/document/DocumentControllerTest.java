package documin.document;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Representação de um test case do controlador
 *  dos documentos.
 *  
 * @author Dhouglas Bandeira
 *
 */
class DocumentControllerTest {

	private DocumentController documentController;
	
	@BeforeEach
	void setUp() throws Exception {
		this.documentController = new DocumentController();
	}

	@Test
	void createDocumentTest() {
		String msg = "Espera-se que o documento seja criado com sucesso.";
		
		boolean result = this
				.documentController
				.createDocument("Documento de teste");
		
		assertTrue(result, msg);
	}
	
	@Test
	void createLimitedDocumentTest() {
		String msg = "Espera-se que o documento limitado seja criado com sucesso.";
		
		boolean result = this
				.documentController
				.createDocument("Documento de teste", 5);
		
		assertTrue(result, msg);
	}

	@Test
	void createDocumentWithoutTitleTest() {
		String msg = "Espera-se que o documento sem título"
				+ " lance a exceção IllegalArgumentException.";
		
		assertThrows(
				IllegalArgumentException.class,
				() -> this.documentController.createDocument("  "),
				msg
				);
	}
	
	@Test
	void createLimitedDocumentWithoutTitleTest() {
		String msg = "Espera-se que o documento limitado lance"
				+ " a exceção IllegalArgumentException.";
		
		assertThrows(
				IllegalArgumentException.class,
				() -> this.documentController.createDocument("  ", 5),
				msg
				);
	}
	
	@Test
	void createAlreadyExistentDocumentTest() {
		String msg = "Espera-se que a criação de um documento de título já"
				+ " cadastrado seja mal sucedida.";
		
		this.documentController.createDocument("teste");
		boolean result = this.documentController.createDocument("teste");
		
		assertFalse(result,msg);
	}
	
	@Test
	void createAlreadyExistentLimitedDocumentTest() {
		String msg = "Espera-se que a criação de um documento limitado"
				+ " de título já cadastrado seja mal sucedida.";
		
		this.documentController.createDocument("teste", 5);
		boolean result = this.documentController.createDocument("teste", 4);
		
		assertFalse(result,msg);
	}
	
	
	@Test
	void removeDocumentTest() {
		String msg = "Espera-se que o documento seja removido com sucesso.";
		
		String title = "teste";
		
		this.documentController.createDocument(title);
		this.documentController.deleteDocument(title);
		
		assertThrows(
				NoSuchElementException.class,
				() -> this.documentController.getDocument(title),
				msg
				);
	}
	
	@Test
	void removeDocumentWithouTitleTest() {
		String msg = "Espera-se que a remoção de um documento com título vazio"
				+ "lance a exceção IllegalArgumentException.";
		
		assertThrows(
				IllegalArgumentException.class,
				() -> this
				.documentController
				.deleteDocument("  "),
				msg
				);
	}
	
	@Test
	void getBlankTitleElement() {
		String msg = "Espera-se que ao tentar pegar um elemento com título"
				+ "vazio, seja lançada a exceção IllegalArgumentException";
		
		assertThrows(
				IllegalArgumentException.class,
				() -> this.documentController.getDocument("  "),
				msg
				);
	}
	
	@Test
	void getInexistentTitleElement() {
		String msg = "Espera-se que ao tentar pegar um elemento com título"
				+ "vazio, seja lançada a exceção IllegalArgumentException";
		
		assertThrows(
				NoSuchElementException.class,
				() -> this.documentController.getDocument("Documento de teste"),
				msg
				);
	}
	
	@Test
	void showDocumentTest() {
		String msg = "Espera-se que seja retornada as representações"
				+ " curtas dos elementos do documento.";
		String docTitle = "Documento de teste";
		String expectedFirstValue = "lista, de, exemplo\n";
		String expectedSecondValue = "termos / de / exemplo\n";
		
		this.documentController.createDocument(docTitle);
		Document document = this.documentController.getDocument(docTitle);
		
		ListElement listElement = new ListElement("lista | de | exemplo", 1, " | ", "-");
		Words words = new Words("termos / de / exemplo", 1, " / ", "NENHUM");
		
		document.createElement(listElement);
		document.createElement(words);
		
		String[] result = this.documentController.showDocument(docTitle);
		
		assertEquals(expectedFirstValue, result[0], msg);
		assertEquals(expectedSecondValue, result[1], msg);
	}
	
	@Test
	void isDocumentFull() {
		String msg = "Espera-se que com a mesma quantidade de elementos registrados "
				+ "que a quantidade total de elementos, o documento esteja cheio";
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle, 3);
		Document newDocument = this.documentController.getDocument(docTitle);
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		Words words = new Words("termos / de / exemplo", 1, " / ", "NENHUM");
		
		newDocument.createElement(title);
		newDocument.createElement(text);
		newDocument.createElement(words);
		
		boolean result = this.documentController.isDocumentFull(docTitle);
		
		assertTrue(result, msg);
	}
	
	@Test
	void isntDocumentFull() {
		String msg = "Espera-se que com a quantidade de elementos registrados "
				+ "menor que a quantidade total de elementos, o documento esteja cheio";
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle, 3);
		Document newDocument = this.documentController.getDocument(docTitle);
		
		Title title = new Title("teste", 1, 3, false);
		Text text = new Text("testeeee", 1);
		
		newDocument.createElement(title);
		newDocument.createElement(text);
		
		boolean result = this.documentController.isDocumentFull(docTitle);
		
		assertFalse(result, msg);
	}
}
