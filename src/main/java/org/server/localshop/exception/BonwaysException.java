package org.server.localshop.exception;

public class BonwaysException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BonwaysException() {
		super();
	}
	public  BonwaysException(String msg)   {
		super(msg);
	}
	public BonwaysException(String msg, Exception e)  {
		super(msg, e);
	}
}
