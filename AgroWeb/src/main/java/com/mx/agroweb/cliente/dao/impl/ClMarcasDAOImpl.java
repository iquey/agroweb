package com.mx.agroweb.cliente.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.mx.agroweb.cliente.dao.ClMarcasDAO;
import com.mx.agroweb.cliente.mappers.ClMarcasMapper;
import com.mx.agroweb.cliente.vo.ClMarcasVO;

@Component
public class ClMarcasDAOImpl extends JdbcDaoSupport implements ClMarcasDAO {

	@Autowired
	public ClMarcasDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertMarca(ClMarcasVO clMarcasVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(QUERY_INSERT,
				new Object[] { clMarcasVO.getDescripcion()});

	}

	@Override
	public ClMarcasVO getMarca(int id) {
		ClMarcasVO clMarcasVO = null;
		try {
			clMarcasVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_ID, new Object[] { id },
					new ClMarcasMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return clMarcasVO;
	}

	@Override
	public List<ClMarcasVO> getMarcas() {
		List<ClMarcasVO> marcasList = getJdbcTemplate().query(QUERY_GET_ALL, new ClMarcasMapper());
		return marcasList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void deleteMarca(int id) throws DataIntegrityViolationException{
		getJdbcTemplate().update(QUERY_DELETE_BY_ID, new Object[] { id });
	}

	@Override
	public void updateMarca(ClMarcasVO clMarcasVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate()
				.update(QUERY_UPDATE_BY_ID,
						new Object[] { clMarcasVO.getDescripcion(),
						clMarcasVO.getId() });
	}

	@Override
	public int getId(ClMarcasVO clMarcasVO) {

		Integer idMarcas = (Integer) getJdbcTemplate().queryForObject(QUERY_GET_ID,
				new Object[] { clMarcasVO.getDescripcion() }, Integer.class);
		if (idMarcas != null)
			return idMarcas.intValue();
		return 0;
	}
}
