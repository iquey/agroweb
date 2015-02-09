package com.mx.agroweb.cliente.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.mx.agroweb.cliente.dao.ClCentroCostosDAO;
import com.mx.agroweb.cliente.dao.ClProveedorDAO;
import com.mx.agroweb.cliente.mappers.ClCentroCostosMapper;
import com.mx.agroweb.cliente.mappers.ClProveedorMapper;
import com.mx.agroweb.cliente.vo.ClCentroCostosVO;
import com.mx.agroweb.cliente.vo.ClProveedorVO;

@Component
public class ClCentroCostosDAOImpl extends JdbcDaoSupport implements ClCentroCostosDAO {

	@Autowired
	public ClCentroCostosDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertCentroCostos(ClCentroCostosVO clCentroCostosVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(QUERY_INSERT, new Object[] { clCentroCostosVO.getDescripcion() });

	}

	@Override
	public ClCentroCostosVO getCentroCostos(int id) {
		ClCentroCostosVO clCentroCostosVO = null;
		try {
			clCentroCostosVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_ID, new Object[] { id },
					new ClCentroCostosMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return clCentroCostosVO;
	}

	@Override
	public List<ClCentroCostosVO> getCentrosCostos() {
		List<ClCentroCostosVO> centroCostosList = getJdbcTemplate().query(QUERY_GET_ALL, new ClCentroCostosMapper());
		return centroCostosList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void deleteCentroCostos(int id) throws DataIntegrityViolationException{
		getJdbcTemplate().update(QUERY_DELETE_BY_ID, new Object[] { id });
	}

	@Override
	public void updateCentroCostos(ClCentroCostosVO clCentroCostosVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(QUERY_UPDATE_BY_ID,
				new Object[] { clCentroCostosVO.getDescripcion(), clCentroCostosVO.getId() });
	}

	@Override
	public int getId(ClCentroCostosVO clCentroCostosVO) {

		Integer idCentroCosto = (Integer) getJdbcTemplate().queryForObject(QUERY_GET_ID,
				new Object[] { clCentroCostosVO.getDescripcion() }, Integer.class);
		if (idCentroCosto != null)
			return idCentroCosto.intValue();
		return 0;
	}
}
