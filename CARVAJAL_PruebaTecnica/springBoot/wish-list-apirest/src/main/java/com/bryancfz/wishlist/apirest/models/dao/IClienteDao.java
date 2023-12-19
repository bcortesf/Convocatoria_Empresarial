package com.bryancfz.wishlist.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bryancfz.wishlist.apirest.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{

}
