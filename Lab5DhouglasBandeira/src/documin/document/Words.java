package documin.document;

import java.util.ArrayList;
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
		for (int index = 0; index < words.length; index++) {
			representation += words[index];
			if (index != words.length - 1) {
				representation += ", ";
			}
		}
		representation += "\n";
		return representation;
	}
	
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
