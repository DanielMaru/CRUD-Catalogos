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
	
	public void guardarOActualizar(PerfilUsuario perfil);
	
	public void borrar(int perfilId);
	
	public PerfilUsuario buscarPorNombre(String perfilNombre);
	
	public PerfilUsuario obtener(int perfilId);
	
	public List<PerfilUsuario> listar();
}
