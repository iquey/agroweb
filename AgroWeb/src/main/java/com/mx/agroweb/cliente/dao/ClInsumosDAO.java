package com.mx.agroweb.cliente.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClInsumosVO;

public interface ClInsumosDAO {

	
	public final String QUERY_INSERT = "INSERT INTO CAT_INSUMOS(INS_ID_SUBGRUPO,INS_DESCRIPCION,INS_ID_UNIDAD_COMPRA,INS_COSTO_COMPRA,INS_ID_UNIDAD_SALIDA,INS_COSTO_SALIDA,INS_PORCENTAJE_SALIDA,INS_ID_CENTRO_COSTOS,INS_FACTOR_CONVERSION,ins_cuenta_contable) VALUES (?,?,?,?,?,?,?,?,?,?)";
	public final String QUERY_GET_BY_ID = "SELECT * FROM CAT_INSUMOS WHERE BINARY ID = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_INSUMOS";
	public final String QUERY_DELETE_BY_ID = "DELETE FROM CAT_INSUMOS WHERE BINARY ID = ?";
	public final String QUERY_UPDATE_BY_ID = "UPDATE CAT_INSUMOS SET INS_ID_SUBGRUPO = ?, INS_DESCRIPCION = ?, INS_ID_UNIDAD_COMPRA = ?, INS_COSTO_COMPRA = ?, INS_ID_UNIDAD_SALIDA = ?, INS_COSTO_SALIDA = ?, INS_PORCENTAJE_SALIDA = ?, INS_ID_CENTRO_COSTOS = ?, INS_FACTOR_CONVERSION = ?, ins_cuenta_contable = ?	WHERE BINARY ID = ?;";
	
	
	public void insertInsumos(ClInsumosVO clInsumosVO);

	public ClInsumosVO getInsumo(int id);

	public List<ClInsumosVO> getInsumos();

	public void setDinamicDataSource(DataSource dataSource);
	
	public void deleteInsumos(int id) throws DataIntegrityViolationException;
	
	public void updateInsumos(ClInsumosVO clInsumosVO);
	
}
