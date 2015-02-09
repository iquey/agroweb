package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClGrupoMaquinariaVO;

public class ClGrupoMaquinariaMapper implements RowMapper<ClGrupoMaquinariaVO>{

	@Override
	public ClGrupoMaquinariaVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClGrupoMaquinariaVO clGrupoMaquinariaVO = new ClGrupoMaquinariaVO();

		clGrupoMaquinariaVO.setId(rs.getInt(ClGrupoMaquinariaVO.COLUMN_ID));
		clGrupoMaquinariaVO.setDescripcion(rs.getString(ClGrupoMaquinariaVO.COLUMN_DESCRIPCION));
	
		return clGrupoMaquinariaVO;
	}


}
