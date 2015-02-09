package com.mx.agroweb.cliente.dao.impl;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import com.mx.agroweb.cliente.dao.ClEmpresaUsuarioDAO;
import com.mx.agroweb.cliente.mappers.ClEmpresaUsuarioMapper;
import com.mx.agroweb.cliente.vo.ClEmpresaUsuarioVO;

@Component
public class ClEmpresaUsuarioDAOImpl extends JdbcDaoSupport implements ClEmpresaUsuarioDAO {

	@Autowired
	public ClEmpresaUsuarioDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertEmpresa(ClEmpresaUsuarioVO clEmpresaUsuarioVO) {
		getJdbcTemplate().update(QUERY_INSERT,
				new Object[] { clEmpresaUsuarioVO.getIdEmpresa(), clEmpresaUsuarioVO.getIdUsuario() });
	}

	@Override
	public ClEmpresaUsuarioVO getEmpresa(int id) {
		ClEmpresaUsuarioVO clEmpresaUsuarioVO = null;
		try {
			clEmpresaUsuarioVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_ID, new Object[] { id },
					new ClEmpresaUsuarioMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return clEmpresaUsuarioVO;
	}

	@Override
	public List<ClEmpresaUsuarioVO> getEmpresasByUser(int idUsuario) {
		List<ClEmpresaUsuarioVO> empresasUsuariosList = getJdbcTemplate().query(QUERY_GET_BY_ID_USUARIO,
				new Object[] { idUsuario }, new ClEmpresaUsuarioMapper());
		return empresasUsuariosList;
	}

	@Override
	public List<ClEmpresaUsuarioVO> getEmpresas() {
		List<ClEmpresaUsuarioVO> empresasUsuariosList = getJdbcTemplate().query(QUERY_GET_BY_ID_USUARIO,
				new ClEmpresaUsuarioMapper());

		return empresasUsuariosList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

}
