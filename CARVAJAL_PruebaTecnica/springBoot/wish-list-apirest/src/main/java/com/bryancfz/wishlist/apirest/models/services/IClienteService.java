package com.bryancfz.wishlist.apirest.models.services;

import java.util.List;

import com.bryancfz.wishlist.apirest.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll_();
	public Cliente findById_(Long idCliente);
	
}
