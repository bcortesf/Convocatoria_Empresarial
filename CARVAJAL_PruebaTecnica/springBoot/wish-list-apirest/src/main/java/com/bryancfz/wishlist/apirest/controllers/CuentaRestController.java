package com.bryancfz.wishlist.apirest.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bryancfz.wishlist.apirest.controllers.dto.ErrorResponseController;
import com.bryancfz.wishlist.apirest.controllers.dto.OkResponseController;
import com.bryancfz.wishlist.apirest.models.entity.Cuenta;
import com.bryancfz.wishlist.apirest.models.services.ICuentaService;

@RestController
@RequestMapping("/api")
public class CuentaRestController {
	
	private ErrorResponseController errorResponse = new ErrorResponseController();
	private OkResponseController okResponse = new OkResponseController();
	
	@Autowired
	private ICuentaService cuentaService;
	
	
	@GetMapping("/cuenta/showAll")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> showAll() {
		List<Cuenta> lista;
		try {
			lista = cuentaService.findAll_();	
			this.okResponse.setPropertiesHashMap("ok", lista);			
		} catch (DataAccessException e) {
			this.errorResponse.setPropertiesHashMap("No se puede consultar la lista de cuentas", e, HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String,Object>>(this.errorResponse.getHashMapError(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Map<String, Object>>(this.okResponse.getHashMapOk(), HttpStatus.OK);	    
	}

}
