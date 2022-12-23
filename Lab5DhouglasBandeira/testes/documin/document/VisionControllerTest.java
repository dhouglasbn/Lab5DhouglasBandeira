package documin.document;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VisionControllerTest {
	
	private DocumentController documentController;
	
	private VisionController visionController;
	
	private String docTitle = "Documento de teste";

	@BeforeEach
	void setUp() throws Exception {
		this.documentController = new DocumentController();
		this.visionController = new VisionController(documentController);
		this.documentController.createDocument(docTitle);
	}
	
	@Test
	void createFullVisionTest() {
		String msg = "Espera-se que uma visão completa seja criada com sucesso.";
		int expectedResult = 0;
		
		int result = this.visionController.createFullVision(this.docTitle);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void createShortVisionTest() {
		String msg = "Espera-se que uma visão resumida seja criada com sucesso.";
		int expectedResult = 0;
		
		int result = this.visionController.createShortVision(this.docTitle);
		
		assertEquals(expectedResult, result, msg);
	}

	@Test
	void createPriority1VisionTest() {
		String msg = "Espera-se que uma visão de prioridade 1 seja criada com sucesso.";
		int expectedResult = 0;
		
		int result = this.visionController.createPriorityVision(this.docTitle, 1);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void createPriority5VisionTest() {
		String msg = "Espera-se que uma visão de prioridade 5 seja criada com sucesso.";
		int expectedResult = 0;
		
		int result = this.visionController.createPriorityVision(this.docTitle, 5);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void createPriority0VisionTest() {
		String msg = "Espera-se que uma visão de prioridade 0 não seja criada e "
				+ "lançe a exceção IllegalArgumentException.";

		assertThrows(
				IllegalArgumentException.class,
				() -> this
				.visionController
				.createPriorityVision(this.docTitle, 0),
				msg
			);
	}
	
	@Test
	void createPriority6VisionTest() {
		String msg = "Espera-se que uma visão de prioridade 6 não seja criada e "
				+ "lançe a exceção IllegalArgumentException.";

		assertThrows(
				IllegalArgumentException.class,
				() -> this
				.visionController
				.createPriorityVision(this.docTitle, 6),
				msg
			);
	}
	
	@Test
	void createTitleVisionTest() {
		String msg = "Espera-se que uma visão de títulos seja criada com sucesso.";
		int expectedResult = 0;
		
		int result = this.visionController.createTitleVision(this.docTitle);
		
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void showVisionTest() {
		String msg = "Espera-se que seja retornado uma lista de representações "
				+ "completas dos elementos do documento.";
		String[] expectedResult = {
				"texto exemplo\n",
				"2. Título exemplo\n",
				"- Lista\n"
				+ "- de\n"
				+ "- exemplo\n",
				"Total termos: 3\n"
				+ "- termos, de, exemplo\n"
		};
		
		Text text = new Text("texto exemplo", 3);
		Title title = new Title("Título exemplo", 1, 2, false);
		ListElement listElement = new ListElement(
				"Lista | de | exemplo",
				2,
				" | ",
				"-"
		);
		Words words = new Words(
				"termos / de / exemplo",
				5,
				" / ",
				"NENHUM"
		);
		
		Document document = this.documentController.getDocument(this.docTitle);
		document.createElement(text);
		document.createElement(title);
		document.createElement(listElement);
		document.createElement(words);
		
		int visionId = this.visionController.createFullVision(docTitle);
		
		String[] result = this.visionController.showVision(visionId);

		assertArrayEquals(expectedResult, result, msg);
	}
	
	@Test
	void showInexistentVisionTest() {
		String msg = "Espera-se que ao tentar exibir uma visão não cadastrada, seja"
				+ " lançada a exceção IllegalArgumentExceptiion.";

		assertThrows(
				IllegalArgumentException.class,
				() -> this.visionController.showVision(47),
				msg
		);
	}
}
