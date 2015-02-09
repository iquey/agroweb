package com.mx.agroweb.cliente.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.mx.agroweb.cliente.dao.ClInsumosDAO;
import com.mx.agroweb.cliente.mappers.ClInsumosMapper;
import com.mx.agroweb.cliente.vo.ClInsumosVO;

@Component
public class ClInsumosDAOImpl extends JdbcDaoSupport implements ClInsumosDAO {

	@Autowired
	public ClInsumosDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertInsumos(ClInsumosVO clInsumosVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(
				QUERY_INSERT,
				new Object[] {clInsumosVO.getIdSubgrupo(),clInsumosVO.getDescripcion(),clInsumosVO.getIdUnidadCompra(),
						clInsumosVO.getCostoCompra(),clInsumosVO.getIdUnidadSalida(),clInsumosVO.getCostoSalida(),clInsumosVO.getPorcentajeSalida(),
						clInsumosVO.getIdCentroCostos(),clInsumosVO.getFactorConversion(),clInsumosVO.getCuentaContable()});

	}

	@Override
	public ClInsumosVO getInsumo(int id) {
		ClInsumosVO clInsumosVO = null;
		try {
			clInsumosVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_ID, new Object[] { id },
					new ClInsumosMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return clInsumosVO;
	}

	@Override
	public List<ClInsumosVO> getInsumos() {
		List<ClInsumosVO> insumosList = getJdbcTemplate().query(QUERY_GET_ALL, new ClInsumosMapper());
		return insumosList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void deleteInsumos(int id) throws DataIntegrityViolationException{
		getJdbcTemplate().update(QUERY_DELETE_BY_ID, new Object[] { id });
	}

	@Override
	public void updateInsumos(ClInsumosVO clInsumosVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(
				QUERY_UPDATE_BY_ID,
				new Object[] {clInsumosVO.getIdSubgrupo(),clInsumosVO.getDescripcion(),clInsumosVO.getIdUnidadCompra(),
						clInsumosVO.getCostoCompra(),clInsumosVO.getIdUnidadSalida(),clInsumosVO.getCostoSalida(),clInsumosVO.getPorcentajeSalida(),
						clInsumosVO.getIdCentroCostos(),clInsumosVO.getFactorConversion(),clInsumosVO.getCuentaContable(), clInsumosVO.getId()});
	}
}
