package com.bryancfz.wishlist.apirest.models.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.bryancfz.wishlist.apirest.models.dao.IListaDeseosDao;
import com.bryancfz.wishlist.apirest.models.dao.IRecordWishListDao;
import com.bryancfz.wishlist.apirest.models.entity.Cliente;
import com.bryancfz.wishlist.apirest.models.entity.ListaDeseos;
import com.bryancfz.wishlist.apirest.models.entity.Producto;
import com.bryancfz.wishlist.apirest.models.entity.RecordWishList;


@Service
public class ListaDeseoServiceImpl implements IListaDeseoService{

//	public IProductoDao productoDao;
//	public IClienteDao clienteDao;
	
	@Autowired
	public IListaDeseosDao listaDeseosDao;
	
	@Autowired
	ProductoServiceImpl productoServiceImpl;

	@Autowired
	public ClienteServiceImpl clienteServiceImpl;
	
	
	@Autowired 
	IRecordWishListDao recordWishListDao;

	
	@Override
	@Transactional(readOnly = true)
	public List<ListaDeseos> findAll_() {
		return  (List<ListaDeseos>) listaDeseosDao.findAll();
	}


	@Override
	@Transactional
	public void deleteById(Long idListaDeseo) {
				
		Optional<ListaDeseos> findWishList = listaDeseosDao.findById(idListaDeseo);
		ListaDeseos wish =  findWishList.get();
		
		Producto producto = wish.getProducto();
		Cliente cliente = wish.getCliente();
		wish.setMeGusta(false);
		this.addHistorialDeseos(cliente, producto, false);
		
		
		listaDeseosDao.deleteById(idListaDeseo);
	}


	@Override
	@Transactional
	public ListaDeseos add_(Long idProducto) {		
		Producto producto = this.productoServiceImpl.findById_(idProducto);
		Cliente cliente = this.clienteServiceImpl.findById_( Long.valueOf("1013") );
		
		ListaDeseos wish = new ListaDeseos();
		wish.setFecha( new java.util.Date() );
		wish.setMeGusta(true);
		wish.setProducto(producto);
		wish.setCliente(cliente);
		
		//->       Guardarhistorico
		this.addHistorialDeseos(cliente, producto, true);
		///////////////////////////////////
		
		return listaDeseosDao.save(wish);
	}
	
	public void addHistorialDeseos(Cliente cliente, Producto producto, boolean meGusta) {
		RecordWishList historial = new RecordWishList();
		historial.setNombreCliente(cliente.getNombre());
		historial.setNombreProducto(producto.getNombre());
		historial.setMeGusta(meGusta);
		historial.setFechaHora( LocalDateTime.now() );
		recordWishListDao.save(historial);
	}

}
