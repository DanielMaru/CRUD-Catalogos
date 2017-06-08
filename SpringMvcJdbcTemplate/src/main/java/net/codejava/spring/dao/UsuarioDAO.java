package net.codejava.spring.dao;

import java.util.List;
import net.codejava.spring.model.Usuario;


public interface UsuarioDAO {
	
	public void saveOrUpdate(Usuario usuario);
	
	public void delete(int id);
	
	public Usuario get(int id);
	
	public List<Usuario> list();
	

	
}
