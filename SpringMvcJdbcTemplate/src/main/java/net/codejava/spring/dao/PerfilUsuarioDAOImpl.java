package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.model.PerfilUsuario;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the PerfilDAO interface.
 * @author www.codejava.net
 *
 */
public class PerfilUsuarioDAOImpl implements PerfilUsuarioDAO {

	private JdbcTemplate jdbcTemplate;
	
	public PerfilUsuarioDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean guardarOActualizar(PerfilUsuario perfilUsuario){
		if (perfilUsuario.getId() > 0) {
			// update
			String sql = "UPDATE perfiles_usuarios SET nomPERFIL=?, descripPERFIL=? WHERE idPERFIL=?";
			try{
			jdbcTemplate.update(sql, perfilUsuario.getNombre(), perfilUsuario.getDescripcion(), perfilUsuario.getId());
			}catch(DataAccessException exception){
				return false;
			}
			return true;
			
		} else {
			// insert
			String sql = "INSERT INTO perfiles_usuarios (nomPERFIL, descripPERFIL)"
						+ " VALUES (?, ?)";
			try{
			jdbcTemplate.update(sql, perfilUsuario.getNombre(), perfilUsuario.getDescripcion());
			}catch(DataAccessException exception){
				return false;
			}
			return true;
		}
		
	}

	@Override
	public void borrar(int perfilUsuarioId) {
		String sql = "UPDATE perfiles_usuarios SET estadoPERFIL=? WHERE idPERFIL=?";
		jdbcTemplate.update(sql, 1, perfilUsuarioId);
	}

	@Override
	public List<PerfilUsuario> listar() {
		String sql = "SELECT * FROM perfiles_usuarios WHERE estadoPERFIL='0'";
		List<PerfilUsuario> listPerfilUsuario = jdbcTemplate.query(sql, new RowMapper<PerfilUsuario>() {

			@Override
			public PerfilUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				PerfilUsuario perfilUsuario = new PerfilUsuario();
	
				perfilUsuario.setId(rs.getInt("idPERFIL"));
				perfilUsuario.setNombre(rs.getString("nomPERFIL"));
				perfilUsuario.setDescripcion(rs.getString("descripPERFIL"));
				perfilUsuario.setEstado(rs.getInt("estadoPERFIL"));
				
				return perfilUsuario;
			}
			
		});
		
		return listPerfilUsuario;
	}

	@Override
	public PerfilUsuario obtener(int perfilId) {
		String sql = "SELECT * FROM perfiles_usuarios WHERE idPERFIL='" + perfilId +"' AND estadoPERFIL='0'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<PerfilUsuario>() {

			@Override
			public PerfilUsuario extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					PerfilUsuario perfilUsuario = new PerfilUsuario();
					
					perfilUsuario.setId(rs.getInt("idPERFIL"));
					perfilUsuario.setNombre(rs.getString("nomPERFIL"));
					perfilUsuario.setDescripcion(rs.getString("descripPERFIL"));
					perfilUsuario.setEstado(rs.getInt("estadoPERFIL"));
					
					return perfilUsuario;
				}
				
				return null;
			}
			
		});
	}

}
