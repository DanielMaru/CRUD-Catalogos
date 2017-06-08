package net.codejava.spring.model;

public class Categoria {
	private int id;
	private String nombre;
	private String descripcion;
	private int estadoEliminado;
	
	public Categoria(){
		
	}	
	public Categoria(int id, String nombre, String descripcion, int estadoEliminado) {
		
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estadoEliminado = estadoEliminado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getEstadoEliminado() {
		return estadoEliminado;
	}
	public void setEstadoEliminado(int estadoEliminado) {
		this.estadoEliminado = estadoEliminado;
	}
	
	
	
}
