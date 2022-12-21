package documin;

import documin.document.DocumentController;
import documin.document.ElementController;

/** IMPORTANTE **
 * DocumentController ta cheio de responsabilidades
 * deixo document controller gerenciado elementos mesmo?
 * ou devo criar um elementController que é instanciado dentro
 * de documentController, onde documentController só vai ser
 * responsável por realizar a regra de negócio de documento
 * e pedir pro elementController
 */

/** Facade representa um ponto de entrada para as demais
 * classes do sistema.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class Facade {

    private DocumentController documentController;
    
    private ElementController elementController;

    public Facade() {
         this.documentController = new DocumentController();
         this.elementController = new ElementController(documentController);
    }

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
    
    public void deleteDocument(String titulo) {
    	try {
    		this.documentController.deleteDocument(titulo);			
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
    }
    
    public int countElements(String titulo) {
    	int elementsNumber = 0;
    	try {
			elementsNumber = this.elementController.getElementsNumber(titulo);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
    	return elementsNumber;
    }
    
    public String[] showDocument(String title) {
    	String[] documentElements = new String[0];
    	
    	try {
    		documentElements = this.documentController.showDocument(title);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
    	
    	return documentElements;
    }

    public int createText(String docTitle, String value, int priority) {
    	int index = -1;
    	  
    	try {
			index = this.elementController.createText(docTitle, value, priority);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
    	return index;
      }
      
    public int createTitle(
    	String docTitle,
    	String value,
    	int priority,
    	int nivel,
    	boolean linkavel
    	) {
    	int index = -1;
    	  
    	try {
			index = this.elementController.createTitle(
					docTitle,
					value,
					priority,
					nivel,
					linkavel
					);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
    	return index;
      }
      
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
    
    public int createWords(
    		String docTitle,
    		String wordsValue,
    		int priority,
    		String spacer,
    		String rank
    		) {
  	  int index = -1;
	  
  	  try {
			index = this.elementController.createWords(
					docTitle,
					wordsValue,
					priority,
					spacer,
					rank
					);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
  	  return index;
    }
    
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
    
    public boolean removeElement(String docTitle, int elementPosition) {
    	  boolean result = false;
    	  
      	  try {
    			result = this
    					.elementController
    					.removeElement(docTitle, elementPosition);
    		} catch (Exception exception) {
    			System.out.println(exception.getMessage());
    		}
      	  return result;
        }
    
    public void moveElementUp(String docTitle, int elementPosition) {
    	try {
    		this
    			.elementController
    			.moveElementUp(docTitle, elementPosition);
    		} catch (Exception exception) {
    			System.out.println(exception.getMessage());
    		}
    }

    public void moveElementDown(String tituloDoc, int elementoPosicao) {
    	try {
    		this
    			.elementController
    			.moveElementDown(tituloDoc, elementoPosicao);
    		} catch (Exception exception) {
    			System.out.println(exception.getMessage());
    		}
    }

}
