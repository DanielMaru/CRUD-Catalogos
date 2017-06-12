package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.ciudad;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface ciudadDAO {
	
	public void saveOrUpdate(ciudad ciudad);
	
	public void delete(int idCiudad);
	
	public ciudad get(int idCiudad);
	
	public boolean validar(String ciudad);
	
	public List<ciudad> list();
	

}
