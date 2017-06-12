package net.codejava.spring.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.spring.dao.CategoriaDAO;
import net.codejava.spring.model.Categoria;

@Service
public class CategoriaBusiness {
	
	private CategoriaDAO CategoriaDAO;
	
	@Autowired
	public CategoriaBusiness(CategoriaDAO CategoriaDAO) {
		this.CategoriaDAO = CategoriaDAO;
	}

	public List<Categoria> list() {
		return CategoriaDAO.list();
	}
	
	public boolean validar(String nombre) {
		return CategoriaDAO.validar(nombre);
	}

	public String guardarOActualizar(Categoria categoria) {
		String mensaje = "";
		if(categoria.getId() > 0){ //si es editar
			CategoriaDAO.guardarOActualizar(categoria);
		}else{ //si es guardar
			if(CategoriaDAO.validar(categoria.getNombre()) == true){
				CategoriaDAO.guardarOActualizar(categoria);
			}else{
				mensaje = "El nombre del perfil ya existe";
			}
		}
		return mensaje;
	}
	

	public void delete(int id_categoriaId) {
		CategoriaDAO.eliminar(id_categoriaId);
		
	}

	public Categoria get(int categoriaId) {
		return CategoriaDAO.get(categoriaId);
	}
	
	
	
	
}