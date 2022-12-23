package documin.document;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Representação de um test case das listas.
 *  
 * @author Dhouglas Bandeira
 *
 */
class ListElementTest {
	
	private ListElement listElement;

	@BeforeEach
	void setUp() throws Exception {
		this.listElement = new ListElement("Lista | de | teste", 1, " | ", "->");
	}

	@Test
	void generateShortRepresentationTest() {
		String msg = "Espera-se que seja gerada uma frase com os itens da lista";
		String expectedMessage = "Lista, de, teste\n";
		
		String result = this.listElement.generateShortRepresentation();
		
		
		assertEquals(expectedMessage, result, msg);
	}
	
	@Test
	void generateFullRepresentationTest() {
		String msg = "Espera-se que seja gerada uma lista dos itens em uma String.";
		String expectedMessage = "-> Lista\n"
				+ "-> de\n"
				+ "-> teste\n";
		
		String result = this.listElement.generateFullRepresentation();
		
		
		assertEquals(expectedMessage, result, msg);
	}

}
