package documin.document;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Representação de um test case dos textos.
 *  
 * @author Dhouglas Bandeira
 *
 */
class TextTest {
	
	private Text text;

	@BeforeEach
	void setUp() throws Exception {
		this.text = new Text("Texto teste.", 1);
	}

	@Test
	void getFullRepresentation() {
		String msg = "Espera-se que a representação completa seja igual ao valor esperado.";
		
		String expectedValue = "Texto teste.\n";
		
		assertEquals(expectedValue, this.text.generateFullRepresentation(), msg);
	}
	
	@Test
	void getShortRepresentation() {
		String msg = "Espera-se que a representação resumida seja igual ao valor esperado.";
		
		String expectedValue = "Texto teste.\n";
		
		assertEquals(expectedValue, this.text.generateShortRepresentation(), msg);
	}

}
