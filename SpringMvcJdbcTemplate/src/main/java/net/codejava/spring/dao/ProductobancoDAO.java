package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Contact;
import net.codejava.spring.model.Productobanco;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface ProductobancoDAO {
	
	public void saveOrUpdate(Productobanco producto);
	
	public void delete(int produtoId);
	
	public Productobanco get(int productoId);
	
	public List<Productobanco> list(); 
	
}
