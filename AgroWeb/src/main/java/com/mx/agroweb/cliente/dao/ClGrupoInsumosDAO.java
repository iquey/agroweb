package com.mx.agroweb.cliente.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;

public interface ClGrupoInsumosDAO {

	
	public final String QUERY_INSERT = "INSERT INTO CAT_GRUPO_INSUMOS(GIN_DESCRIPCION,GIN_ORDEN) VALUES (?,?)";
	public final String QUERY_GET_BY_ID = "SELECT * FROM CAT_GRUPO_INSUMOS WHERE BINARY ID = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_GRUPO_INSUMOS";
	public final String QUERY_DELETE_BY_ID = "DELETE FROM CAT_GRUPO_INSUMOS WHERE BINARY ID = ?";
	public final String QUERY_UPDATE_BY_ID = "UPDATE CAT_GRUPO_INSUMOS	SET	GIN_DESCRIPCION = ?,GIN_ORDEN = ? WHERE BINARY ID = ?";
	public final String QUERY_GET_ID = "SELECT ID FROM CAT_GRUPO_INSUMOS WHERE BINARY GIN_DESCRIPCION = ? AND GIN_ORDEN = ?";
	
	
	
	public void insertGrupoInsumos(ClGrupoInsumosVO clGrupoInsumosVO);

	public ClGrupoInsumosVO getGrupoInsumos(int id);

	public List<ClGrupoInsumosVO> getGruposInsumos();

	public void setDinamicDataSource(DataSource dataSource);
	
	public void deleteGrupoInsumos(int id) throws DataIntegrityViolationException;
	
	public void updateGrupoInsumos(ClGrupoInsumosVO clGrupoInsumosVO);
	
	public int getId(ClGrupoInsumosVO clGrupoInsumosVO);
}
