/**
 * @author Team #3
 *
 * @created 07/09/16 
 */
package com.i2i.villapursuit.exception;

@SuppressWarnings("serial")
public class VillaPursuitException extends Exception {
	
    public VillaPursuitException(String message) {
        super(message);
    }
    
    public VillaPursuitException(String message, Throwable exceptionCause) {
        super(message);
    }
}