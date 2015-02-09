package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosVO;

public class ClSubgrupoInsumosMapper implements RowMapper<ClSubgrupoInsumosVO>{

	@Override
	public ClSubgrupoInsumosVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClSubgrupoInsumosVO clSubgrupoInsumosVO = new ClSubgrupoInsumosVO();

		clSubgrupoInsumosVO.setId(rs.getInt(ClSubgrupoInsumosVO.COLUMN_ID));
		clSubgrupoInsumosVO.setDescripcion(rs.getString(ClSubgrupoInsumosVO.COLUMN_DESCRIPCION));
		clSubgrupoInsumosVO.setIdGrupo(rs.getInt(ClSubgrupoInsumosVO.COLUMN_ID_GRUPO));
	
		return clSubgrupoInsumosVO;
	}


}
