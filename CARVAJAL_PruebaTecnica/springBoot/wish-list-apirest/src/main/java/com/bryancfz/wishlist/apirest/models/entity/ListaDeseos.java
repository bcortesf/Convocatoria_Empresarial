package com.bryancfz.wishlist.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*
 * https://stackoverflow.com/a/18288939/13837734
 * */

@Entity
@Table(name = "lista_deseo")
public class ListaDeseos implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lista_deseo")
	private Long idListaDeseo;
	
	@Column(name = "me_gusta", nullable = false)			
	private Boolean meGusta;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date fecha;
	
	
	//https://stackoverflow.com/a/18288939/13837734
	// * lista_deseo --> 1 Cliente
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente.id_cliente")
	@JsonBackReference
	private Cliente cliente;
	////////////////////////////////////////
	
	
	// * lista_deseo --> 1 Producto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto.id_producto")
	@JsonBackReference
	private Producto producto;
    //////////////////////////////////////
	
	
	/*CONSTRUCTORS*/
	public ListaDeseos() {
		super();
	}
	
	public ListaDeseos(Long idListaDeseo, Boolean meGusta, Date fecha, Cliente cliente, Producto producto) {
		super();
		this.idListaDeseo = idListaDeseo;
		this.meGusta = meGusta;
		this.fecha = fecha;
		this.cliente = cliente;
		this.producto = producto;
	}
	

	/*GETTERS SETTERS*/
	public Long getIdListaDeseo() {
		return idListaDeseo;
	}

	public void setIdListaDeseo(Long idListaDeseo) {
		this.idListaDeseo = idListaDeseo;
	}

	public Boolean getMeGusta() {
		return meGusta;
	}

	public void setMeGusta(Boolean meGusta) {
		this.meGusta = meGusta;
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}
	
	
	/*Relacion*/
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

