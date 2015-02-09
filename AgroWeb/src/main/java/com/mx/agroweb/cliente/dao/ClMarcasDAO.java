package com.mx.agroweb.cliente.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClMarcasVO;

public interface ClMarcasDAO {

	
	public final String QUERY_INSERT = "INSERT INTO CAT_MARCAS(marc_descripcion) VALUES (?)";
	public final String QUERY_GET_BY_ID = "SELECT * FROM CAT_MARCAS WHERE BINARY ID = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_MARCAS";
	public final String QUERY_DELETE_BY_ID = "DELETE FROM CAT_MARCAS WHERE BINARY ID = ?";
	public final String QUERY_UPDATE_BY_ID = "UPDATE CAT_MARCAS	SET	marc_descripcion = ? WHERE BINARY ID = ?";
	public final String QUERY_GET_ID = "SELECT ID FROM CAT_MARCAS WHERE BINARY marc_descripcion = ?";
	
	
	
	public void insertMarca(ClMarcasVO clMarcasVO);

	public ClMarcasVO getMarca(int id);

	public List<ClMarcasVO> getMarcas();

	public void setDinamicDataSource(DataSource dataSource);
	
	public void deleteMarca(int id) throws DataIntegrityViolationException;
	
	public void updateMarca(ClMarcasVO clMarcasVO);
	
	public int getId(ClMarcasVO clMarcasVO);
}
