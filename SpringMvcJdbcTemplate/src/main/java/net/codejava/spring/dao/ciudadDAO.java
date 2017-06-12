package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.PerfilUsuario;
import net.codejava.spring.model.ciudad;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface ciudadDAO {
	
	public void saveOrUpdate(ciudad ciudad);
	
	public void delete(int idCiudad);
	
	public ciudad buscarPorNombreCiudad(String buscarPorNombreCiudad);
	
	public ciudad Obtener(int CiudadId);
	
	public List<ciudad> list();
	

}
