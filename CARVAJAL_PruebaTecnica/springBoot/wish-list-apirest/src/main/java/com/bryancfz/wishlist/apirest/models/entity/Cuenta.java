package com.bryancfz.wishlist.apirest.models.entity;



import java.io.Serializable;
import java.time.LocalDateTime;
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
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer; 



/**
* @author BryanCFz
*
*/
@Entity
@Table(name = "cuenta")
public class Cuenta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cuenta")
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String correo;
	
	@Column(nullable = false)
	private String contrasena;	
		
	@Column(name = "creado_en")
	@Temporal(TemporalType.DATE)
	private java.util.Date creadoEn;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]") //-> [], formato para milisegundos no obligatorios
	@JsonSerialize(using = LocalDateTimeSerializer.class)     //->Para eliminar de (typeScript o postman) a la DataBase
	@Column(name = "ultimo_login")	
	private LocalDateTime ultimoLogin;
	
	
	
	
	// * Cuenta --> 1 Cliente
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente.id_cliente")
	@JsonBackReference
	private Cliente cliente;
	
	
	
		
	/*Constructors*/
	public Cuenta() {
		super();
	}
	
	
	public Cuenta(Long id, String correo, String contrasena, Date creadoEn, LocalDateTime ultimoLogin,
			Cliente cliente) {
		super();
		this.id = id;
		this.correo = correo;
		this.contrasena = contrasena;
		this.creadoEn = creadoEn;
		this.ultimoLogin = ultimoLogin;
		this.cliente = cliente;
	}





	/* SETTERS AND GETTERS */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public java.util.Date getCreadoEn() {
		return creadoEn;
	}


	public void setCreadoEn(java.util.Date creadoEn) {
		this.creadoEn = creadoEn;
	}


	public LocalDateTime getUltimoLogin() {
		return ultimoLogin;
	}


	public void setUltimoLogin(LocalDateTime ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
