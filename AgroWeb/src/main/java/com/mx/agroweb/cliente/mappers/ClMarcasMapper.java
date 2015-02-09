package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.mx.agroweb.cliente.vo.ClMarcasVO;

public class ClMarcasMapper implements RowMapper<ClMarcasVO>{

	@Override
	public ClMarcasVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClMarcasVO clMarcasVO = new ClMarcasVO();

		clMarcasVO.setId(rs.getInt(ClMarcasVO.COLUMN_ID));
		clMarcasVO.setDescripcion(rs.getString(ClMarcasVO.COLUMN_DESCRIPCION));
	
		return clMarcasVO;
	}


}
