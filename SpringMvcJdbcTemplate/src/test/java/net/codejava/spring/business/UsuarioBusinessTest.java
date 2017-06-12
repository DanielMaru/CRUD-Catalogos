package net.codejava.spring.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.codejava.spring.dao.UsuarioDAO;
import net.codejava.spring.model.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioBusinessTest {

	private UsuarioBusiness usuarioBusiness;
	
	@Mock
	private UsuarioDAO usuarioDAO;
	
	@Before
	public void setUp() throws Exception {
		usuarioBusiness = new UsuarioBusiness(usuarioDAO);
		
		
	}

	@Test
	public void testList() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		when(usuarioDAO.list()).thenReturn(usuarios);
		
		List<Usuario> lista = usuarioBusiness.list();
		assertTrue(lista!=null);

		
	}

	@Test
	public void testSaveOrUpdate() {
		Usuario usuarioExistente = new Usuario();
		usuarioExistente.setEstado(1);
		usuarioExistente.setLogin("usuario1");
		usuarioExistente.setNombre("usuario1");
		usuarioExistente.setPass("usuario1");
		
		
		Usuario usuario = new Usuario();
		usuario.setEstado(0);
		usuario.setId(2);
		usuario.setLogin("usuario1");
		usuario.setNombre("usuario1");
		usuario.setPass("usuario");
		
		when(usuarioDAO.findByLogin(usuario.getLogin())).thenReturn(usuarioExistente);
		
		try {
			assertTrue(usuarioBusiness.saveOrUpdate(usuario));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}



}
