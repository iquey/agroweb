package com.mx.agroweb.admin.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.agroweb.admin.vo.CatUsuarioVO;

public class CatUsuarioMapper implements RowMapper<CatUsuarioVO> {

	@Override
	public CatUsuarioVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		CatUsuarioVO catUsuarioVO = new CatUsuarioVO();

		catUsuarioVO.setId(rs.getInt(CatUsuarioVO.COLUMN_ID));
		catUsuarioVO.setUsuario(rs.getString(CatUsuarioVO.COLUMN_USUARIO));
		catUsuarioVO.setPassword(rs.getString(CatUsuarioVO.COLUMN_PASSWORD));
		catUsuarioVO.setFechaAlta(rs.getString(CatUsuarioVO.COLUMN_FECHA_ALTA));
		catUsuarioVO.setIdEstatus(rs.getInt(CatUsuarioVO.COLUMN_ID_ESTATUS));
		catUsuarioVO.setIdLicencia(rs.getInt(CatUsuarioVO.COLUMN_ID_LICENCIA));

		return catUsuarioVO;
	}
}
