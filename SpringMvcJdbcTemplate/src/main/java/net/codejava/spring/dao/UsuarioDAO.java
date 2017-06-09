package net.codejava.spring.dao;

import java.util.List;
import net.codejava.spring.model.Usuario;


public interface UsuarioDAO {
	
	public boolean saveOrUpdate(Usuario usuario);
	
	public boolean delete(int id);
	
	public Usuario get(int id);
	
	public List<Usuario> list();
	
	public boolean realDelete(int id);
	

	
}
