
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.codejava.spring.business.DeparBusiness;
import net.codejava.spring.dao.DeparDAO;
import net.codejava.spring.model.Depar;

@RunWith(MockitoJUnitRunner.class)
public class DeparTest {
	
	private DeparBusiness deparBusiness;
	
	@Mock
	private DeparDAO deparDao;
	
	@Before
	public void setUp(){
		deparBusiness = new DeparBusiness(deparDao);
	}
	
	@Test
	public void noGuardarPerfilSiElNombreYaExiste(){
		//arrange
		Depar depar = new Depar("bogota", "la capital");
		
		//act
		if(deparDao.validar(depar.getNombre_depart())==true){
		 deparBusiness. saveOrUpdate(depar);
		}
		//assert
	}
}