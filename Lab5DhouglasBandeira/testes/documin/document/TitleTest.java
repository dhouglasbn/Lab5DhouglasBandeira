package documin.document;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Representação de um test case dos títulos.
 *  
 * @author Dhouglas Bandeira
 *
 */
class TitleTest {
	
	private Title title;

	@BeforeEach
	void setUp() throws Exception {
		this.title = new Title("Título de teste", 1, 1, true);
	}

	@Test
	void generateShortRepresentation() {
		String msg = "Espera-se que a representação resumida seja igual ao esperado.";
		
		String expectedMessage = "1. Título de teste\n";
		
		String result = this.title.generateShortRepresentation();
		
		assertEquals(expectedMessage, result, msg);
	}
	
	@Test
	void generateFullLinkableRepresentation() {
		String msg = "Espera-se que a representação completa de um título linkável seja igual ao esperado.";
		
		String expectedMessage = "1. Título de teste -- 1-TÍTULODETESTE\n";
		
		String result = this.title.generateFullRepresentation();
		
		assertEquals(expectedMessage, result, msg);
	}
	
	@Test
	void generateFullNotLinkableRepresentation() {
		String msg = "Espera-se que a representação completa de um título linkável seja igual ao esperado.";
		
		String expectedMessage = "1. Título de teste\n";
		
		this.title = new Title("Título de teste", 1, 1, false);
		
		String result = this.title.generateFullRepresentation();
		
		assertEquals(expectedMessage, result, msg);
	}
}
