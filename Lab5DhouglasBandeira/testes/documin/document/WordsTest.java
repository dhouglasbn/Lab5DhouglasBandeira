package documin.document;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class WordsTest {
	
	private Words words;
	
	@AfterEach
	void tearDown() {
		this.words = null;
	}

	@Test
	void generateAlphabeticalShortRepresentation() {
		String msg = "Espera-se que seja gerada uma representação "
				+ "resumida na ordem alfabética.";
		String expectedResult = "de / termos / teste\n";
		
		this.words = new Words(
				"Termos / de / teste",
				1,
				" / ",
				"ALFABÉTICA"
				);
		String result = this.words.generateShortRepresentation();
				
		assertEquals(expectedResult, result, msg);
	}

	@Test
	void generateAlphabeticalFullRepresentation() {
		String msg = "Espera-se que seja gerada uma representação "
				+ "completa na ordem alfabética.";
		String expectedResult = "Total termos: 4\n"
				+ "- alemanha, bolivia, brasil, frança\n";
		
		this.words = new Words(
				"Brasil / Alemanha / França / bolivia",
				1,
				" / ",
				"ALFABÉTICA"
				);
		String result = this.words.generateFullRepresentation();
				
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void generateShortRepresentation() {
		String msg = "Espera-se que seja gerada uma representação "
				+ "resumida na ordem de criação.";
		String expectedResult = "termos / de / teste\n";
		
		this.words = new Words(
				"Termos / de / teste",
				1,
				" / ",
				"NENHUM"
				);
		String result = this.words.generateShortRepresentation();
				
		assertEquals(expectedResult, result, msg);
	}
	
	
	@Test
	void generateFullRepresentation() {
		String msg = "Espera-se que seja gerada uma representação "
				+ "completa na ordem de criação.";
		String expectedResult = "Total termos: 4\n"
				+ "- brasil, alemanha, frança, bolivia\n";
		
		this.words = new Words(
				"Brasil / Alemanha / França / bolivia",
				1,
				" / ",
				"NENHUM"
				);
		String result = this.words.generateFullRepresentation();
				
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void generateLengthShortRepresentation() {
		String msg = "Espera-se que seja gerada uma representação "
				+ "resumida na ordem do tamanho da palavra.";
		String expectedResult = "termos / teste / de\n";
		
		this.words = new Words(
				"Termos / de / teste",
				1,
				" / ",
				"TAMANHO"
				);
		String result = this.words.generateShortRepresentation();
				
		assertEquals(expectedResult, result, msg);
	}
	
	@Test
	void generateLengthFullRepresentation() {
		String msg = "Espera-se que seja gerada uma representação "
				+ "completa na ordem do tamanho da palavra.";
		String expectedResult = "Total termos: 4\n"
				+ "- alemanha, bolivia, brasil, frança\n";
		
		this.words = new Words(
				"Brasil / Alemanha / França / bolivia",
				1,
				" / ",
				"TAMANHO"
				);
		String result = this.words.generateFullRepresentation();
				
		assertEquals(expectedResult, result, msg);
	}
}
