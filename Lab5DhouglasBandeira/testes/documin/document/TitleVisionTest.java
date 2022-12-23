package documin.document;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TitleVisionTest {
	private TitleVision titleVision;
	
	private Document document;

	@BeforeEach
	void setUp() throws Exception {
		this.document = new Document("Documento de teste");
		this.titleVision = new TitleVision(document);
	}

	@Test
	void generateRepresentationTest() {
		String msg = "Espera-se que seja retornado as representações completas"
				+ "dos elementos do documento";
		String[] expectedResult = {
				"2. Título exemplo\n"
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
		
		String[] result = this.titleVision.generateRepresentation();

		assertArrayEquals(expectedResult, result, msg);
	}
}
