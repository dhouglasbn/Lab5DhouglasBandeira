package documin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class FacadeTest {
	
	private Facade facade;
	
	@BeforeEach
	void setUp() {
		this.facade = new Facade();
	}
	
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	public static final String BLANK_TITLE_MSG = "TÍTULO NÃO PODE SER VAZIO";

	@Test
	void createDocumentTest() {
		String msg = "Espera-se que um documento seja criado com sucesso";
		
		boolean result = this.facade.createDocument("Documento teste");
		assertTrue(result, msg);
	}
	
	@Test
	void createLimitedDocumentTest() {
		String msg = "Espera-se que um documento com limite de elementos "
				+ "seja criado com sucesso";
		
		boolean result = this.facade.createDocument("Documento teste", 2);
		
		assertTrue(result, msg);
	}
	
	@Test
	void createBlankTitleDocumentTest() {
		String msg = "Espera-se que um documento de titulo vazio não seja criado.";
		boolean result = false;
		
		this.facade.createDocument("Documento teste");

		expectedException.expect(Exception.class);
		expectedException.expectMessage(BLANK_TITLE_MSG);
		
		result = this.facade.createDocument("  ");
		assertFalse(result, msg);
	}
	
	@Test
	void createAlreadyExistentLimitedDocumentTest() {
		String msg = "Espera-se que um documento limitado de titulo vazio "
				+ "não seja criado.";
		boolean result = false;
		
		this.facade.createDocument("Documento teste");

		expectedException.expect(Exception.class);
		expectedException.expectMessage(BLANK_TITLE_MSG);
		
		result = this.facade.createDocument("  ", 2);
		assertFalse(result, msg);
	}
	
	@Test
	void deleteDocumentTest() {
		String msg = "Se após deletar um documento, a criação de outro de mesmo "
				+ "título for bem sucedida, a remoção aconteceu com sucesso.";
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		this.facade.deleteDocument(docTitle);
		boolean result = this.facade.createDocument(docTitle);
		
		assertTrue(result, msg);
	}
	
	@Test
	void deleteBlankTitleDocumentTest() {
		String docTitle = "Documento teste";
		
		this.facade.createDocument(docTitle);
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage(BLANK_TITLE_MSG);
		
		this.facade.deleteDocument("  ");
	}
}
