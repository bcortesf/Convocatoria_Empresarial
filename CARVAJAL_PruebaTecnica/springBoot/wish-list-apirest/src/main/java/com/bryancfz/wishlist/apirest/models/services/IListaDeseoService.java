package com.bryancfz.wishlist.apirest.models.services;

import java.util.List;

import com.bryancfz.wishlist.apirest.models.entity.ListaDeseos;



public interface IListaDeseoService {
	public List<ListaDeseos> findAll_();
	public void deleteById(Long idListaDeseo);
	public ListaDeseos add_(Long idProducto);
}
