package com.mx.agroweb.cliente.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.mx.agroweb.cliente.dao.ClZonasDAO;
import com.mx.agroweb.cliente.mappers.ClZonasMapper;
import com.mx.agroweb.cliente.vo.ClZonasVO;

@Component
public class ClZonasDAOImpl extends JdbcDaoSupport implements ClZonasDAO {

	@Autowired
	public ClZonasDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertZona(ClZonasVO clZonasVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(QUERY_INSERT,
				new Object[] { clZonasVO.getDescripcion()});

	}

	@Override
	public ClZonasVO getZona(int id) {
		ClZonasVO clZonasVO = null;
		try {
			clZonasVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_ID, new Object[] { id },
					new ClZonasMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return clZonasVO;
	}

	@Override
	public List<ClZonasVO> getZonas() {
		List<ClZonasVO> ZonasList = getJdbcTemplate().query(QUERY_GET_ALL, new ClZonasMapper());
		return ZonasList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void deleteZona(int id) throws DataIntegrityViolationException{
		getJdbcTemplate().update(QUERY_DELETE_BY_ID, new Object[] { id });
	}

	@Override
	public void updateZona(ClZonasVO clZonasVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate()
				.update(QUERY_UPDATE_BY_ID,
						new Object[] { clZonasVO.getDescripcion(),
						clZonasVO.getId() });
	}

	@Override
	public int getId(ClZonasVO clZonasVO) {

		Integer idZonas = (Integer) getJdbcTemplate().queryForObject(QUERY_GET_ID,
				new Object[] { clZonasVO.getDescripcion() }, Integer.class);
		if (idZonas != null)
			return idZonas.intValue();
		return 0;
	}
}
