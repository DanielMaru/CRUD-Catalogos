package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.ciudad;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface ciudadDAO {
	
	public boolean saveOrUpdate(ciudad ciudad);
	
	public boolean delete(int idCiudad);
	
	public ciudad get(int idCiudad);
	
	public List<ciudad> list();
	

}
