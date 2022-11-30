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
        return this.documentController.createDocument(title);
    }

}
