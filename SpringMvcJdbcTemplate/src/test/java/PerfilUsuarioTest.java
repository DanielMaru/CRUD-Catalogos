
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.spring.dao.PerfilUsuarioDAOImpl;
import net.codejava.spring.model.PerfilUsuario;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
public class PerfilUsuarioTest {
	
	private PerfilUsuarioDAOImpl perfilUsuarioDaoImpl;
	
	@Before
	public void setUp(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("Admin");
		
		perfilUsuarioDaoImpl = new PerfilUsuarioDAOImpl(dataSource);
	}
	
	@Test
	public void guardarPerfilSiNoExiste(){
		//arrange
		PerfilUsuario perfilUsuario = new PerfilUsuario("Recursos humanos", "Encargado de la gestion de recursos humanos");
		
		//act
		boolean resultado = perfilUsuarioDaoImpl.guardarOActualizar(perfilUsuario);
		
		//assert
		assertTrue(resultado);
	}
}
