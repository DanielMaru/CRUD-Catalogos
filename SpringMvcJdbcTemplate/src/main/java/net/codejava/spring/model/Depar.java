package net.codejava.spring.model;

public class Depar {
	private int id_depart;
	private String nombre_depart;
	private String descrip_depart;
	private int status_depart;

	public Depar() {
	}
	
	public Depar(String nombre_depart, String descrip_depart) {
		this.nombre_depart = nombre_depart;
		this.descrip_depart = descrip_depart;
	}

	public Depar(int id_depart, String nombre_depart, String descrip_depart, int status_depart) {
		this.id_depart = id_depart;
		this.nombre_depart = nombre_depart;
		this.descrip_depart = descrip_depart;
		this.status_depart = status_depart;
	}

	public int getId_depart() {
		return id_depart;
	}

	public void setId_depart(int id_depart) {
		this.id_depart = id_depart;
	}

	public String getNombre_depart() {
		return nombre_depart;
	}

	public void setNombre_depart(String nombre_depart) {
		this.nombre_depart = nombre_depart;
	}

	public String getDescrip_depart() {
		return descrip_depart;
	}

	public void setDescrip_depart(String descrip_depart) {
		this.descrip_depart = descrip_depart;
	}

	public int getStatus_depart() {
		return status_depart;
	}

	public void setStatus_depart(int status_depart) {
		this.status_depart = status_depart;
	}

}
