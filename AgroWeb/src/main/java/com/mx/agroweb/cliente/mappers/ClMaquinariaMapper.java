package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.agroweb.cliente.vo.ClMaquinariaVO;

public class ClMaquinariaMapper implements RowMapper<ClMaquinariaVO> {

	@Override
	public ClMaquinariaVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClMaquinariaVO clMaquinariaVO = new ClMaquinariaVO();

		clMaquinariaVO.setId(rs.getInt(ClMaquinariaVO.COLUMN_ID));
		clMaquinariaVO.setDescripcion(rs.getString(ClMaquinariaVO.COLUMN_DESCRIPCION));
		clMaquinariaVO.setAduanalesDlls(rs.getString(ClMaquinariaVO.COLUMN_ADUANALES_DLLS));
		clMaquinariaVO.setAduanalesPesos(rs.getString(ClMaquinariaVO.COLUMN_ADUANALES_PESOS));
		clMaquinariaVO.setAnio(rs.getString(ClMaquinariaVO.COLUMN_ANIO));
		clMaquinariaVO.setCapacidadMotor(rs.getString(ClMaquinariaVO.COLUMN_CAPACIDAD_MOTOR));
		clMaquinariaVO.setCodigo(rs.getString(ClMaquinariaVO.COLUMN_CODIGO));
		clMaquinariaVO.setComprador(rs.getString(ClMaquinariaVO.COLUMN_COMPRADOR));
		clMaquinariaVO.setCostoBrokerDlls(rs.getString(ClMaquinariaVO.COLUMN_COSTO_BROKER_DLLS));
		clMaquinariaVO.setCostoBrokerPesos(rs.getString(ClMaquinariaVO.COLUMN_COSTO_BROKER_PESOS));
		clMaquinariaVO.setCostoHora1(rs.getString(ClMaquinariaVO.COLUMN_COSTO_HORA1));
		clMaquinariaVO.setCostoHora2(rs.getString(ClMaquinariaVO.COLUMN_COSTO_HORA2));
		clMaquinariaVO.setCostoHora3(rs.getString(ClMaquinariaVO.COLUMN_COSTO_HORA3));
		clMaquinariaVO.setCostoHora4(rs.getString(ClMaquinariaVO.COLUMN_COSTO_HORA4));
		clMaquinariaVO.setFechaCompra(rs.getString(ClMaquinariaVO.COLUMN_FECHA_COMPRA));
		clMaquinariaVO.setFechaVenta(rs.getString(ClMaquinariaVO.COLUMN_FECHA_VENTA));
		clMaquinariaVO.setFleteAmericanoDlls(rs.getString(ClMaquinariaVO.COLUMN_FLETE_AMERICANO_DLLS));
		clMaquinariaVO.setFleteAmericanoPesos(rs.getString(ClMaquinariaVO.COLUMN_FLETE_AMERICANO_PESOS));
		clMaquinariaVO.setFleteMexicanoDlls(rs.getString(ClMaquinariaVO.COLUMN_FLETE_MEXICANO_DLLS));
		clMaquinariaVO.setFleteMexicanoPesos(rs.getString(ClMaquinariaVO.COLUMN_FLETE_MEXICANO_PESOS));
		clMaquinariaVO.setFoto(rs.getBytes(ClMaquinariaVO.COLUMN_FOTO));
		clMaquinariaVO.setHorometroCompra(rs.getString(ClMaquinariaVO.COLUMN_HOROMETRO_COMPRA));
		clMaquinariaVO.setHorometroInicial(rs.getString(ClMaquinariaVO.COLUMN_HOROMETRO_INICIAL));
		clMaquinariaVO.setIdGrupo(rs.getInt(ClMaquinariaVO.COLUMN_ID_GRUPO));
		clMaquinariaVO.setIdMarca(rs.getInt(ClMaquinariaVO.COLUMN_ID_MARCA));
		clMaquinariaVO.setIdPropietario(rs.getInt(ClMaquinariaVO.COLUMN_ID_PROPIETARIO));
		clMaquinariaVO.setIdProveedor(rs.getInt(ClMaquinariaVO.COLUMN_ID_PROVEEDOR));
		clMaquinariaVO.setIdRancho(rs.getInt(ClMaquinariaVO.COLUMN_ID_RANCHO));
		clMaquinariaVO.setIdTipoCambio(rs.getInt(ClMaquinariaVO.COLUMN_ID_TIPO_CAMBIO));
		clMaquinariaVO.setImpuestosMexicanosDlls(rs.getString(ClMaquinariaVO.COLUMN_IMPUESTOS_MEXICANOS_DLLS));
		clMaquinariaVO.setImpuestosMexicanosPesos(rs.getString(ClMaquinariaVO.COLUMN_IMPUESTOS_MEXICANOS_PESOS));
		clMaquinariaVO.setModelo(rs.getString(ClMaquinariaVO.COLUMN_MODELO));
		clMaquinariaVO.setNumSerie(rs.getString(ClMaquinariaVO.COLUMN_NUM_SERIE));
		clMaquinariaVO.setNumSerieMotor(rs.getString(ClMaquinariaVO.COLUMN_NUM_SERIE_MOTOR));
		clMaquinariaVO.setNumTransmision(rs.getString(ClMaquinariaVO.COLUMN_NUM_TRANSMISION));
		clMaquinariaVO.setObservaciones(rs.getString(ClMaquinariaVO.COLUMN_OBSERVACIONES));
		clMaquinariaVO.setOtrosGastosDlls(rs.getString(ClMaquinariaVO.COLUMN_OTROS_GASTOS_DLLS));
		clMaquinariaVO.setOtrosGastosPesos(rs.getString(ClMaquinariaVO.COLUMN_OTROS_GASTOS_PESOS));
		clMaquinariaVO.setPedimientoImportacion(rs.getString(ClMaquinariaVO.COLUMN_PEDIMIENTO_IMPORTACION));
		clMaquinariaVO.setPrecioCompraDlls(rs.getString(ClMaquinariaVO.COLUMN_PRECIO_COMPRA_DLLS));
		clMaquinariaVO.setPrecioCompraPesos(rs.getString(ClMaquinariaVO.COLUMN_PRECIO_COMPRA_PESOS));
		clMaquinariaVO.setPrecioVenta(rs.getString(ClMaquinariaVO.COLUMN_PRECIO_VENTA));
		clMaquinariaVO.setSeguroDlls(rs.getString(ClMaquinariaVO.COLUMN_SEGURO_DLLS));
		clMaquinariaVO.setSeguroPesos(rs.getString(ClMaquinariaVO.COLUMN_SEGURO_PESOS));

		return clMaquinariaVO;
	}

}
