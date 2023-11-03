package com.demo.exception;

import java.util.logging.Logger;

/**
*
*
* 
*/
public class CredException extends RuntimeException{
	static Logger log=Logger.getLogger(CredException.class.getName());
	/**
	*
	*
	* 
	*/
	    public CredException(String message) {
	        super(message);
			log.info("CredException occured");
	    }
	}

