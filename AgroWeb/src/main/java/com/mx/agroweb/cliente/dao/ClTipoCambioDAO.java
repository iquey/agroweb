package com.mx.agroweb.cliente.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClTipoCambioVO;

public interface ClTipoCambioDAO {

	
	public final String QUERY_INSERT = "INSERT INTO CAT_TIPO_CAMBIO(TCAM_FECHA,TCAM_TIPO_CAMBIO) VALUES (?,?)";
	public final String QUERY_GET_BY_ID = "SELECT * FROM CAT_TIPO_CAMBIO WHERE BINARY ID = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_TIPO_CAMBIO";
	public final String QUERY_DELETE_BY_ID = "DELETE FROM CAT_TIPO_CAMBIO WHERE BINARY ID = ?";
	public final String QUERY_UPDATE_BY_ID = "UPDATE CAT_TIPO_CAMBIO	SET	TCAM_FECHA = ?,TCAM_TIPO_CAMBIO = ? WHERE BINARY ID = ?";
	public final String QUERY_GET_ID = "SELECT ID FROM CAT_TIPO_CAMBIO WHERE BINARY TCAM_FECHA = ? AND TCAM_TIPO_CAMBIO = ?";
	
	
	
	public void insertTipoCambio(ClTipoCambioVO clTipoCambioVO);

	public ClTipoCambioVO getTipoCambio(int id);

	public List<ClTipoCambioVO> getTiposCambio();

	public void setDinamicDataSource(DataSource dataSource);
	
	public void deleteTipoCambio(int id) throws DataIntegrityViolationException;
	
	public void updateTipoCambio(ClTipoCambioVO clTipoCambioVO);
	
	public int getId(ClTipoCambioVO clTipoCambioVO);
}
