package com.mx.agroweb.cliente.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.mx.agroweb.cliente.dao.ClMaquinariaDAO;
import com.mx.agroweb.cliente.mappers.ClMaquinariaMapper;
import com.mx.agroweb.cliente.vo.ClMaquinariaVO;

@Component
public class ClMaquinariaDAOImpl extends JdbcDaoSupport implements ClMaquinariaDAO {

	@Autowired
	public ClMaquinariaDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertMaquinaria(ClMaquinariaVO clMaquinariaVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(
				QUERY_INSERT,
				new Object[] { clMaquinariaVO.getIdGrupo(), clMaquinariaVO.getCodigo(),
						clMaquinariaVO.getDescripcion(), clMaquinariaVO.getIdMarca(), clMaquinariaVO.getAnio(),
						clMaquinariaVO.getModelo(), clMaquinariaVO.getIdPropietario(), clMaquinariaVO.getNumSerie(),
						clMaquinariaVO.getNumTransmision(), clMaquinariaVO.getNumSerieMotor(),
						clMaquinariaVO.getCapacidadMotor(), clMaquinariaVO.getFechaCompra(),
						clMaquinariaVO.getIdRancho(), clMaquinariaVO.getFoto(), clMaquinariaVO.getCostoHora1(),
						clMaquinariaVO.getCostoHora2(), clMaquinariaVO.getCostoHora3(), clMaquinariaVO.getCostoHora4(),
						clMaquinariaVO.getHorometroCompra(), clMaquinariaVO.getHorometroInicial(),
						clMaquinariaVO.getIdTipoCambio(), clMaquinariaVO.getPedimientoImportacion(),
						clMaquinariaVO.getIdProveedor(), clMaquinariaVO.getObservaciones(),
						clMaquinariaVO.getFechaVenta(), clMaquinariaVO.getComprador(), clMaquinariaVO.getPrecioVenta(),
						clMaquinariaVO.getPrecioCompraPesos(), clMaquinariaVO.getPrecioCompraDlls(),
						clMaquinariaVO.getFleteAmericanoPesos(), clMaquinariaVO.getFleteAmericanoDlls(),
						clMaquinariaVO.getCostoBrokerPesos(), clMaquinariaVO.getCostoBrokerDlls(),
						clMaquinariaVO.getAduanalesPesos(), clMaquinariaVO.getAduanalesDlls(),
						clMaquinariaVO.getImpuestosMexicanosPesos(), clMaquinariaVO.getImpuestosMexicanosDlls(),
						clMaquinariaVO.getFleteMexicanoPesos(), clMaquinariaVO.getFleteMexicanoDlls(),
						clMaquinariaVO.getSeguroPesos(), clMaquinariaVO.getSeguroDlls(),
						clMaquinariaVO.getOtrosGastosPesos(), clMaquinariaVO.getOtrosGastosDlls() });
	}

	@Override
	public ClMaquinariaVO getMaquinaria(int id) {
		ClMaquinariaVO clMaquinariaVO = null;
		try {
			clMaquinariaVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_ID, new Object[] { id },
					new ClMaquinariaMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return clMaquinariaVO;
	}

	@Override
	public List<ClMaquinariaVO> getMaquinarias() {
		List<ClMaquinariaVO> MaquinariaList = getJdbcTemplate().query(QUERY_GET_ALL, new ClMaquinariaMapper());
		return MaquinariaList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void deleteMaquinaria(int id) {
		getJdbcTemplate().update(QUERY_DELETE_BY_ID, new Object[] { id });
	}

	@Override
	public void updateMaquinaria(ClMaquinariaVO clMaquinariaVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(
				QUERY_UPDATE_BY_ID,
				new Object[] { clMaquinariaVO.getIdGrupo(), clMaquinariaVO.getCodigo(),
						clMaquinariaVO.getDescripcion(), clMaquinariaVO.getIdMarca(), clMaquinariaVO.getAnio(),
						clMaquinariaVO.getModelo(), clMaquinariaVO.getIdPropietario(), clMaquinariaVO.getNumSerie(),
						clMaquinariaVO.getNumTransmision(), clMaquinariaVO.getNumSerieMotor(),
						clMaquinariaVO.getCapacidadMotor(), clMaquinariaVO.getFechaCompra(),
						clMaquinariaVO.getIdRancho(), clMaquinariaVO.getFoto(), clMaquinariaVO.getCostoHora1(),
						clMaquinariaVO.getCostoHora2(), clMaquinariaVO.getCostoHora3(), clMaquinariaVO.getCostoHora4(),
						clMaquinariaVO.getHorometroCompra(), clMaquinariaVO.getHorometroInicial(),
						clMaquinariaVO.getIdTipoCambio(), clMaquinariaVO.getPedimientoImportacion(),
						clMaquinariaVO.getIdProveedor(), clMaquinariaVO.getObservaciones(),
						clMaquinariaVO.getFechaVenta(), clMaquinariaVO.getComprador(), clMaquinariaVO.getPrecioVenta(),
						clMaquinariaVO.getPrecioCompraPesos(), clMaquinariaVO.getPrecioCompraDlls(),
						clMaquinariaVO.getFleteAmericanoPesos(), clMaquinariaVO.getFleteAmericanoDlls(),
						clMaquinariaVO.getCostoBrokerPesos(), clMaquinariaVO.getCostoBrokerDlls(),
						clMaquinariaVO.getAduanalesPesos(), clMaquinariaVO.getAduanalesDlls(),
						clMaquinariaVO.getImpuestosMexicanosPesos(), clMaquinariaVO.getImpuestosMexicanosDlls(),
						clMaquinariaVO.getFleteMexicanoPesos(), clMaquinariaVO.getFleteMexicanoDlls(),
						clMaquinariaVO.getSeguroPesos(), clMaquinariaVO.getSeguroDlls(),
						clMaquinariaVO.getOtrosGastosPesos(), clMaquinariaVO.getOtrosGastosDlls(),
						clMaquinariaVO.getId() });
	}
}
