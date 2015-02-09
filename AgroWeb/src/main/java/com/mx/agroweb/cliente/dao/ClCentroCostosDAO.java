package com.mx.agroweb.cliente.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClCentroCostosVO;

public interface ClCentroCostosDAO {

	public final String QUERY_INSERT = "INSERT INTO CAT_CENTRO_COSTOS(CC_DESCRIPCION) VALUES (?)";
	public final String QUERY_GET_BY_ID = "SELECT * FROM CAT_CENTRO_COSTOS WHERE BINARY ID = ?";
	public final String QUERY_GET_ID = "SELECT ID FROM CAT_CENTRO_COSTOS WHERE BINARY CC_DESCRIPCION = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_CENTRO_COSTOS";
	public final String QUERY_DELETE_BY_ID = "DELETE FROM CAT_CENTRO_COSTOS WHERE BINARY ID = ?";
	public final String QUERY_UPDATE_BY_ID = "UPDATE CAT_CENTRO_COSTOS	SET	CC_DESCRIPCION = ? WHERE BINARY ID = ?;";

	public void insertCentroCostos(ClCentroCostosVO clCentroCostosVO);

	public ClCentroCostosVO getCentroCostos(int id);

	public List<ClCentroCostosVO> getCentrosCostos();

	public void setDinamicDataSource(DataSource dataSource);

	public void deleteCentroCostos(int id) throws DataIntegrityViolationException;

	public void updateCentroCostos(ClCentroCostosVO clCentroCostosVO);

	public int getId(ClCentroCostosVO clCentroCostosVO);

}
