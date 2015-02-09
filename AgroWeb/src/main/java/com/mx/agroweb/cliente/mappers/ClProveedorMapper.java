package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.mx.agroweb.cliente.vo.ClProveedorVO;

public class ClProveedorMapper implements RowMapper<ClProveedorVO>{

	@Override
	public ClProveedorVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClProveedorVO clProovedorVO = new ClProveedorVO();

		clProovedorVO.setId(rs.getInt(ClProveedorVO.COLUMN_ID));
		clProovedorVO.setNombre(rs.getString(ClProveedorVO.COLUMN_NOMBRE));
		clProovedorVO.setNombreCompleto(rs.getString(ClProveedorVO.COLUMN_NOMBRE_COMPLETO));
		clProovedorVO.setCelular(rs.getString(ClProveedorVO.COLUMN_CELULAR));
		clProovedorVO.setCiudad(rs.getString(ClProveedorVO.COLUMN_CIUDAD));
		clProovedorVO.setCodigoPostal(rs.getString(ClProveedorVO.COLUMN_CODIGO_POSTAL));
		clProovedorVO.setColonia(rs.getString(ClProveedorVO.COLUMN_COLONIA));
		clProovedorVO.setCurp(rs.getString(ClProveedorVO.COLUMN_CURP));
		clProovedorVO.setDireccion(rs.getString(ClProveedorVO.COLUMN_DIRECCION));
		clProovedorVO.setEmail(rs.getString(ClProveedorVO.COLUMN_EMAIL));
		clProovedorVO.setEstado(rs.getString(ClProveedorVO.COLUMN_ESTADO));
		clProovedorVO.setIdTipo(rs.getInt(ClProveedorVO.COLUMN_ID_TIPO));
		clProovedorVO.setRfc(rs.getString(ClProveedorVO.COLUMN_RFC));
		clProovedorVO.setTelefono(rs.getString(ClProveedorVO.COLUMN_TELEFONO));
		clProovedorVO.setTelefono1(rs.getString(ClProveedorVO.COLUMN_TELEFONO1));
		clProovedorVO.setFechaAlta(rs.getString(ClProveedorVO.COLUMN_FECHA_ALTA));
		clProovedorVO.setIdEstatus(rs.getInt(ClProveedorVO.COLUMN_ID_ESTATUS));

		return clProovedorVO;
	}


}
