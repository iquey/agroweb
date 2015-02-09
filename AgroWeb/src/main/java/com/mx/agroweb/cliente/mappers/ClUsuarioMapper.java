package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.agroweb.admin.vo.CatUsuarioVO;
import com.mx.agroweb.cliente.vo.ClUsuarioVO;

public class ClUsuarioMapper implements RowMapper<ClUsuarioVO>{

	@Override
	public ClUsuarioVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClUsuarioVO clUsuarioVO = new ClUsuarioVO();

		clUsuarioVO.setId(rs.getInt(CatUsuarioVO.COLUMN_ID));
		clUsuarioVO.setUsuario(rs.getString(ClUsuarioVO.COLUMN_USUARIO));
		clUsuarioVO.setPassword(rs.getString(ClUsuarioVO.COLUMN_PASSWORD));
		clUsuarioVO.setFechaAlta(rs.getString(ClUsuarioVO.COLUMN_FECHA_ALTA));
		clUsuarioVO.setIdEstatus(rs.getInt(ClUsuarioVO.COLUMN_ID_ESTATUS));

		return clUsuarioVO;
	}

}
