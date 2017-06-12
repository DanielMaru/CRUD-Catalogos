
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.codejava.spring.business.CiudadBusiness2;
import net.codejava.spring.dao.ciudadDAO;
import net.codejava.spring.model.ciudad;

@RunWith(MockitoJUnitRunner.class)
public class ciudadTest2 {
	
	private CiudadBusiness2 ciudadBusiness;
	
	@Mock
	private ciudadDAO ciudadDao;
	
	@Before
	public void setUp(){
		ciudadBusiness = new CiudadBusiness2(ciudadDao);
	}
	
	@Test
	public void noGuardarciudadSiElNombreYaExiste(){
		//arrange
		ciudad ciudadARetornar = new ciudad("NombreCiudad", "NombreDepartamento");
		ciudad ciudad = new ciudad("NombreCiudad", "NombreDepartamento");
		
		//act
		when(ciudadDao.buscarPorNombreCiudad(ciudad.getNombreCiudad())).thenReturn(ciudadARetornar);
		String resultado = ciudadBusiness.saveOrUpdate(ciudad);
		
		//assert
		assertEquals("El nombre de la ciudad ya existe", resultado);
	}
}
