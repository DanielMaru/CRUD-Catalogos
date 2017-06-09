
package net.codejava.spring.model;

public class Productobanco {
	private int id;
	private String nom_productos;
	private String tipo;
	private String estdo;

	public Productobanco() {
	}

	public Productobanco(String nom_productos, String tipo, String estdo) {
		this.nom_productos = nom_productos;
		this.tipo = tipo;
		this.estdo = estdo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_productos() {
		return nom_productos;
	}

	public void setNom_productos(String nom_productos) {
		this.nom_productos = nom_productos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstdo() {
		return estdo;
	}

	public void setEstdo(String estdo) {
		this.estdo = estdo;
	}

}