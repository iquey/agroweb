package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.agroweb.cliente.vo.ClCentroCostosVO;

public class ClCentroCostosMapper implements RowMapper<ClCentroCostosVO>{

	@Override
	public ClCentroCostosVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClCentroCostosVO clCentroCostosVO = new ClCentroCostosVO();

		clCentroCostosVO.setId(rs.getInt(ClCentroCostosVO.COLUMN_ID));
		clCentroCostosVO.setDescripcion(rs.getString(ClCentroCostosVO.COLUMN_DESCRIPCION));
	
		return clCentroCostosVO;
	}


}
