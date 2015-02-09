package com.mx.agroweb.cliente.dao.impl;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import com.mx.agroweb.cliente.dao.ClEmpresaDAO;
import com.mx.agroweb.cliente.mappers.ClEmpresaMapper;
import com.mx.agroweb.cliente.vo.ClEmpresaVO;

@Component
public class ClEmpresaDAOImpl extends JdbcDaoSupport implements ClEmpresaDAO {

	@Autowired
	public ClEmpresaDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertEmpresa(ClEmpresaVO clEmpresaVO) {
		getJdbcTemplate().update(QUERY_INSERT, new Object[] { clEmpresaVO.getNombre(), clEmpresaVO.getDireccion() });
	}

	@Override
	public ClEmpresaVO getEmpresa(int id) {
		ClEmpresaVO clEmpresaVO = null;
		try {
			clEmpresaVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_ID, new Object[] { id }, new ClEmpresaMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return clEmpresaVO;
	}

	@Override
	public List<ClEmpresaVO> getEmpresas() {
		List<ClEmpresaVO> empresasList = getJdbcTemplate().query(QUERY_GET_ALL, new ClEmpresaMapper());
		return empresasList;
	}

	@Override
	public List<ClEmpresaVO> getEmpresasByIdUser(int id) {
		List<ClEmpresaVO> empresasList = getJdbcTemplate().query(QUERY_GET_ALL_EMPRESAS_BY_USER, new Object[] { id },
				new ClEmpresaMapper());
		return empresasList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

}
