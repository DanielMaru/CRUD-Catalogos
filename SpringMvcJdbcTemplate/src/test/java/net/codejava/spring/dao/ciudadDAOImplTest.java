package net.codejava.spring.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.activation.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.config.TxNamespaceHandler;

import net.codejava.spring.model.Usuario;
import net.codejava.spring.model.ciudad;



@Transactional
public class ciudadDAOImplTest {
	
	
	private ciudadDAO ciudadDAO;
	
	@Before
	public void setUp(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		
		ciudadDAO = new ciudadDAOImpl(dataSource);
	}
	
	
	@Test
	@Rollback
	public void testSaveOrUpdate() {
		
		ciudad ciudad = new ciudad();
		ciudad.setNombreCiudad("lucho");
		ciudad.setNombreDepartamento("lucho");
        ciudad.setestado_ciudad(0);
		assertTrue(ciudadDAO.saveOrUpdate(ciudad));		
		
	}

	@Test
	public void testDelete() {
		int idCiudad = 1;
		ciudad ciudad = ciudadDAO.get(idCiudad);
		int estado_ciudad = ciudad.getestado_ciudad();
		ciudadDAO.delete(idCiudad);
		ciudad = ciudadDAO.get(idCiudad);
		assertTrue(ciudad.getestado_ciudad()==1);
		ciudad.setestado_ciudad(0);
		ciudadDAO.saveOrUpdate(ciudad);
	}

	@Test 
	public void testGet() {
		int idCiudad = 1;
		ciudad ciudad = ciudadDAO.get(idCiudad);
		assertNotEquals(ciudad, null);
	}

	@Test
	public void testList() {
		List<ciudad> lista = ciudadDAO.list();
		assertTrue(lista!=null);
	}

}
