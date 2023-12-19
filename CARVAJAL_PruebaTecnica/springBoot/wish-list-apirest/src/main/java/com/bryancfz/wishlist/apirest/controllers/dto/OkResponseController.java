package com.bryancfz.wishlist.apirest.controllers.dto;



import java.util.HashMap;
import java.util.Map;

public class OkResponseController {

	private Map<String, Object> hashMapOk;
	private String mensajeOk;
	private Object dataOk;
	
	public OkResponseController() {	
		this.setHashMapOk( new HashMap<String, Object>() );
	}
	

	public Map<String, Object> getHashMapOk() {
		return hashMapOk;
	}

	public void setHashMapOk(Map<String, Object> hashMapOk) {
		this.hashMapOk = hashMapOk;
	}
	
	public void setPropertiesHashMap(String mensaje, Object respuesta) {
		this.getHashMapOk().put("mensajeOk" , mensaje);
		this.getHashMapOk().put("dataOK", respuesta);
	}

	//
	public String getMessageOk() {
		return mensajeOk;
	}

	public void setMessage(String mensajeOk) {
		this.mensajeOk = mensajeOk;
	}

	public Object getDataOk() {
		return dataOk;
	}

	public void setDataOk(Object dataOk) {
		this.dataOk = dataOk;
	}
	
}
