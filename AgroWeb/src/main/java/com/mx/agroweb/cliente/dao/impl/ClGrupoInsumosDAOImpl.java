package com.mx.agroweb.cliente.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.mx.agroweb.cliente.dao.ClGrupoInsumosDAO;
import com.mx.agroweb.cliente.mappers.ClGrupoInsumosMapper;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;

@Component
public class ClGrupoInsumosDAOImpl extends JdbcDaoSupport implements ClGrupoInsumosDAO {

	@Autowired
	public ClGrupoInsumosDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertGrupoInsumos(ClGrupoInsumosVO clGrupoInsumosVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(QUERY_INSERT,
				new Object[] { clGrupoInsumosVO.getDescripcion(), clGrupoInsumosVO.getOrden() });

	}

	@Override
	public ClGrupoInsumosVO getGrupoInsumos(int id) {
		ClGrupoInsumosVO clGrupoInsumosVO = null;
		try {
			clGrupoInsumosVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_ID, new Object[] { id },
					new ClGrupoInsumosMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return clGrupoInsumosVO;
	}

	@Override
	public List<ClGrupoInsumosVO> getGruposInsumos() {
		List<ClGrupoInsumosVO> grupoInsumosList = getJdbcTemplate().query(QUERY_GET_ALL, new ClGrupoInsumosMapper());
		return grupoInsumosList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void deleteGrupoInsumos(int id) throws DataIntegrityViolationException {
		getJdbcTemplate().update(QUERY_DELETE_BY_ID, new Object[] { id });
	}

	@Override
	public void updateGrupoInsumos(ClGrupoInsumosVO clGrupoInsumosVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate()
				.update(QUERY_UPDATE_BY_ID,
						new Object[] { clGrupoInsumosVO.getDescripcion(), clGrupoInsumosVO.getOrden(),
								clGrupoInsumosVO.getId() });
	}

	@Override
	public int getId(ClGrupoInsumosVO clGrupoInsumosVO) {

		Integer idGrupoInsumo = (Integer) getJdbcTemplate().queryForObject(QUERY_GET_ID,
				new Object[] { clGrupoInsumosVO.getDescripcion(), clGrupoInsumosVO.getOrden() }, Integer.class);
		if (idGrupoInsumo != null)
			return idGrupoInsumo.intValue();
		return 0;
	}
}
