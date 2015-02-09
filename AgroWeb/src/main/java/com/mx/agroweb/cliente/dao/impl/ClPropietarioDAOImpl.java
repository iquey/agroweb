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
import com.mx.agroweb.cliente.dao.ClPropietarioDAO;
import com.mx.agroweb.cliente.dao.ClProveedorDAO;
import com.mx.agroweb.cliente.mappers.ClCentroCostosMapper;
import com.mx.agroweb.cliente.mappers.ClGrupoInsumosMapper;
import com.mx.agroweb.cliente.mappers.ClGrupoMaquinariaMapper;
import com.mx.agroweb.cliente.mappers.ClPropietarioMapper;
import com.mx.agroweb.cliente.mappers.ClProveedorMapper;
import com.mx.agroweb.cliente.vo.ClCentroCostosVO;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClGrupoMaquinariaVO;
import com.mx.agroweb.cliente.vo.ClPropietarioVO;
import com.mx.agroweb.cliente.vo.ClProveedorVO;

@Component
public class ClPropietarioDAOImpl extends JdbcDaoSupport implements ClPropietarioDAO {

	@Autowired
	public ClPropietarioDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertPropietario(ClPropietarioVO clPropietarioVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(QUERY_INSERT,
				new Object[] { clPropietarioVO.getDescripcion()});

	}

	@Override
	public ClPropietarioVO getPropietario(int id) {
		ClPropietarioVO clPropietarioVO = null;
		try {
			clPropietarioVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_ID, new Object[] { id },
					new ClPropietarioMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return clPropietarioVO;
	}

	@Override
	public List<ClPropietarioVO> getPropietarios() {
		List<ClPropietarioVO> propietarioList = getJdbcTemplate().query(QUERY_GET_ALL, new ClPropietarioMapper());
		return propietarioList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void deletePropietario(int id) throws DataIntegrityViolationException{
		getJdbcTemplate().update(QUERY_DELETE_BY_ID, new Object[] { id });
	}

	@Override
	public void updatePropietario(ClPropietarioVO clPropietarioVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate()
				.update(QUERY_UPDATE_BY_ID,
						new Object[] { clPropietarioVO.getDescripcion(),
						clPropietarioVO.getId() });
	}

	@Override
	public int getId(ClPropietarioVO clPropietarioVO) {

		Integer idPropietario = (Integer) getJdbcTemplate().queryForObject(QUERY_GET_ID,
				new Object[] { clPropietarioVO.getDescripcion() }, Integer.class);
		if (idPropietario != null)
			return idPropietario.intValue();
		return 0;
	}
}
