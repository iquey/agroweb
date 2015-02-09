package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;

public class ClGrupoInsumosMapper implements RowMapper<ClGrupoInsumosVO>{

	@Override
	public ClGrupoInsumosVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClGrupoInsumosVO clGrupoInsumosVO = new ClGrupoInsumosVO();

		clGrupoInsumosVO.setId(rs.getInt(ClGrupoInsumosVO.COLUMN_ID));
		clGrupoInsumosVO.setDescripcion(rs.getString(ClGrupoInsumosVO.COLUMN_DESCRIPCION));
		clGrupoInsumosVO.setOrden(rs.getString(ClGrupoInsumosVO.COLUMN_ORDEN));
	
		return clGrupoInsumosVO;
	}


}
