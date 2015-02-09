package com.mx.agroweb.cliente.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.mx.agroweb.cliente.dao.ClTipoCambioDAO;
import com.mx.agroweb.cliente.mappers.ClTipoCambioMapper;
import com.mx.agroweb.cliente.vo.ClTipoCambioVO;

@Component
public class ClTipoCambioDAOImpl extends JdbcDaoSupport implements ClTipoCambioDAO {

	@Autowired
	public ClTipoCambioDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertTipoCambio(ClTipoCambioVO clTipoCambioVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(QUERY_INSERT,
				new Object[] { clTipoCambioVO.getFecha(), clTipoCambioVO.getTipoCambio() });

	}

	@Override
	public ClTipoCambioVO getTipoCambio(int id) {
		ClTipoCambioVO clTipoCambioVO = null;
		try {
			clTipoCambioVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_ID, new Object[] { id },
					new ClTipoCambioMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return clTipoCambioVO;
	}

	@Override
	public List<ClTipoCambioVO> getTiposCambio() {
		List<ClTipoCambioVO> TipoCambioList = getJdbcTemplate().query(QUERY_GET_ALL, new ClTipoCambioMapper());
		return TipoCambioList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void deleteTipoCambio(int id) throws DataIntegrityViolationException{
		getJdbcTemplate().update(QUERY_DELETE_BY_ID, new Object[] { id });
	}

	@Override
	public void updateTipoCambio(ClTipoCambioVO clTipoCambioVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate()
				.update(QUERY_UPDATE_BY_ID,
						new Object[] { clTipoCambioVO.getFecha(), clTipoCambioVO.getTipoCambio(),
								clTipoCambioVO.getId() });
	}

	@Override
	public int getId(ClTipoCambioVO clTipoCambioVO) {

		Integer idGrupoInsumo = (Integer) getJdbcTemplate().queryForObject(QUERY_GET_ID,
				new Object[] { clTipoCambioVO.getFecha(), clTipoCambioVO.getTipoCambio() }, Integer.class);
		if (idGrupoInsumo != null)
			return idGrupoInsumo.intValue();
		return 0;
	}
}
