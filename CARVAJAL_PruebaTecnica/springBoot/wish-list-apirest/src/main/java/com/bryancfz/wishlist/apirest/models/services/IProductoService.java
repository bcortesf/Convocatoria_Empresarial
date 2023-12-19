package com.bryancfz.wishlist.apirest.models.services;

import java.util.List;

import com.bryancfz.wishlist.apirest.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll_();
	public Producto findById_(Long idProducto);
	
}
