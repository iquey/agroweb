package com.mx.agroweb.cliente.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosVO;

public interface ClSubgrupoInsumosDAO {

	
	public final String QUERY_INSERT = "INSERT INTO CAT_SUBGRUPOS_INSUMOS(SGI_DESCRIPCION,SGI_ID_GRUPO) VALUES (?,?)";
	public final String QUERY_GET_BY_ID = "SELECT * FROM CAT_SUBGRUPOS_INSUMOS WHERE BINARY ID = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_SUBGRUPOS_INSUMOS";
	public final String QUERY_DELETE_BY_ID = "DELETE FROM CAT_SUBGRUPOS_INSUMOS WHERE BINARY ID = ?";
	public final String QUERY_UPDATE_BY_ID = "UPDATE CAT_SUBGRUPOS_INSUMOS	SET	SGI_DESCRIPCION = ?,SGI_ID_GRUPO = ? WHERE BINARY ID = ?;";
	public final String QUERY_GET_ID = "SELECT ID FROM CAT_SUBGRUPOS_INSUMOS WHERE BINARY SGI_DESCRIPCION = ? AND SGI_ID_GRUPO = ?";
	
	public void insertSubgrupoInsumos(ClSubgrupoInsumosVO clSubgrupoInsumosVO);

	public ClSubgrupoInsumosVO getSubgrupoInsumos(int id);

	public List<ClSubgrupoInsumosVO> getSubgruposInsumos();

	public void setDinamicDataSource(DataSource dataSource);
	
	public void deleteSubgrupoInsumos(int id) throws DataIntegrityViolationException;
	
	public void updateSubgrupoInsumos(ClSubgrupoInsumosVO clSubgrupoInsumosVO);
	
	public int getId(ClSubgrupoInsumosVO clSubgrupoInsumosVO);
	
}
