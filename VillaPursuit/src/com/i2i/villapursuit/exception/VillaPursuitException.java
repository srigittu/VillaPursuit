// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved

package com.i2i.villapursuit.exception;

/**
 * <p>
 * Class which fetches request. 
 * Handles runtime errors so that normal flow of the application can be maintained.
 * </p>
 *
 * @author Team #3
 *
 * @created 07/09/16 
 * 
 */
@SuppressWarnings("serial")
public class VillaPursuitException extends Exception {
	
    public VillaPursuitException(String message) {
        super(message);
    }
    
    public VillaPursuitException(String message, Throwable exceptionCause) {
        super(message);
    }
}