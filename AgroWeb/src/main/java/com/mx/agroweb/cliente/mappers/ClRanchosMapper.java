package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.agroweb.cliente.vo.ClRanchosVO;

public class ClRanchosMapper implements RowMapper<ClRanchosVO>{

	@Override
	public ClRanchosVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClRanchosVO clRanchosVO = new ClRanchosVO();

		clRanchosVO.setId(rs.getInt(ClRanchosVO.COLUMN_ID));
		clRanchosVO.setDescripcion(rs.getString(ClRanchosVO.COLUMN_DESCRIPCION));
		clRanchosVO.setIdZona(rs.getInt(ClRanchosVO.COLUMN_ID_ZONA));
	
		return clRanchosVO;
	}


}
