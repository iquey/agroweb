package com.mx.agroweb.admin.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.agroweb.admin.vo.LicenciaVO;

public class LicenciaMapper implements RowMapper<LicenciaVO> {

	@Override
	public LicenciaVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		LicenciaVO licenciaVO = new LicenciaVO();

		licenciaVO.setId(rs.getInt(LicenciaVO.COLUMN_ID));
		licenciaVO.setNombreBase(rs.getString(LicenciaVO.COLUMN_NOMBRE_BASE));
		licenciaVO.setDireccionMac(rs.getString(LicenciaVO.COLUMN_DIRECCION_MAC));
		licenciaVO.setUsuario(rs.getString(LicenciaVO.COLUMN_USUARIO));
		licenciaVO.setContrasena(rs.getString(LicenciaVO.COLUMN_CONTRASENA));
		licenciaVO.setFechaInicio(rs.getString(LicenciaVO.COLUMN_FECHA_INICIO));
		licenciaVO.setFechaFin(rs.getString(LicenciaVO.COLUMN_FECHA_FIN));
		licenciaVO.setIdCliente(rs.getInt(LicenciaVO.COLUMN_ID_CLIENTE));
		licenciaVO.setIdTipoLicencia(rs.getInt(LicenciaVO.COLUMN_ID_TIPO_LICENCIA));
		return licenciaVO;
	}
}
