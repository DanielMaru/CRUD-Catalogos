package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Contact;
import net.codejava.spring.model.PerfilUsuario;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface PerfilUsuarioDAO {
	
	public void saveOrUpdate(PerfilUsuario perfil);
	
	public void delete(int perfilId);
	
	public PerfilUsuario get(int perfilId);
	
	public List<PerfilUsuario> list();
}
