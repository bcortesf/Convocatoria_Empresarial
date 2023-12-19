package com.bryancfz.wishlist.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bryancfz.wishlist.apirest.models.entity.Cuenta;

public interface ICuentaDao extends JpaRepository<Cuenta, Long>{

}
