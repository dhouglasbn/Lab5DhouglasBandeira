package documin.document;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Representação de um test case das visões
 *  completas.
 *  
 * @author Dhouglas Bandeira
 *
 */
class FullVisionTest {

	private FullVision fullVision;
	
	private Document document;

	@BeforeEach
	void setUp() throws Exception {
		this.document = new Document("Documento de teste");
		this.fullVision = new FullVision(document);
	}

	@Test
	void generateRepresentationTest() {
		String msg = "Espera-se que seja retornado as representações completas"
				+ "dos elementos do documento";
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
		
		this.document.createElement(text);
		this.document.createElement(title);
		this.document.createElement(listElement);
		this.document.createElement(words);
		
		String[] result = this.fullVision.generateRepresentation();

		assertArrayEquals(expectedResult, result, msg);
	}
}
