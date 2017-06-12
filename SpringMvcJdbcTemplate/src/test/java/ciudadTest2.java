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
	
	private CiudadBusiness2 ciudadBusiness2;
	
	@Mock
	private ciudadDAO ciudadDao;
	
	@Before
	public void setUp(){
		ciudadBusiness2 = new CiudadBusiness2(ciudadDao);
	}
	
	@Test
	public void noGuardarciudadSiElNombreYaExiste(){
		//arrange
		ciudad ciudad = new ciudad("medellin", "la ciudad");
		
		//act
		if(ciudadDao.validar(ciudad.getNombreCiudad())==true){
		 ciudadBusiness2. saveOrUpdate(ciudad);
		}
		//assert
	}
}