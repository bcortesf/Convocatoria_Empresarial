package com.bryancfz.wishlist.apirest.controllers.dto;



import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ErrorResponseController {

	private Map<String, Object> hashMapError;
	private String mensajeError;
	private Object objError;
	private HttpStatus httpStatusError;
	
	
	public ErrorResponseController() {	
		this.setHashMapError( new HashMap<String, Object>() );
	}
	
	public void setPropertiesHashMap(String mensaje, Object errorObj, HttpStatus httpStatusError) {
		getHashMapError().put("mensajeError", mensaje);
		getHashMapError().put("dataError" , errorObj);
		getHashMapError().put("httpStatusError" , httpStatusError);
	}

	
	public Map<String, Object> getHashMapError() {
		return hashMapError;
	}

	public void setHashMapError(Map<String, Object> hashMapError) {
		this.hashMapError = hashMapError;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public Object getObjError() {
		return objError;
	}

	public void setObjError(Object objError) {
		this.objError = objError;
	}

	public HttpStatus getHttpStatusError() {
		return httpStatusError;
	}

	public void setHttpStatusError(HttpStatus httpStatusError) {
		this.httpStatusError = httpStatusError;
	}

	
}
