package net.codejava.spring.dao;



import java.util.List;

import net.codejava.spring.model.Categoria;

public interface CategoriaDAO {
	
	public void guardarOActualizar(Categoria categoria);
	
	public void eliminar(int categoriaId);
	
	public Categoria get(int categoriaId);
	
	public List<Categoria> list();
	
	

}
