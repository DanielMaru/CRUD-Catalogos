
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.codejava.spring.business.CategoriaBusiness;
import net.codejava.spring.dao.CategoriaDAO;
import net.codejava.spring.model.Categoria;
import net.codejava.spring.model.Depar;

@RunWith(MockitoJUnitRunner.class)
public class CategoriaTest {
	
	private CategoriaBusiness categoriaBusiness;
	
	@Mock
	private CategoriaDAO categoriaDAO;
	
	@Before
	public void setUp(){
		categoriaBusiness = new CategoriaBusiness(categoriaDAO);
	}
	
	@Test
	public void noGuardarPerfilSiElNombreYaExiste(){
		//arrange
		Categoria categoria = new Categoria("Alimentos", "Comestibles");
		
		//act
		if(categoriaDAO.validar(categoria.getNombre())==true){
		 categoriaBusiness.guardarOActualizar(categoria);
		}
		//assert
	}

}
