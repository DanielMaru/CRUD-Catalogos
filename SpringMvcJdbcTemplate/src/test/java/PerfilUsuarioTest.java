
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.codejava.spring.business.PerfilUsuarioBusiness;
import net.codejava.spring.dao.PerfilUsuarioDAO;
import net.codejava.spring.model.PerfilUsuario;

@RunWith(MockitoJUnitRunner.class)
public class PerfilUsuarioTest {
	
	private PerfilUsuarioBusiness perfilUsuarioBusiness;
	
	@Mock
	private PerfilUsuarioDAO perfilUsuarioDao;
	
	@Before
	public void setUp(){
		perfilUsuarioBusiness = new PerfilUsuarioBusiness(perfilUsuarioDao);
	}
	
	@Test
	public void noGuardarPerfilSiElNombreYaExiste(){
		//arrange
		PerfilUsuario perfilUsuarioARetornar = new PerfilUsuario("Recursos humanos", "Encargado de la gestion de recursos humanos");
		PerfilUsuario perfilUsuario = new PerfilUsuario("Recursos humanos", "Encargado de la gestion de recursos humanos");
		
		//act
		when(perfilUsuarioDao.buscarPorNombre(perfilUsuario.getNombre())).thenReturn(perfilUsuarioARetornar);
		String resultado = perfilUsuarioBusiness.guardarOActualizar(perfilUsuario);
		
		//assert
		assertEquals("El nombre del perfil ya existe", resultado);
	}
}
