package documin;

import documin.document.DocumentController;
import documin.document.ElementController;
import documin.document.VisionController;

/** IMPORTANTE **
 * DocumentController ta cheio de responsabilidades
 * deixo document controller gerenciado elementos mesmo?
 * ou devo criar um elementController que é instanciado dentro
 * de documentController, onde documentController só vai ser
 * responsável por realizar a regra de negócio de documento
 * e pedir pro elementController
 */

/**
 * Facade representa um ponto de entrada para as demais classes do sistema.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class Facade {

	/**
	 * Controlador dos documentos
	 */
	private DocumentController documentController;

	/**
	 * Controllador dos elementos dos documentos
	 */
	private ElementController elementController;

	/**
	 * Controlador das visões
	 */
	private VisionController visionController;

	/**
	 * Constrói um Facade.
	 */
	public Facade() {
		this.documentController = new DocumentController();
		this.elementController = new ElementController(documentController);
		this.visionController = new VisionController(documentController);
	}

	/** Cria um documento a partir de um título.
	 * 
	 * @param title
	 * @return document position
	 */
	public boolean createDocument(String title) {
		boolean result = false;
		try {
			result = this.documentController.createDocument(title);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return result;
		}
		return result;
	}

	/** Cria um documento a partir de um título e limite de elementos.
	 * 
	 * @param title
	 * @param elementsSize
	 * @return document position
	 */
	public boolean createDocument(String title, int elementsSize) {
		boolean result = false;
		try {
			result = this.documentController.createDocument(title, elementsSize);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return result;
		}
		return result;
	}

	/** Deleta um documento.
	 * 
	 * @param titulo
	 */
	public void deleteDocument(String titulo) {
		try {
			this.documentController.deleteDocument(titulo);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	/** Conta os elementos de um documento.
	 * 
	 * @param titulo
	 * @return elements number
	 */
	public int countElements(String titulo) {
		int elementsNumber = 0;
		try {
			elementsNumber = this.elementController.getElementsNumber(titulo);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return elementsNumber;
	}

	/** Exibe os elementos de um documento.
	 * 
	 * @param title
	 * @return document elements
	 */
	public String[] showDocument(String title) {
		String[] documentElements = new String[0];

		try {
			documentElements = this.documentController.showDocument(title);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		return documentElements;
	}

	/** Cria um texto no documento.
	 * 
	 * @param docTitle
	 * @param value
	 * @param priority
	 * @return element position
	 */
	public int createText(String docTitle, String value, int priority) {
		int index = -1;

		try {
			index = this.elementController.createText(docTitle, value, priority);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return index;
	}

	/** Cria um título no documento.
	 * 
	 * @param docTitle
	 * @param value
	 * @param priority
	 * @param nivel
	 * @param linkavel
	 * @return element position
	 */
	public int createTitle(
			String docTitle,
			String value,
			int priority,
			int nivel,
			boolean linkavel
		) {
		int index = -1;

		try {
			index = this
					.elementController
					.createTitle(docTitle, value, priority, nivel, linkavel);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return index;
	}

	/** Cria uma lista no documento.
	 * 
	 * @param docTitle
	 * @param listValue
	 * @param priority
	 * @param spacer
	 * @param charList
	 * @return element position
	 */
	public int createList(
			String docTitle,
			String listValue,
			int priority,
			String spacer,
			String charList
		) {
		int index = -1;

		try {
			index = this.elementController.createList(
					docTitle,
					listValue,
					priority,
					spacer,
					charList
			);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return index;
	}

	/** Cria termos no documento.
	 * 
	 * @param docTitle
	 * @param wordsValue
	 * @param priority
	 * @param spacer
	 * @param rank
	 * @return element position
	 */
	public int createWords(
			String docTitle,
			String wordsValue,
			int priority,
			String spacer,
			String rank
		) {
		int index = -1;

		try {
			index = this
					.elementController
					.createWords(docTitle, wordsValue, priority, spacer, rank);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return index;
	}

	/** Pega a representação completa de um elemento do documento.
	 * 
	 * @param docTitle
	 * @param elementPosition
	 * @return full representation
	 */
	public String getFullRepresentation(String docTitle, int elementPosition) {
		String representation = "";

		try {
			representation = this
					.elementController
					.getFullRepresentation(docTitle, elementPosition);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return representation;
	}

	/** Pega a representação resumida de um elemento no documento.
	 * 
	 * @param docTitle
	 * @param elementPosition
	 * @return short representation
	 */
	public String getShortRepresentation(String docTitle, int elementPosition) {
		String representation = "";

		try {
			representation = this
					.elementController
					.getShortRepresentation(docTitle, elementPosition);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return representation;
	}

	/** Remove um elemento no documento.
	 * 
	 * @param docTitle
	 * @param elementPosition
	 * @return operetion status
	 */
	public boolean removeElement(String docTitle, int elementPosition) {
		boolean result = false;

		try {
			result = this.elementController.removeElement(docTitle, elementPosition);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return result;
	}

	/** Move um elemento para cima no documento.
	 * 
	 * @param docTitle
	 * @param elementPosition
	 */
	public void moveElementUp(String docTitle, int elementPosition) {
		try {
			this.elementController.moveElementUp(docTitle, elementPosition);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	/** Move um elemento para baixo no documento.
	 * 
	 * @param docTitle
	 * @param elementPosition
	 */
	public void moveElementDown(String docTitle, int elementPosition) {
		try {
			this.elementController.moveElementDown(docTitle, elementPosition);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	/** Cria uma visão completa do documento.
	 * 
	 * @param docTitle
	 * @return vision index
	 */
	public int createFullVision(String docTitle) {
		int result = -1;

		try {
			result = this.visionController.createFullVision(docTitle);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return result;
	}

	/** Cria uma visão resumida do documento.
	 * 
	 * @param docTitle
	 * @return vision index
	 */
	public int createShortVision(String docTitle) {
		int result = -1;

		try {
			result = this.visionController.createShortVision(docTitle);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return result;
	}

	/** Cria uma visão de prioridade do documento.
	 * 
	 * @param docTitle
	 * @param priority
	 * @return vision index
	 */
	public int createPriorityVision(String docTitle, int priority) {
		int result = -1;

		try {
			result = this.visionController.createPriorityVision(docTitle, priority);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return result;
	}

	/** Cria uma visão de títulos do documento.
	 * 
	 * @param docTitle
	 * @return vision index
	 */
	public int createTitleVision(String docTitle) {
		int result = -1;

		try {
			result = this.visionController.createTitleVision(docTitle);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return result;
	}

	/** Exibe a visão do documento.
	 * 
	 * @param visionId
	 * @return document elements representations
	 */
	public String[] showVision(int visionId) {
		String[] result = new String[0];

		try {
			result = this.visionController.showVision(visionId);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return result;
	}

}
