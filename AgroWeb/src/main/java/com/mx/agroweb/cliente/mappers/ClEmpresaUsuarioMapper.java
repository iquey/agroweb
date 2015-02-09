package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.mx.agroweb.cliente.vo.ClEmpresaUsuarioVO;

public class ClEmpresaUsuarioMapper implements RowMapper<ClEmpresaUsuarioVO>{

	@Override
	public ClEmpresaUsuarioVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClEmpresaUsuarioVO clEmpresaUsuarioVO = new ClEmpresaUsuarioVO();

		clEmpresaUsuarioVO.setId(rs.getInt(ClEmpresaUsuarioVO.COLUMN_ID));
		clEmpresaUsuarioVO.setIdUsuario(rs.getInt(ClEmpresaUsuarioVO.COLUMN_ID_USUARIO));
		clEmpresaUsuarioVO.setIdEmpresa(rs.getInt(ClEmpresaUsuarioVO.COLUMN_ID_EMPRESA));
	
		return clEmpresaUsuarioVO;
	}

}
