package com.bryancfz.wishlist.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bryancfz.wishlist.apirest.models.dao.IClienteDao;
import com.bryancfz.wishlist.apirest.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService
{
	
	@Autowired
	private IClienteDao clienteDao;

	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll_() {
		return (List<Cliente>)this.clienteDao.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public Cliente findById_(Long idCliente) {
		return clienteDao.getById(idCliente);
	}

}
