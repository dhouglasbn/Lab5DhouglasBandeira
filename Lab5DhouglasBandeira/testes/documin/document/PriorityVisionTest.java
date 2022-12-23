package documin.document;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Representação de um test case das visões dee
 *  prioridade.
 *  
 * @author Dhouglas Bandeira
 *
 */
class PriorityVisionTest {

	private PriorityVision priorityVision;
	
	private Document document;

	@BeforeEach
	void setUp() throws Exception {
		this.document = new Document("Documento de teste");
		this.priorityVision = new PriorityVision(document, 3);
	}

	@Test
	void generateRepresentationTest() {
		String msg = "Espera-se que seja retornado as representações completas"
				+ "dos elementos de prioridade 3 ou mais do documento";
		String[] expectedResult = {
				"texto exemplo\n",
				"Total termos: 3\n"
				+ "- termos, de, exemplo\n"
		};
		
		Text text = new Text("texto exemplo", 3);
		Title title = new Title("Título exemplo", 1, 1, false);
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
		
		this.document.createElement(text);
		this.document.createElement(title);
		this.document.createElement(listElement);
		this.document.createElement(words);
		
		String[] result = this.priorityVision.generateRepresentation();

		assertArrayEquals(expectedResult, result, msg);
	}
}
