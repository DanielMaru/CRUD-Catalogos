package net.codejava.spring.model;

public class ciudad {
	
	private int IdCiudad;
	private String NombreCiudad;
	private String NombreDepartamento;
	private int estado_ciudad;
	

	public ciudad() {
	}
	public ciudad(String nombreCiudad, String nombreDepartamento) {
		this.NombreCiudad = nombreCiudad;
		this.NombreDepartamento = nombreDepartamento;
		
	}

	public ciudad(String nombreCiudad, String nombreDepartamento,int estado_ciudad) {
		this.NombreCiudad = nombreCiudad;
		this.NombreDepartamento = nombreDepartamento;
		this.estado_ciudad = estado_ciudad;
		
		
	}

	public int getIdCiudad() {
		return IdCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.IdCiudad = idCiudad;
	}

	public String getNombreCiudad() {
		return NombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.NombreCiudad = nombreCiudad;
	}

	public String getNombreDepartamento() {
		return NombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.NombreDepartamento = nombreDepartamento;
	}
	
	public int getestado_ciudad() {
		return estado_ciudad;
	}

	public void setestado_ciudad(int estado_ciudad) {
		this.estado_ciudad = estado_ciudad;
	}

}
