package documin;

import documin.document.DocumentController;

/** IMPORTANTE **
 * document seria um pakcage dentro de documin?
 */

/** Facade representa um ponto de entrada para as demais
 * classes do sistema.
 * 
 * @author Dhouglas Bandeira
 *
 */
public class Facade {

    private DocumentController documentController;

    public Facade() {
         this.documentController = new DocumentController();
    }

    public boolean createDocument(String title) {
    	boolean result = false;
    	try {
    		result = this.documentController.createDocument(title);
		} catch (IllegalArgumentException exception) {
			System.out.println("O DOCUMENTO NÃO TEM NOME!");
		}
    	return result;
    }
    
    public boolean createDocument(String title, int elementsSize) {
    	boolean result = false;
    	try {
    		result = this.documentController.createDocument(title, elementsSize);
		} catch (IllegalArgumentException exception) {
			System.out.println("O DOCUMENTO NÃO TEM NOME!");
		}
    	return result;
    }
    
    public void deleteDocument(String titulo) {
    	this.documentController.deleteDocument(titulo);
    }
    
    public int countElements(String titulo) {
    	return 0;
    }
    
    public String[] showDocument(String titulo) {
    	return new String[] {};
    }


}
