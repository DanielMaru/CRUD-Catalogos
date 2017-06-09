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



@Transactional
public class UsuarioDAOImpTest {
	
	
	private UsuarioDAO usuarioDAO;
	
	@Before
	public void setUp(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("Admin");
		
		
		usuarioDAO = new UsuarioDAOImp(dataSource);
	}
	
	
	@Test
	@Rollback
	public void testSaveOrUpdate() {
		
		Usuario usuario = new Usuario();
		usuario.setLogin("lucho");
		usuario.setNombre("lucho");
		usuario.setPass("lucho");
		assertTrue(usuarioDAO.saveOrUpdate(usuario));		
		
	}

	@Test
	public void testDelete() {
		int id = 1;
		Usuario usuario = usuarioDAO.get(id);
		int estadoAnterior = usuario.getEstado();
		usuarioDAO.delete(id);
		usuario = usuarioDAO.get(id);
		assertTrue(usuario.getEstado()==1);
		usuario.setEstado(estadoAnterior);
		usuarioDAO.saveOrUpdate(usuario);
	}

	@Test
	public void testGet() {
		int id = 1;
		Usuario usuario = usuarioDAO.get(id);
		assertNotEquals(usuario, null);
	}

	@Test
	public void testList() {
		List<Usuario> lista = usuarioDAO.list();
		assertTrue(lista!=null);
	}

}
