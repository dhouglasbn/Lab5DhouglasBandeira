package documin.document;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	void createTextPriority1Test() {
		String msg = "Espera-se que um texto com prioridade 1 seja criado com sucesso,"
				+ " retornando index 0.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		int index = this
				.documentController
				.createText(docTitle, "Texto de exemplo", 1);
		
		assertEquals(0, index, msg);
	}
	
	@Test
	void createTextPriority5Test() {
		String msg = "Espera-se que um texto com prioridade 5 "
				+ "seja criado com sucesso, retornando index 0.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		int index = this
				.documentController
				.createText(docTitle, "Texto de exemplo", 5);
		
		assertEquals(0, index, msg);
	}
	
	@Test
	void createTextPriority0Test() {
		String msg = "Espera-se que um texto com prioridade 0 não seja"
				+ " criado, lançando a exceção IndexOutOfBoundsException.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.documentController
				.createText(docTitle, "Texto de exemplo", 0),
				msg
				);
	}
	
	@Test
	void createTextPriority6Test() {
		String msg = "Espera-se que um texto com prioridade 6 não seja"
				+ " criado, lançando a exceção IndexOutOfBoundsException.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.documentController
				.createText(docTitle, "Texto de exemplo", 6),
				msg
				);
	}
	
	@Test
	void createTitlePriority1Test() {
		String msg = "Espera-se que um título com prioridade 1 "
				+ " e nível 1 seja criado com sucesso, retornando index 0.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		int index = this
				.documentController
				.createTitle(docTitle, "Título de exemplo", 1, 1, false);
		
		assertEquals(0, index, msg);
	}
	
	@Test
	void createTitlePriority5Test() {
		String msg = "Espera-se que um Título com prioridade 5 "
				+ "seja criado com sucesso, retornando index 0.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		int index = this
				.documentController
				.createTitle(docTitle, "Título de exemplo", 5, 1, false);
		
		assertEquals(0, index, msg);
	}
	
	@Test
	void createTitlePriority0Test() {
		String msg = "Espera-se que um Título com prioridade 0 não seja"
				+ " criado, lançando a exceção IndexOutOfBoundsException.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.documentController
				.createTitle(docTitle, "Título de exemplo", 0, 1, false),
				msg
				);
	}
	
	@Test
	void createTitlePriority6Test() {
		String msg = "Espera-se que um Título com prioridade 6 não seja"
				+ " criado, lançando a exceção IndexOutOfBoundsException.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.documentController
				.createTitle(docTitle, "Texto de exemplo", 6, 1, false),
				msg
				);
	}
	
	@Test
	void createTitleLevel5Test() {
		String msg = "Espera-se que um título com nível 5 seja criado com sucesso,"
				+ " retornando index 0.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		int index = this
				.documentController
				.createTitle(docTitle, "Título de exemplo", 1, 5, false);
		
		assertEquals(0, index, msg);
	}
	
	@Test
	void createTitleLevel0Test() {
		String msg = "Espera-se que um título com nível 0 não seja"
				+ " criado, lançando a exceção IndexOutOfBoundsException.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.documentController
				.createTitle(docTitle, "Título de exemplo", 1, 0, false),
				msg
				);
	}
	
	@Test
	void createTitleLevel6Test() {
		String msg = "Espera-se que um título com prioridade 6 não seja"
				+ " criado, lançando a exceção IndexOutOfBoundsException.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.documentController
				.createTitle(docTitle, "Título de exemplo", 1, 6, false),
				msg
				);
	}
	
	@Test
	void createListPriority1Test() {
		String msg = "Espera-se que uma lista com prioridade 1"
				+ " seja criada com sucesso, retornando index 0.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		int index = this
				.documentController
				.createList(docTitle, "Lista | de | exemplo", 1, " | ", "-");
		
		assertEquals(0, index, msg);
	}
	
	@Test
	void createListPriority5Test() {
		String msg = "Espera-se que uma lista com prioridade 5 "
				+ "seja criada com sucesso, retornando index 0.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		int index = this
				.documentController
				.createList(docTitle, "Lista | de | exemplo", 5, " | ", "-");
		
		assertEquals(0, index, msg);
	}
	
	@Test
	void createListPriority0Test() {
		String msg = "Espera-se que uma lista com prioridade 0 não seja"
				+ " criada, lançando a exceção IndexOutOfBoundsException.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.documentController
				.createList(docTitle, "Lista | de | exemplo", 0, " | ", "-"),
				msg
				);
	}
	
	@Test
	void createListPriority6Test() {
		String msg = "Espera-se que uma lista com prioridade 6 não seja"
				+ " criada, lançando a exceção IndexOutOfBoundsException.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.documentController
				.createList(docTitle, "Lista | de | exemplo", 6, " | ", "-"),
				msg
				);
	}
	
	@Test
	void createNormalWordsPriority1Test() {
		String msg = "Espera-se que termos com prioridade 1 e ordenação NENHUM"
				+ " seja criado com sucesso, retornando index 0.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		int index = this
				.documentController
				.createWords(docTitle, "termos / de / exemplo", 1, " / ", "NENHUM");
		
		assertEquals(0, index, msg);
	}
	
	@Test
	void createLengthWordsPriority5Test() {
		String msg = "Espera-se que termos com prioridade 5 e ordenação TAMANHO"
				+ "seja criado com sucesso, retornando index 0.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		int index = this
				.documentController
				.createWords(docTitle, "termos / de / teste", 5, " / ", "TAMANHO");
		
		assertEquals(0, index, msg);
	}
	
	@Test
	void createAlphabeticalWordsTest() {
		String msg = "Espera-se que termos com ordenação ALFABÉTICA"
				+ " seja criado com sucesso, retornando index 0.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		int index = this
				.documentController
				.createWords(docTitle, "termos / de / teste", 1, " / ", "ALFABÉTICA");
		
		assertEquals(0, index, msg);
	}
	
	@Test
	void createWordsPriority0Test() {
		String msg = "Espera-se que termos com prioridade 0 não seja"
				+ " criado, lançando a exceção IndexOutOfBoundsException.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.documentController
				.createWords(docTitle, "termos / de / teste", 0, " / ", "NENHUM"),
				msg
				);
	}
	
	@Test
	void createWordsPriority6Test() {
		String msg = "Espera-se que termos com prioridade 6 não seja"
				+ " criado, lançando a exceção IndexOutOfBoundsException.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.documentController
				.createWords(docTitle, "termos / de / exemplo", 6, " / ", "NENHUM"),
				msg
				);
	}
	
	@Test
	void getElementsNumberTest() {
		String msg = "Espera-se que o número de elementos encontrados seja 2.";
		
		int expectedNumber = 2;
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle);
		this.documentController.createText(docTitle, "Texto de teste", 1);
		this.documentController.createTitle(docTitle, "Título de teste", 1, 3, false);
		
		int number = this.documentController.getElementsNumber(docTitle);
		
		assertEquals(expectedNumber, number, msg);
	}
	
	@Test
	void getFirstElementFullRepresentation() {
		String msg = "Espera-se que seja retornado a representação completa"
				+ "do primeiro elemento do documento.";
		String docTitle = "Documento de teste";
		String expectedValue = "Texto de exemplo";
		
		this.documentController.createDocument(docTitle);
		this.documentController.createText(docTitle, "Texto de exemplo", 1);
		
		String representation = this
				.documentController
				.getFullRepresentation(docTitle, 0);
		
		assertEquals(expectedValue, representation, msg);
	}
	
	@Test
	void getLastElementFullRepresentation() {
		String msg = "Espera-se que seja retornado a representação completa"
				+ "do último elemento do documento.";
		String docTitle = "Documento de teste";
		String expectedValue = "3. Título de exemplo";
		
		this.documentController.createDocument(docTitle);
		this.documentController.createText(docTitle, "Texto de exemplo", 1);
		this
		.documentController
		.createTitle(docTitle, "Título de exemplo", 1, 3, false);
		
		String representation = this
				.documentController
				.getFullRepresentation(docTitle, 1);
		
		assertEquals(expectedValue, representation, msg);
	}
	
	@Test
	void getUnderFirstElementFullRepresentation() {
		String msg = "Espera-se que ao pegar a representação completa do elemento"
				+ "antecessor ao primeiro elemento, seja lançado a exceção"
				+ " IndexOutOfBoundsException";
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle);
		this.documentController.createText(docTitle, "Texto de exemplo", 1);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.documentController
				.getFullRepresentation(docTitle, -1),
				msg
				);
	}
	
	@Test
	void getOverLastElementFullRepresentation() {
		String msg = "Espera-se que ao pegar a representação completa do elemento"
				+ "sucessor ao último elemento, seja lançado a exceção"
				+ " IndexOutOfBoundsException";
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle);
		this.documentController.createText(docTitle, "Texto de exemplo", 1);
		this.documentController.createList(
				docTitle,
				"Lista | de | exemplo",
				1,
				" | ",
				"-"
				);
		int docSize = this.documentController.getElementsNumber(docTitle);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.documentController
				.getFullRepresentation(docTitle, docSize),
				msg
				);
	}
	
	@Test
	void getFirstElementShortRepresentation() {
		String msg = "Espera-se que seja retornado a representação resumida"
				+ "do primeiro elemento do documento.";
		String docTitle = "Documento de teste";
		String expectedValue = "Lista, de, exemplo\n";
		
		this.documentController.createDocument(docTitle);
		this.documentController.createList(
				docTitle,
				"Lista / de / exemplo",
				1,
				" / ",
				"->"
				);
		
		String representation = this
				.documentController
				.getShortRepresentation(docTitle, 0);
		
		assertEquals(expectedValue, representation, msg);
	}
	
	@Test
	void getLastElementShortRepresentation() {
		String msg = "Espera-se que seja retornado a representação resumida"
				+ "do último elemento do documento.";
		String docTitle = "Documento de teste";
		String expectedValue = "termos / de / exemplo\n";
		
		this.documentController.createDocument(docTitle);
		this
		.documentController
		.createTitle(docTitle, "Título de exemplo", 1, 3, false);
		this.documentController.createWords(
				docTitle,
				"termos / de / exemplo",
				1,
				" / ",
				"NENHUM"
				);
		
		String representation = this
				.documentController
				.getShortRepresentation(docTitle, 1);
		
		assertEquals(expectedValue, representation, msg);
	}

	@Test
	void getUnderFirstElementShortRepresentation() {
		String msg = "Espera-se que ao pegar a representação resumida do elemento"
				+ "antecessor ao primeiro elemento, seja lançado a exceção"
				+ " IndexOutOfBoundsException";
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle);
		this.documentController.createText(docTitle, "Texto de exemplo", 1);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.documentController
				.getShortRepresentation(docTitle, -1),
				msg
				);
	}
	
	@Test
	void getOverLastElementShortRepresentation() {
		String msg = "Espera-se que ao pegar a representação resumida do elemento"
				+ "sucessor ao último elemento, seja lançado a exceção"
				+ " IndexOutOfBoundsException";
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle);
		this.documentController.createText(docTitle, "Texto de exemplo", 1);
		this.documentController.createList(
				docTitle,
				"Lista | de | exemplo",
				1,
				" | ",
				"-"
				);
		int docSize = this.documentController.getElementsNumber(docTitle);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.documentController
				.getShortRepresentation(docTitle, docSize),
				msg
				);
	}
}
