package documin.document;

import java.util.ArrayList;

/** Representação de um elemento lista.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class ListElement extends Element {
	
	/**
	 * espaçador do valor do elemento
	 */
	private String spacer;
	
	/** 
	 * caractere que formata a lista
	 */
	private String charList;

	/** Constrói uma lista.
	 * 
	 * @param value
	 * @param priority
	 * @param spacer
	 * @param charList
	 */
	public ListElement(String value, int priority, String spacer, String charList) {
		super(value, priority);
		this.spacer = spacer;
		this.charList = charList;
	}
	
	@Override
	public String generateFullRepresentation() {
		String representation = "";
		String[] list = this.getWordsArray();
		
		for(int index = 0; index < list.length; index++) {
			representation += this.charList + " " + list[index] + "\n";
		}
		return representation;
	}
	
	@Override
	public String generateShortRepresentation() {
		String representation = "";
		String[] wordsList = this.getWordsArray();
		
		for(int index = 0; index < wordsList.length; index++) {
			representation += wordsList[index];
			if (index != wordsList.length - 1) {
				representation += ", ";
			}
		}
		representation += "\n";
		return representation;
	}
	
	/** Pega o valor do elemento e gera um array de palavras.
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
