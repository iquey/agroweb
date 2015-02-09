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
import com.mx.agroweb.cliente.dao.ClProveedorDAO;
import com.mx.agroweb.cliente.dao.ClSubgrupoInsumosDAO;
import com.mx.agroweb.cliente.mappers.ClCentroCostosMapper;
import com.mx.agroweb.cliente.mappers.ClGrupoInsumosMapper;
import com.mx.agroweb.cliente.mappers.ClProveedorMapper;
import com.mx.agroweb.cliente.mappers.ClSubgrupoInsumosMapper;
import com.mx.agroweb.cliente.vo.ClCentroCostosVO;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClProveedorVO;
import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosVO;

@Component
public class ClSubgrupoInsumosDAOImpl extends JdbcDaoSupport implements ClSubgrupoInsumosDAO {

	@Autowired
	public ClSubgrupoInsumosDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertSubgrupoInsumos(ClSubgrupoInsumosVO clSubgrupoInsumosVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(QUERY_INSERT,
				new Object[] { clSubgrupoInsumosVO.getDescripcion(), clSubgrupoInsumosVO.getIdGrupo() });

	}

	@Override
	public ClSubgrupoInsumosVO getSubgrupoInsumos(int id) {
		ClSubgrupoInsumosVO clSubgrupoInsumosVO = null;
		try {
			clSubgrupoInsumosVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_ID, new Object[] { id },
					new ClSubgrupoInsumosMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return clSubgrupoInsumosVO;
	}

	@Override
	public List<ClSubgrupoInsumosVO> getSubgruposInsumos() {
		List<ClSubgrupoInsumosVO> subgrupoInsumosList = getJdbcTemplate().query(QUERY_GET_ALL,
				new ClSubgrupoInsumosMapper());
		return subgrupoInsumosList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void deleteSubgrupoInsumos(int id) throws DataIntegrityViolationException{
		getJdbcTemplate().update(QUERY_DELETE_BY_ID, new Object[] { id });
	}

	@Override
	public void updateSubgrupoInsumos(ClSubgrupoInsumosVO clSubgrupoInsumosVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(
				QUERY_UPDATE_BY_ID,
				new Object[] { clSubgrupoInsumosVO.getDescripcion(), clSubgrupoInsumosVO.getIdGrupo(),
						clSubgrupoInsumosVO.getId() });
	}

	@Override
	public int getId(ClSubgrupoInsumosVO clSubgrupoInsumosVO) {

		Integer idSubGrupo = (Integer) getJdbcTemplate().queryForObject(QUERY_GET_ID,
				new Object[] { clSubgrupoInsumosVO.getDescripcion(), clSubgrupoInsumosVO.getIdGrupo() }, Integer.class);
		if (idSubGrupo != null)
			return idSubGrupo.intValue();
		return 0;
	}
}
