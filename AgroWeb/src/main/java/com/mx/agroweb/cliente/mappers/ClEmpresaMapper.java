package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.mx.agroweb.cliente.vo.ClEmpresaVO;

public class ClEmpresaMapper implements RowMapper<ClEmpresaVO> {

	@Override
	public ClEmpresaVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClEmpresaVO clEmpresaVO = new ClEmpresaVO();

		clEmpresaVO.setId(rs.getInt(ClEmpresaVO.COLUMN_ID));
		clEmpresaVO.setNombre(rs.getString(ClEmpresaVO.COLUMN_NOMBRE));
		clEmpresaVO.setDireccion(rs.getString(ClEmpresaVO.COLUMN_DIRECCION));
		
		return clEmpresaVO;
	}

}
