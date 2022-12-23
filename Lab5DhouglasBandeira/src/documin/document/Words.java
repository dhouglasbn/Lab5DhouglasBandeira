package documin.document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/** Representação do elemento de termos.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class Words extends Element {
	
	/**
	 * espaçador do valor do elemento
	 */
	private String spacer;
	
	/**
	 * ordem dos termos
	 */
	private String rank;

	/** Constrói o elemento de termos.
	 * 
	 * @param value
	 * @param priority
	 * @param spacer
	 * @param rank
	 */
	public Words(String value, int priority, String spacer, String rank) {
		super(value, priority);
		this.spacer = spacer;
		this.rank = rank;
	}
	
	@Override
	public String generateFullRepresentation() {
		String[] words = this.getSortedWords();
		String representation = "Total termos: " + words.length + "\n- ";
		for (int index = 0; index < words.length; index++) {
			representation += words[index];
			if (index != words.length - 1) {
				representation += ", ";
			}
		}
		representation += "\n";
		return representation;
	}
	
	@Override
	public String generateShortRepresentation() {
		String [] words = this.getSortedWords();
		String representation = "";
		for (int index = 0; index < words.length; index++) {
			representation += words[index];
			if (index != words.length - 1) {
				representation += this.spacer;
			}
		}
		representation += "\n";
		return representation;
	}
	
	/** Retorna uma lista ordenada dos termos pelo rank.
	 * 
	 * @return sorted words array
	 */
	private String[] getSortedWords() {
		String[] words = this.getWordsArray();
		
		for (int index = 0; index < words.length; index++) {
			words[index] = words[index].toLowerCase();
		}
		
		if (this.rank == "NENHUM") return words;	
		if (this.rank == "ALFABÉTICA") Arrays.sort(words);
		if (this.rank == "TAMANHO") {
			Arrays.sort(words, Comparator.comparing(String::length).reversed());
		}
		return words;
	}
	
	/** Retorna um array das palavras do valor do elemento.
	 * 
	 * @return words array
	 */
	private String[] getWordsArray() {
		String[] array = this.value.split(this.spacer);
		ArrayList<String> result = new ArrayList<>();
		for (String item: array) {
			if (!item.equals(this.spacer.trim())) {
				result.add(item);
			};
		}
		
		return result.toArray(new String[] {});
	}
}
