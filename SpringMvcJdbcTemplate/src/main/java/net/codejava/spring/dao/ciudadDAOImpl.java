package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import net.codejava.spring.model.ciudad;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ciudadDAO interface.
 * @author www.codejava.net
 *
 */
public class ciudadDAOImpl implements ciudadDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ciudadDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	@Override
	public void saveOrUpdate(ciudad ciudad) {
		if (ciudad.getIdCiudad() > 0) {
			// update
			String sql = "UPDATE ciudad SET NombreCiudad=?, NombreDepartamento=? WHERE idciudad=?";
			jdbcTemplate.update(sql, ciudad.getNombreCiudad(), ciudad.getNombreDepartamento(),
					 ciudad.getIdCiudad());
		} else {
			// insert
			String sql = "INSERT INTO ciudad (NombreCiudad, NombreDepartamento)"
						+ " VALUES (?, ?)";
			jdbcTemplate.update(sql, ciudad.getNombreCiudad(), ciudad.getNombreDepartamento());
			
		}
		
		}
		


	@Override
	public void delete(int ciudadId) {
		String sql = "UPDATE ciudad SET estado_ciudad=1 WHERE IdCiudad=?";
		jdbcTemplate.update(sql, ciudadId);
		

	}

	@Override
	public List<ciudad> list() {
		String sql = "SELECT * FROM ciudad WHERE estado_ciudad='0'";
		List<ciudad> listciudad = jdbcTemplate.query(sql, new RowMapper<ciudad>() {

			@Override
			public ciudad mapRow(ResultSet rs, int rowNum) throws SQLException {
				ciudad aciudad = new ciudad();
	
				aciudad.setIdCiudad(rs.getInt("IdCiudad"));
				aciudad.setNombreCiudad(rs.getString("NombreCiudad"));
				aciudad.setNombreDepartamento(rs.getString("NombreDepartamento"));
				aciudad.setestado_ciudad(rs.getInt("estado_ciudad"));
				
				
				return aciudad;
			}
		
	});
		return listciudad;
}
			
	@Override
	public boolean validar(String NombreCiudad) {
		
		String sql = "select count(idCiudad) cantidad FROM ciudad where NombreDepartamento=? and estado_ciudad='0'" ;
		

		String name = (String)jdbcTemplate.queryForObject(sql, new Object[] { NombreCiudad }, String.class);
		
		if(name.equals("1")){
			return false;
		}
		else{
			return true;	
		}
	}
		
	

	@Override
	public ciudad Obtener(int ciudadId) {
		String sql = "SELECT * FROM ciudad WHERE IdCiudad=" + ciudadId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<ciudad>() {

			@Override
			public ciudad extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					ciudad ciudad = new ciudad();
					ciudad.setIdCiudad(rs.getInt("IdCiudad"));
					ciudad.setNombreCiudad(rs.getString("NombreCiudad"));
					ciudad.setNombreDepartamento(rs.getString("NombreDepartamento"));
					ciudad.setestado_ciudad(rs.getInt("estado_ciudad"));
				return ciudad;
				}
				
				return null;
			}
	
			
			
		});
	}

}
