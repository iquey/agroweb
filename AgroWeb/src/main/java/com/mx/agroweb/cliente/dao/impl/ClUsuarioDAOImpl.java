package com.mx.agroweb.cliente.dao.impl;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import com.mx.agroweb.cliente.dao.ClUsuarioDAO;
import com.mx.agroweb.cliente.mappers.ClUsuarioMapper;
import com.mx.agroweb.cliente.vo.ClUsuarioVO;

@Component
public class ClUsuarioDAOImpl extends JdbcDaoSupport implements ClUsuarioDAO {
	
	public final String QUERY_INSERT = "INSERT INTO CAT_USUARIOS (USU_USUARIO, USU_PASSWORD, USU_FECHA_ALTA, USU_ID_ESTATUS) VALUES (?, ?, ?, ?)";
	public final String QUERY_GET_BY_USR_PASS = "SELECT * FROM CAT_USUARIOS WHERE BINARY USU_USUARIO = ? AND USU_PASSWORD = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_USUARIOS";

	@Autowired
	public ClUsuarioDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertUsuario(ClUsuarioVO clUsuarioVO) {

		getJdbcTemplate().update(
				QUERY_INSERT,
				new Object[] { clUsuarioVO.getUsuario(), clUsuarioVO.getPassword(), clUsuarioVO.getFechaAlta(),
						clUsuarioVO.getIdEstatus() });
	}

	@Override
	public ClUsuarioVO getUsuario(String username, String password) {
		ClUsuarioVO clUsuarioVO = null;
		try {
			clUsuarioVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_USR_PASS, new Object[] { username, password },
					new ClUsuarioMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return clUsuarioVO;
	}

	@Override
	public List<ClUsuarioVO> getUsuarios() {
		List<ClUsuarioVO> usuariosList = getJdbcTemplate().query(QUERY_GET_ALL, new ClUsuarioMapper());
		return usuariosList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

}
