package com.bryancfz.wishlist.apirest.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bryancfz.wishlist.apirest.controllers.dto.ErrorResponseController;
import com.bryancfz.wishlist.apirest.controllers.dto.OkResponseController;
import com.bryancfz.wishlist.apirest.models.entity.RecordWishList;
import com.bryancfz.wishlist.apirest.models.services.IRecordWishListService;

@RestController
@RequestMapping("/api")
public class RecordWishListRestController {
	
	private ErrorResponseController errorResponse = new ErrorResponseController();
	private OkResponseController okResponse = new OkResponseController();
	
	@Autowired
	private IRecordWishListService recordWishListService;
	
	
	@GetMapping("/recordwishlist/showAll")
	public ResponseEntity<?> showAll() {
		List<RecordWishList> lista;
		try {
			lista = recordWishListService.findAll_();	
			this.okResponse.setPropertiesHashMap("ok", lista);			
		} catch (DataAccessException e) {
			this.errorResponse.setPropertiesHashMap("No se puede consultar el historial de deseos", e, HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String,Object>>(this.errorResponse.getHashMapError(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Map<String, Object>>(this.okResponse.getHashMapOk(), HttpStatus.OK);	    
	}

}
