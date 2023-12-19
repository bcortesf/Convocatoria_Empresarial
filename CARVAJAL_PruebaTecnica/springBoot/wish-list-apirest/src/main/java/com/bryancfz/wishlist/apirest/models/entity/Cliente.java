package com.bryancfz.wishlist.apirest.models.entity;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference; 



/**
 * https://www.baeldung.com/jpa-joincolumn-vs-mappedby
 * https://www.baeldung.com/jpa-join-column
* @author BryanCFz
*
*/
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	

	// 1 Cliente --> * Cuenta
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	@Column(nullable = false)
	@JsonManagedReference
	private List<Cuenta> cuentas;
    ////////////////////////////////////////////////////////////	
	
	
	// 1 Cliente --> * lista_deseos
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente" )
	@Column(nullable = false, name = "deseos")
	@JsonManagedReference
	private List<ListaDeseos> deseos;
	
	
	
	/*Constructors*/
	public Cliente() {
		super();
	}
	
	
	public Cliente(Long id, String nombre, List<Cuenta> cuentas, List<ListaDeseos> deseos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cuentas = cuentas;
		this.deseos = deseos;
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


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Cuenta> getCuentas() {
		return cuentas;
	}


	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}


	public List<ListaDeseos> getDeseos() {
		return deseos;
	}


	public void setDeseos(List<ListaDeseos> deseos) {
		this.deseos = deseos;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
