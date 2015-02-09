package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.agroweb.cliente.vo.ClInsumosVO;

public class ClInsumosMapper implements RowMapper<ClInsumosVO> {

	@Override
	public ClInsumosVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClInsumosVO clInsumosVO = new ClInsumosVO();

		clInsumosVO.setId(rs.getInt(ClInsumosVO.COLUMN_ID));
		clInsumosVO.setDescripcion(rs.getString(ClInsumosVO.COLUMN_DESCRIPCION));
		clInsumosVO.setCostoCompra(rs.getString(ClInsumosVO.COLUMN_COSTO_COMPRA));
		clInsumosVO.setCostoSalida(rs.getString(ClInsumosVO.COLUMN_COSTO_SALIDA));
		clInsumosVO.setCuentaContable(rs.getString(ClInsumosVO.COLUMN_CUENTA_CONTABLE));
		clInsumosVO.setFactorConversion(rs.getString(ClInsumosVO.COLUMN_FACTOR_CONVERSION));
		clInsumosVO.setIdCentroCostos(rs.getInt(ClInsumosVO.COLUMN_ID_CENTRO_COSTOS));
		clInsumosVO.setIdSubgrupo(rs.getInt(ClInsumosVO.COLUMN_ID_SUBGRUPO));
		clInsumosVO.setIdUnidadCompra(rs.getInt(ClInsumosVO.COLUMN_ID_UNIDAD_COMPRA));
		clInsumosVO.setIdUnidadSalida(rs.getInt(ClInsumosVO.COLUMN_ID_UNIDAD_SALIDA));
		clInsumosVO.setPorcentajeSalida(rs.getString(ClInsumosVO.COLUMN_PORCENTAJE_SALIDA));

		return clInsumosVO;
	}

}
