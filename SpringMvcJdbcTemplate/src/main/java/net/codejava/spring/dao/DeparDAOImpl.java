package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.model.Depar;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class DeparDAOImpl implements DeparDAO {

	private JdbcTemplate jdbcTemplate;
	
	public DeparDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	//Update or Insert of the table
	@Override
	public void saveOrUpdate(Depar depar) {
		if (depar.getId_depart() > 0) {
			// update
			String sql = "UPDATE departamento SET nombre_depart=?, descrip_depart=?, status_depart=? "
						+ "WHERE id_depart=?";
			jdbcTemplate.update(sql, depar.getNombre_depart(), depar.getDescrip_depart(),
					depar.getStatus_depart(), depar.getId_depart());
		} else {
			// insert
			String sql = "INSERT INTO departamento (nombre_depart, descrip_depart, status_depart)"
						+ " VALUES (?, ?, ?)";
			jdbcTemplate.update(sql, depar.getNombre_depart(), depar.getDescrip_depart(),
					depar.getStatus_depart());
		}
		
	}

	//Delete of the table
	@Override
	public void delete(int id_depart) {
		String sql = "UPDATE departamento SET status_depart=? WHERE id_depart=?";
		jdbcTemplate.update(sql, 1, id_depart);
	}

	
	@Override
	public List<Depar> list() {
		String sql = "SELECT * FROM departamento  WHERE status_depart=0";
		List<Depar> listContact = jdbcTemplate.query(sql, new RowMapper<Depar>() {

			@Override
			public Depar mapRow(ResultSet rs, int rowNum) throws SQLException {
				Depar aContact = new Depar();
	
				aContact.setId_depart(rs.getInt("id_depart"));
				aContact.setNombre_depart(rs.getString("nombre_depart"));
				aContact.setDescrip_depart(rs.getString("descrip_depart"));
				aContact.setStatus_depart(rs.getInt("status_depart"));
				
				return aContact;
			}
			
		});
		
		return listContact;
	}
	
	@Override
	public boolean validar(String nombre) {
		
		String sql = "select count(id_depart) cantidad FROM departamento where nombre_depart=? and status_depart='0'" ;
		

		String name = (String)jdbcTemplate.queryForObject(sql, new Object[] { nombre }, String.class);
		
		if(name.equals("1")){
			return false;
		}
		else{
			return true;	
		}
		
		
		
	}


	@Override
	public Depar get(int id_depart) {
		String sql = "SELECT * FROM departamento WHERE id_depart=" + id_depart;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Depar>() {

			@Override
			public Depar extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Depar depar = new Depar();
					depar.setId_depart(rs.getInt("id_depart"));
					depar.setNombre_depart(rs.getString("nombre_depart"));
					depar.setDescrip_depart(rs.getString("descrip_depart"));
					depar.setStatus_depart(rs.getInt("status_depart"));
					return depar;
				}
				
				return null;
			}
			
		});
	}
	
	

}
