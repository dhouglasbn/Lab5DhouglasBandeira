package documin.document;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElementControllerTest {
	
	private DocumentController documentController;
	private ElementController elementController;

	@BeforeEach
	void setUp() throws Exception {
		this.documentController = new DocumentController();
		this.elementController = new ElementController(documentController);
	}

	@Test
	void createTextPriority1Test() {
		String msg = "Espera-se que um texto com prioridade 1 seja criado com sucesso,"
				+ " retornando index 0.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		int index = this
				.elementController
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
				.elementController
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
				.elementController
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
				.elementController
				.createText(docTitle, "Texto de exemplo", 6),
				msg
				);
	}
	
	@Test
	void createFullDocumentTextTest() {
		String msg = "Espera-se que um texto não seja criado com sucesso, em um documento cheio.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle, 0);
		
		assertThrows(
				IllegalStateException.class,
				() -> this
				.elementController
				.createText(docTitle, "Texto de exemplo", 1),
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
				.elementController
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
				.elementController
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
				.elementController
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
				.elementController
				.createTitle(docTitle, "Texto de exemplo", 6, 1, false),
				msg
				);
	}
	
	@Test
	void createFullDocumentTitleTest() {
		String msg = "Espera-se que um título não seja criado com sucesso, em um documento cheio.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle, 0);
		
		assertThrows(
				IllegalStateException.class,
				() -> this
				.elementController
				.createTitle(docTitle, "Texto de exemplo", 1, 1, true),
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
				.elementController
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
				.elementController
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
				.elementController
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
				.elementController
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
				.elementController
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
				.elementController
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
				.elementController
				.createList(docTitle, "Lista | de | exemplo", 6, " | ", "-"),
				msg
				);
	}
	
	@Test
	void createFullDocumentListTest() {
		String msg = "Espera-se que uma lista não seja criada com sucesso, em um documento cheio.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle, 0);
		
		assertThrows(
				IllegalStateException.class,
				() -> this
				.elementController
				.createList(docTitle, "lista | exemplo", 1, " | ", "-"),
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
				.elementController
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
				.elementController
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
				.elementController
				.createWords(docTitle, "termos / de / teste", 1, " / ", "ALFABÉTICA");
		
		assertEquals(0, index, msg);
	}
	
	@Test
	void createWrongRankWordsTest() {
		String msg = "Espera-se que termos com ordenação diferente do esperado"
				+ " lance a exceção IllegalArgumentException.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle);
		
		assertThrows(
				IllegalArgumentException.class,
				() -> this
				.elementController
				.createWords(docTitle, "termos / de / teste", 1, " / ", "INVERSO"),
				msg
				);
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
				.elementController
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
				.elementController
				.createWords(docTitle, "termos / de / exemplo", 6, " / ", "NENHUM"),
				msg
				);
	}
	
	@Test
	void createFullDocumentWordsTest() {
		String msg = "Espera-se que termos não sejam criados com sucesso, em um documento cheio.";
		
		String docTitle = "Documento de Teste";
		
		this.documentController.createDocument(docTitle, 0);
		
		assertThrows(
				IllegalStateException.class,
				() -> this
				.elementController
				.createWords(docTitle, "termos / de / exemplo", 1, " / ", "NENHUM"),
				msg
				);
	}
	
	@Test
	void getElementsNumberTest() {
		String msg = "Espera-se que o número de elementos encontrados seja 2.";
		
		int expectedNumber = 2;
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle);
		this.elementController.createText(docTitle, "Texto de teste", 1);
		this.elementController.createTitle(docTitle, "Título de teste", 1, 3, false);
		
		int number = this.elementController.getElementsNumber(docTitle);
		
		assertEquals(expectedNumber, number, msg);
	}
	
	@Test
	void getFirstElementFullRepresentation() {
		String msg = "Espera-se que seja retornado a representação completa"
				+ "do primeiro elemento do documento.";
		String docTitle = "Documento de teste";
		String expectedValue = "Texto de exemplo\n";
		
		this.documentController.createDocument(docTitle);
		this.elementController.createText(docTitle, "Texto de exemplo", 1);
		
		String representation = this
				.elementController
				.getFullRepresentation(docTitle, 0);
		
		assertEquals(expectedValue, representation, msg);
	}
	
	@Test
	void getLastElementFullRepresentation() {
		String msg = "Espera-se que seja retornado a representação completa"
				+ "do último elemento do documento.";
		String docTitle = "Documento de teste";
		String expectedValue = "3. Título de exemplo\n";
		
		this.documentController.createDocument(docTitle);
		this.elementController.createText(docTitle, "Texto de exemplo", 1);
		this
		.elementController
		.createTitle(docTitle, "Título de exemplo", 1, 3, false);
		
		String representation = this
				.elementController
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
		this.elementController.createText(docTitle, "Texto de exemplo", 1);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.elementController
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
		this.elementController.createText(docTitle, "Texto de exemplo", 1);
		this.elementController.createList(
				docTitle,
				"Lista | de | exemplo",
				1,
				" | ",
				"-"
				);
		int docSize = this.elementController.getElementsNumber(docTitle);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.elementController
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
		this.elementController.createList(
				docTitle,
				"Lista / de / exemplo",
				1,
				" / ",
				"->"
				);
		
		String representation = this
				.elementController
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
		.elementController
		.createTitle(docTitle, "Título de exemplo", 1, 3, false);
		this.elementController.createWords(
				docTitle,
				"termos / de / exemplo",
				1,
				" / ",
				"NENHUM"
				);
		
		String representation = this
				.elementController
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
		this.elementController.createText(docTitle, "Texto de exemplo", 1);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.elementController
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
		this.elementController.createText(docTitle, "Texto de exemplo", 1);
		this.elementController.createList(
				docTitle,
				"Lista | de | exemplo",
				1,
				" | ",
				"-"
				);
		int docSize = this.elementController.getElementsNumber(docTitle);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.elementController
				.getShortRepresentation(docTitle, docSize),
				msg
				);
	}
	
	@Test
	void removeFirstElementTest() {
		String msg = "Espera-se que o primeiro elemento do documento seja removido "
				+ "com sucesso.";
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle);
		
		this.elementController.createTitle(
				docTitle,
				"Título de teste",
				1,
				1,
				false
		);
		this.elementController.createText(docTitle, "Texto de teste", 1);
		
		boolean result = this.elementController.removeElement(docTitle, 0);
		
		assertTrue(result, msg);
	}
	
	@Test
	void removeLastElementTest() {
		String msg = "Espera-se que o último elemento do documento seja removido "
				+ "com sucesso.";
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle);
		
		this.elementController.createTitle(
				docTitle,
				"Título de teste",
				1,
				1,
				false
		);
		this.elementController.createText(docTitle, "Texto de teste", 1);
		
		boolean result = this.elementController.removeElement(docTitle, 1);
		
		assertTrue(result, msg);
	}
	
	@Test
	void removeUnderFirstElementTest() {
		String msg = "Espera-se que o elemento antes do primeiro elemento"
				+ " do documento seja removido com sucesso.";
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle);
		
		this.elementController.createTitle(
				docTitle,
				"Título de teste",
				1,
				1,
				false
		);
		this.elementController.createText(docTitle, "Texto de teste", 1);
		
		assertThrows(
				IndexOutOfBoundsException.class
				,
				() -> this
				.elementController
				.removeElement(docTitle, -1),
				msg
		);
	}
	
	@Test
	void removeOverLastElementTest() {
		String msg = "Espera-se que o elemento após o último elemento do "
				+ "documento seja removido com sucesso.";
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle);
		
		this.elementController.createTitle(
				docTitle,
				"Título de teste",
				1,
				1,
				false
		);
		this.elementController.createText(docTitle, "Texto de teste", 1);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.elementController
				.removeElement(docTitle, 2),
				msg
		);
	}
	
	@Test
	void moveFirstElementUp() {
		String msg1 = "Espera-se que ao mover o primeiro elemento para cima, "
				+ "o primeiro elemento continue no mesmo lugar.";
		String msg2 = "Espera-se que ao mover o primeiro elemento para cima, "
				+ "o segundo elemento continue no mesmo lugar.";
		String docTitle = "Documento de teste";
		int firstPosition = 0;
		int lastPosition = 1;
		
		this.documentController.createDocument(docTitle);
		Document document = this.documentController.getDocument(docTitle);
		
		this.elementController.createTitle(
				docTitle,
				"Título de teste",
				1,
				1,
				false
		);
		this.elementController.createText(
				docTitle,
				"Texto de teste",
				1
		);
		
		Element element1 = document.getElement(firstPosition);
		Element element2 = document.getElement(lastPosition);
		
		this.elementController.moveElementUp(docTitle, firstPosition);
		
		Element element3 = document.getElement(firstPosition);
		Element element4 = document.getElement(lastPosition);
		
		assertTrue(element1.equals(element3), msg1);
		assertTrue(element2.equals(element4), msg2);
	}
	
	@Test
	void moveLastElementUp() {
		String msg1 = "Espera-se que ao mover o segundo elemento para cima, "
				+ "o primeiro elemento troque a posição com o segundo elemento.";
		String msg2 = "Espera-se que ao mover o segundo elemento para cima, "
				+ "o segundo elemento troque a posição com o primeiro elemento.";
		String docTitle = "Documento de teste";
		int firstPosition = 0;
		int lastPosition = 1;
		
		this.documentController.createDocument(docTitle);
		Document document = this.documentController.getDocument(docTitle);
		
		this.elementController.createTitle(
				docTitle,
				"Título de teste",
				1,
				1,
				false
		);
		this.elementController.createText(
				docTitle,
				"Texto de teste",
				1
		);
		
		Element element1 = document.getElement(firstPosition);
		Element element2 = document.getElement(lastPosition);
		
		this.elementController.moveElementUp(docTitle, lastPosition);
		
		Element element3 = document.getElement(firstPosition);
		Element element4 = document.getElement(lastPosition);
		
		assertTrue(element1.equals(element4), msg1);
		assertTrue(element2.equals(element3), msg2);
	}

	@Test
	void moveUnderFirstElementUp() {
		String msg = "Espera-se que ao mover o elemento antecessor ao primeiro "
				+ "elemento para cima, seja lançada a exceção"
				+ " IndexOutOfBoundsException";
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle);
		
		this.elementController.createTitle(
				docTitle,
				"Título de teste",
				1,
				1,
				false
		);
		this.elementController.createText(
				docTitle,
				"Texto de teste",
				1
		);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.elementController.moveElementUp(docTitle, -1),
				msg
		);
	}
	
	@Test
	void moveOverLastElementUp() {
		String msg = "Espera-se que ao mover o elemento sucessor ao segundo "
				+ "elemento cima, seja lançada a exceção "
				+ "IndexOutOfBoundsException";
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle);
		
		this.elementController.createTitle(
				docTitle,
				"Título de teste",
				1,
				1,
				false
		);
		this.elementController.createText(
				docTitle,
				"Texto de teste",
				1
		);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.elementController.moveElementUp(docTitle, 2),
				msg
		);
	}
	
	@Test
	void moveFirstElementDown() {
		String msg1 = "Espera-se que ao mover o primeiro elemento para baixo, "
				+ "o primeiro elemento troque a posição com o segundo elemento.";
		String msg2 = "Espera-se que ao mover o primeiro elemento para baixo, "
				+ "o segundo elemento troque a posição com o primeiro elemento.";
		String docTitle = "Documento de teste";
		int firstPosition = 0;
		int lastPosition = 1;
		
		this.documentController.createDocument(docTitle);
		Document document = this.documentController.getDocument(docTitle);
		
		this.elementController.createTitle(
				docTitle,
				"Título de teste",
				1,
				1,
				false
		);
		this.elementController.createText(
				docTitle,
				"Texto de teste",
				1
		);
		
		Element element1 = document.getElement(firstPosition);
		Element element2 = document.getElement(lastPosition);
		
		this.elementController.moveElementDown(docTitle, firstPosition);
		
		Element element3 = document.getElement(firstPosition);
		Element element4 = document.getElement(lastPosition);
		
		assertTrue(element1.equals(element4), msg1);
		assertTrue(element2.equals(element3), msg2);
	}
	
	@Test
	void moveLastElementDown() {
		String msg1 = "Espera-se que ao mover o segundo elemento para baixo, "
				+ "o primeiro elemento continue na mesma posição.";
		String msg2 = "Espera-se que ao mover o segundo elemento para cima, "
				+ "o segundo elemento continue na mesma posição.";
		String docTitle = "Documento de teste";
		int firstPosition = 0;
		int lastPosition = 1;
		
		this.documentController.createDocument(docTitle);
		Document document = this.documentController.getDocument(docTitle);
		
		this.elementController.createTitle(
				docTitle,
				"Título de teste",
				1,
				1,
				false
		);
		this.elementController.createText(
				docTitle,
				"Texto de teste",
				1
		);
		
		Element element1 = document.getElement(firstPosition);
		Element element2 = document.getElement(lastPosition);
		
		this.elementController.moveElementDown(docTitle, lastPosition);
		
		Element element3 = document.getElement(firstPosition);
		Element element4 = document.getElement(lastPosition);
		
		assertTrue(element1.equals(element3), msg1);
		assertTrue(element2.equals(element4), msg2);
	}
	
	@Test
	void moveUnderFirstElementDown() {
		String msg = "Espera-se que ao mover o elemento antecessor ao primeiro "
				+ "elemento para baixo, seja lançada a exceção"
				+ " IndexOutOfBoundsException";
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle);
		
		this.elementController.createTitle(
				docTitle,
				"Título de teste",
				1,
				1,
				false
		);
		this.elementController.createText(
				docTitle,
				"Texto de teste",
				1
		);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.elementController.moveElementDown(docTitle, -1),
				msg
		);
	}
	
	@Test
	void moveOverLastElementDown() {
		String msg = "Espera-se que ao mover o elemento sucessor ao segundo "
				+ "elemento para baixo, seja lançada a exceção "
				+ "IndexOutOfBoundsException";
		String docTitle = "Documento de teste";
		
		this.documentController.createDocument(docTitle);
		
		this.elementController.createTitle(
				docTitle,
				"Título de teste",
				1,
				1,
				false
		);
		this.elementController.createText(
				docTitle,
				"Texto de teste",
				1
		);
		
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> this
				.elementController.moveElementDown(docTitle, 2),
				msg
		);
	}
	
	@Test
	void createShortcutTest() {
		String msg = "Espera-se que um atalho seja criado em um documento.";
		String docTitle = "Documento de teste";
		String shortcutTitle = "Atalho teste";
		int expectedResult = 0;
		
		this.documentController.createDocument(docTitle);
		this.documentController.createDocument(shortcutTitle);
		
		int result = this
				.elementController
				.createShortcut(docTitle, shortcutTitle);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void createShortcutInFullDocumentTest() {
		String msg = "Espera-se que ao criar um atalho em um documento "
				+ "cheio de elementos, seja lançada a exceção "
				+ "IllegalStateException.";
		String docTitle = "Documento de teste";
		String shortcutTitle = "Atalho de teste";
		
		this.documentController.createDocument(docTitle, 0);
		this.documentController.createDocument(shortcutTitle);
		
		assertThrows(
				IllegalStateException.class,
				() -> this
				.elementController
				.createShortcut(docTitle, shortcutTitle),
				msg
				);
	}
	
	@Test
	void createShortcutInShortcutTest() {
		String msg = "Espera-se que ao criar um atalho em um atalho "
				+ ", seja lançada a exceção IllegalStateException.";
		String docTitle = "Documento de teste";
		String shortcutTitle = "Atalho de teste";
		String shortcut2Title = "Atalho para inserir no atalho";
		
		this.documentController.createDocument(docTitle);
		this.documentController.createDocument(shortcutTitle);
		this.documentController.createDocument(shortcut2Title);
		
		this.elementController.createShortcut(docTitle, shortcutTitle);
		
		assertThrows(
				IllegalStateException.class,
				() -> this
				.elementController
				.createShortcut(shortcutTitle, shortcut2Title),
				msg
				);
	}
	
	@Test
	void createShortcutWithShortcuts() {
		String msg = "Espera-se que ao criar um atalho, que contém "
				+ "atalhos, seja lançada a exceção IllegalStateException.";
		String docTitle = "Documento de teste";
		String shortcutTitle = "Atalho de teste";
		String shortcut2Title = "Atalho 2";
		
		this.documentController.createDocument(docTitle);
		this.documentController.createDocument(shortcutTitle);
		this.documentController.createDocument(shortcut2Title);
		
		this.elementController.createShortcut(shortcutTitle, shortcut2Title);
		
		assertThrows(
				IllegalStateException.class,
				() -> this
				.elementController
				.createShortcut(docTitle, shortcutTitle),
				msg
				);
	}
}
