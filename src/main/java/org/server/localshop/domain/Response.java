package org.server.localshop.domain;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
	
	private T object;
	private List <Exception> exception = new ArrayList();
	
	
	
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	public List<Exception> getException() {
		return exception;
	}
	public void setException(List<Exception> exception) {
		this.exception = exception;
	}
	
	

}
