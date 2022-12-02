package documin.document;

import java.util.Arrays;
import java.util.Comparator;

public class Words extends Element {
	
	private String spacer;
	
	private String rank;

	public Words(String value, int priority, String spacer, String rank) {
		super(value, priority);
		this.spacer = spacer;
		this.rank = rank;
	}
	
	public String generateFullRepresentation() {
		String[] words = this.getSortedWords();
		String representation = "Total termos: " + words.length + "\n- ";
		for (String word: words) {
			representation += word + ", ";
		}
		representation += "\n";
		return representation;
	}
	
	public String generateShortRepresentation() {
		return null;
	}
	
	private String[] getSortedWords() {
		String[] words = this.value.split(this.spacer);
		
		if (this.rank == "NENHUM") return words;	
		for (int index = 0; index < words.length; index++) {
			words[index] = words[index].toLowerCase();
		}
		
		if (this.rank == "ALFABÉTICA") Arrays.sort(words);
		if (this.rank == "TAMANHO") {
			Arrays.sort(words, Comparator.comparing(String::length));
		}
		
		for (int index = 0; index < words.length; index++) {
			words[index] = words[index].substring(0, 1).toUpperCase() + words[index].substring(1);
		}
		return words;
	}
}
