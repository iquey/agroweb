package com.mx.agroweb.admin.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.mx.agroweb.admin.dao.CatUsuarioDAO;
import com.mx.agroweb.admin.mappers.CatUsuarioMapper;
import com.mx.agroweb.admin.vo.CatUsuarioVO;

@Component
public class CatUsuarioDAOImpl extends JdbcDaoSupport implements CatUsuarioDAO {

	@Autowired
	public CatUsuarioDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertUsuario(CatUsuarioVO catUsuarioVO) {

		getJdbcTemplate().update(
				QUERY_INSERT,
				new Object[] { catUsuarioVO.getUsuario(), catUsuarioVO.getPassword(), catUsuarioVO.getFechaAlta(),
						catUsuarioVO.getIdEstatus(), catUsuarioVO.getIdLicencia() });
	}

	@Override
	public CatUsuarioVO getUsuario(String username, String password) {
		CatUsuarioVO catUsuarioVO = null;
		try {

			catUsuarioVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_USR_PASS, new Object[] { username, password },
					new CatUsuarioMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return catUsuarioVO;
	}

	@Override
	public List<CatUsuarioVO> getUsuarios() {
		List<CatUsuarioVO> usuariosList = getJdbcTemplate().query(QUERY_GET_ALL, new CatUsuarioMapper());
		return usuariosList;
	}

	@Override
	public void setDataSourceDynamic(DataSource dataSource) {
		setDataSource(dataSource);
	}


}
