package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.mx.agroweb.cliente.vo.ClZonasVO;

public class ClZonasMapper implements RowMapper<ClZonasVO>{

	@Override
	public ClZonasVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClZonasVO clZonasVO = new ClZonasVO();

		clZonasVO.setId(rs.getInt(ClZonasVO.COLUMN_ID));
		clZonasVO.setDescripcion(rs.getString(ClZonasVO.COLUMN_DESCRIPCION));
	
		return clZonasVO;
	}


}
