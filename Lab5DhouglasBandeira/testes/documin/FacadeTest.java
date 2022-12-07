package documin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FacadeTest {
	
	private Facade facade;
	
	@BeforeEach
	void setUp() {
		this.facade = new Facade();
	}
	

	@Test
	void createDocumentTest() {
		String msg = "Espera-se que um documento seja criado com sucesso";
		
		boolean result = this.facade.createDocument("Documento teste");
		
		assertTrue(result, msg);
	}
	
	@Test
	void createLimitedDocumentTest() {
		String msg = "Espera-se que um documento com limite de elementos seja criado com sucesso";
		
		boolean result = this.facade.createDocument("Documento teste", 2);
		
		assertTrue(result, msg);
	}
	
	@Test
	void createAlreadyExistentDocumentTest() {
		String msg = "Espera-se que um documento de titulo já existente não seja criado.";
		
		this.facade.createDocument("Documento teste");
		boolean result = this.facade.createDocument("Documento teste");
		
		assertFalse(result, msg);
	}
	
	@Test
	void createDocumentWithoutNameTest() {
		String msg = "Espera-se que um documento de titulo já existente não seja criado.";
		
		boolean result = this.facade.createDocument("");
		
		// assertThrowsExactly(IllegalArgumentException, this.facade.createDocument("  "));
	}
}
