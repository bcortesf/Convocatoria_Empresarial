package com.bryancfz.wishlist.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bryancfz.wishlist.apirest.models.entity.ListaDeseos;

public interface IListaDeseosDao extends JpaRepository<ListaDeseos, Long> {

}