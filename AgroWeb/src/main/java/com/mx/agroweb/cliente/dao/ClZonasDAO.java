package com.mx.agroweb.cliente.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClZonasVO;

public interface ClZonasDAO {

	
	public final String QUERY_INSERT = "INSERT INTO CAT_ZONAS(zon_descripcion) VALUES (?)";
	public final String QUERY_GET_BY_ID = "SELECT * FROM CAT_ZONAS WHERE BINARY ID = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_ZONAS";
	public final String QUERY_DELETE_BY_ID = "DELETE FROM CAT_ZONAS WHERE BINARY ID = ?";
	public final String QUERY_UPDATE_BY_ID = "UPDATE CAT_ZONAS	SET	zon_descripcion = ? WHERE BINARY ID = ?";
	public final String QUERY_GET_ID = "SELECT ID FROM CAT_ZONAS WHERE BINARY zon_descripcion = ?";
	
	
	
	public void insertZona(ClZonasVO clZonasVO);

	public ClZonasVO getZona(int id);

	public List<ClZonasVO> getZonas();

	public void setDinamicDataSource(DataSource dataSource);
	
	public void deleteZona(int id) throws DataIntegrityViolationException;
	
	public void updateZona(ClZonasVO clZonasVO);
	
	public int getId(ClZonasVO clZonasVO);
}
