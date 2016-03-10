/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.exception;

/**
 *
 * @author ok
 */
public class ExceptionAdresseEmailDejaUtilisee extends Exception {

    /**
     * Creates a new instance of <code>NewException</code> without detail
     * message.
     */
    public ExceptionAdresseEmailDejaUtilisee() {
    }

    /**
     * Constructs an instance of <code>NewException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionAdresseEmailDejaUtilisee(String msg) {
        super(msg);
    }
}
