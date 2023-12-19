package com.bryancfz.wishlist.apirest.models.entity;



import java.io.Serializable;
import java.math.BigInteger;
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

@Entity
@Table(name = "producto")
//@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Producto  implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private BigInteger precio;
	
	@Column(name = "cantidad_stock", nullable = false)
	private int cantidadStock;
	
	@Column(name= "url_imagen",nullable = false)
	private String urlImagen;
	
	
	
	
	// 1 Producto --> * lista_deseos
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto" )
	@Column(nullable = false)
	@JsonManagedReference
	private List<ListaDeseos> deseos;
////////////////////////////////////////////////////////////
	
	
	
	/*constructors*/
	public Producto() {
		super();
	}
	
	
	public Producto(Long id, String nombre, BigInteger precio, int cantidadStock, String urlImagen,
			List<ListaDeseos> deseos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadStock = cantidadStock;
		this.urlImagen = urlImagen;
		this.deseos = deseos;
	}





	/*getters setters*/
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


	public BigInteger getPrecio() {
		return precio;
	}


	public void setPrecio(BigInteger precio) {
		this.precio = precio;
	}


	public int getCantidadStock() {
		return cantidadStock;
	}


	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}


	public String getUrlImagen() {
		return urlImagen;
	}


	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
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
