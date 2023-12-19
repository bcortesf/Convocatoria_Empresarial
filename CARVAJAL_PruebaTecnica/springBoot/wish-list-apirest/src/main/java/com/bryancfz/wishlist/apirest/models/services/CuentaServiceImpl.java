package com.bryancfz.wishlist.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bryancfz.wishlist.apirest.models.dao.ICuentaDao;
import com.bryancfz.wishlist.apirest.models.entity.Cuenta;


@Service
public class CuentaServiceImpl implements ICuentaService{
	
	@Autowired
	private ICuentaDao cuentaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> findAll_() {
		return (List<Cuenta>)this.cuentaDao.findAll();
	}

}
