package com.bryancfz.wishlist.apirest.models.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;


@Entity
@Table(name = "record_wishlist")
public class RecordWishList implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_record_wish")
	private Long idRecordWish;
	
	@Column(name = "nombre_cliente", nullable = false)			
	private String nombreCliente;
	
	@Column(name = "nombre_producto", nullable = false)			
	private String nombreProducto;
	
	@Column(name = "me_gusta", nullable = false)			
	private Boolean meGusta;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]") //-> [], formato para milisegundos no obligatorios
	@JsonSerialize(using = LocalDateTimeSerializer.class)                                        //->Para eliminar de (typeScript o postman) a la DB
	@Column(name = "fecha_hora")	
	private LocalDateTime fechaHora;
	
		
		
	
	/*CONSTRUCTORS*/
	
	
	public RecordWishList() {
		super();
	}
	
	public RecordWishList(Long idRecordWish, String nombreCliente, String nombreProducto, Boolean meGusta,
			LocalDateTime fechaHora) {
		super();
		this.idRecordWish = idRecordWish;
		this.nombreCliente = nombreCliente;
		this.nombreProducto = nombreProducto;
		this.meGusta = meGusta;
		this.fechaHora = fechaHora;
	}

	/*GETTERS SETTERS*/
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	public Long getIdRecordWish() {
		return idRecordWish;
	}

	public void setIdRecordWish(Long idRecordWish) {
		this.idRecordWish = idRecordWish;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Boolean getMeGusta() {
		return meGusta;
	}

	public void setMeGusta(Boolean meGusta) {
		this.meGusta = meGusta;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
