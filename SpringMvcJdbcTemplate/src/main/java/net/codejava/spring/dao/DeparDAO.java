package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Depar;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface DeparDAO {
	
	public void saveOrUpdate(Depar depart);
	
	public void delete(int id_depart);
	
	public Depar get(int id_depart);
	
	public List<Depar> list();
	
	public boolean validar(String nombre);
}
