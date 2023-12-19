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
import com.bryancfz.wishlist.apirest.models.entity.Producto;
import com.bryancfz.wishlist.apirest.models.services.IProductoService;


@RestController
@RequestMapping("/api")
public class ProductoRestController {

	private ErrorResponseController errorResponse = new ErrorResponseController();
	private OkResponseController okResponse = new OkResponseController();
	
	@Autowired
	private IProductoService productoService;
	
	
	@GetMapping("/producto/showAll")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> showAll() {
		List<Producto> lista;
		try {
			lista = productoService.findAll_();	
			this.okResponse.setPropertiesHashMap("ok", lista);			
		} catch (DataAccessException e) {
			this.errorResponse.setPropertiesHashMap("No se puede consultar los productos", e, HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String,Object>>(this.errorResponse.getHashMapError(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Map<String, Object>>(this.okResponse.getHashMapOk(), HttpStatus.OK);	    
	}
	
}
