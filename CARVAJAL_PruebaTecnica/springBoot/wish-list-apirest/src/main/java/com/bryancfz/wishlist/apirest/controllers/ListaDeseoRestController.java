package com.bryancfz.wishlist.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bryancfz.wishlist.apirest.controllers.dto.ErrorResponseController;
import com.bryancfz.wishlist.apirest.controllers.dto.OkResponseController;
import com.bryancfz.wishlist.apirest.models.entity.ListaDeseos;
import com.bryancfz.wishlist.apirest.models.entity.Producto;
import com.bryancfz.wishlist.apirest.models.services.IListaDeseoService;


@RestController
//@RequestMapping("/api")
@RequestMapping(value = "/api", produces = "application/json", method = {RequestMethod.GET ,RequestMethod.POST}) 
public class ListaDeseoRestController {
	
	private ErrorResponseController errorResponse = new ErrorResponseController();
	private OkResponseController okResponse = new OkResponseController();
	
	@Autowired
	private IListaDeseoService listaDeseoService;
	
	
	@GetMapping("/wishlist/showAll")
	public ResponseEntity<?> showAll() {
		List<ListaDeseos> lista;
		try {
			lista = listaDeseoService.findAll_();	
			this.okResponse.setPropertiesHashMap("ok", lista);			
		} catch (DataAccessException e) {
			this.errorResponse.setPropertiesHashMap("No se puede consultar la lista de deseos", e, HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String,Object>>(this.errorResponse.getHashMapError(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Map<String, Object>>(this.okResponse.getHashMapOk(), HttpStatus.OK);	    
	}
	
	@DeleteMapping("/wishlist/delete/{idListaDeseo}")
	public ResponseEntity<?> destroy(@PathVariable Long idListaDeseo) {
		Map<String,Object> lista = new HashMap<String, Object>();
		try {
			listaDeseoService.deleteById(idListaDeseo);	
			lista.put("mensajeOk", "Registro eliminado");
			lista.put("dataOK", null);
		} catch (DataAccessException e) {
			this.errorResponse.setPropertiesHashMap("No se puede consultar la lista de deseos", e, HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String,Object>>(this.errorResponse.getHashMapError(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Map<String, Object>>(lista, HttpStatus.OK);	    
	}
	

	@PostMapping("/wishlist/create2")
	public ResponseEntity<?> create(@RequestBody Producto producto) {
		ListaDeseos wishNew = null;
		try {
			wishNew = listaDeseoService.add_(producto.getId());
		} catch (DataAccessException e) {
			this.errorResponse.setPropertiesHashMap(
					"Error al realizar el insert en la base de datos", 
					e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()), //dato nulo, campo duplicado, cualquier cosa
					HttpStatus.INTERNAL_SERVER_ERROR);
						
			return new ResponseEntity<Map<String, Object>>(this.errorResponse.getHashMapError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		Map<String, Object> okResponseHashMap = new HashMap<String, Object>();
		okResponseHashMap.put("mensajeOk", "El deseo ha sido creado con éxito!");
		okResponseHashMap.put("dataOk", wishNew);
		return new ResponseEntity<Map<String, Object>>(okResponseHashMap, HttpStatus.CREATED);
	}
	
	@PostMapping("/wishlist/create/{idProducto}")
	public ResponseEntity<?> create(@PathVariable Long idProducto) {
		ListaDeseos wishNew = null;
		try {
			wishNew = listaDeseoService.add_(idProducto);
		} catch (DataAccessException e) {
			this.errorResponse.setPropertiesHashMap(
					"Error al realizar el insert en la base de datos", 
					e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()), //dato nulo, campo duplicado, cualquier cosa
					HttpStatus.INTERNAL_SERVER_ERROR);
						
			return new ResponseEntity<Map<String, Object>>(this.errorResponse.getHashMapError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		Map<String, Object> okResponseHashMap = new HashMap<String, Object>();
		okResponseHashMap.put("mensajeOk", "El deseo ha sido creado con éxito!");
		okResponseHashMap.put("dataOk", wishNew);
		return new ResponseEntity<Map<String, Object>>(okResponseHashMap, HttpStatus.CREATED);
	}

}
