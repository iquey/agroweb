package com.mx.agroweb.cliente.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.mx.agroweb.cliente.dao.ClCentroCostosDAO;
import com.mx.agroweb.cliente.dao.ClGrupoInsumosDAO;
import com.mx.agroweb.cliente.dao.ClGrupoMaquinariaDAO;
import com.mx.agroweb.cliente.dao.ClProveedorDAO;
import com.mx.agroweb.cliente.mappers.ClCentroCostosMapper;
import com.mx.agroweb.cliente.mappers.ClGrupoInsumosMapper;
import com.mx.agroweb.cliente.mappers.ClGrupoMaquinariaMapper;
import com.mx.agroweb.cliente.mappers.ClProveedorMapper;
import com.mx.agroweb.cliente.vo.ClCentroCostosVO;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClGrupoMaquinariaVO;
import com.mx.agroweb.cliente.vo.ClProveedorVO;

@Component
public class ClGrupoMaquinariaDAOImpl extends JdbcDaoSupport implements ClGrupoMaquinariaDAO {

	@Autowired
	public ClGrupoMaquinariaDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertGrupoMaquinaria(ClGrupoMaquinariaVO clGrupoMaquinariaVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(QUERY_INSERT,
				new Object[] { clGrupoMaquinariaVO.getDescripcion()});

	}

	@Override
	public ClGrupoMaquinariaVO getGrupoMaquinaria(int id) {
		ClGrupoMaquinariaVO clGrupoMaquinariaVO = null;
		try {
			clGrupoMaquinariaVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_ID, new Object[] { id },
					new ClGrupoMaquinariaMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return clGrupoMaquinariaVO;
	}

	@Override
	public List<ClGrupoMaquinariaVO> getGruposMaquinaria() {
		List<ClGrupoMaquinariaVO> grupoMaquinariaList = getJdbcTemplate().query(QUERY_GET_ALL, new ClGrupoMaquinariaMapper());
		return grupoMaquinariaList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void deleteGrupoMaquinaria(int id) throws DataIntegrityViolationException{
		getJdbcTemplate().update(QUERY_DELETE_BY_ID, new Object[] { id });
	}

	@Override
	public void updateGrupoMaquinaria(ClGrupoMaquinariaVO clGrupoMaquinariaVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate()
				.update(QUERY_UPDATE_BY_ID,
						new Object[] { clGrupoMaquinariaVO.getDescripcion(),
						clGrupoMaquinariaVO.getId() });
	}

	@Override
	public int getId(ClGrupoMaquinariaVO clGrupoMaquinariaVO) {

		Integer idGrupoMaquinaria = (Integer) getJdbcTemplate().queryForObject(QUERY_GET_ID,
				new Object[] { clGrupoMaquinariaVO.getDescripcion() }, Integer.class);
		if (idGrupoMaquinaria != null)
			return idGrupoMaquinaria.intValue();
		return 0;
	}
}
