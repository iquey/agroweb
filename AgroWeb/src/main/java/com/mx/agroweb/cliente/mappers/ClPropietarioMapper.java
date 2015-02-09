package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClGrupoMaquinariaVO;
import com.mx.agroweb.cliente.vo.ClPropietarioVO;

public class ClPropietarioMapper implements RowMapper<ClPropietarioVO>{

	@Override
	public ClPropietarioVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClPropietarioVO clPropietarioVO = new ClPropietarioVO();

		clPropietarioVO.setId(rs.getInt(ClPropietarioVO.COLUMN_ID));
		clPropietarioVO.setDescripcion(rs.getString(ClPropietarioVO.COLUMN_DESCRIPCION));
	
		return clPropietarioVO;
	}


}
