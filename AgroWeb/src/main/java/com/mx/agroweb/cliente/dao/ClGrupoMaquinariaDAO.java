package com.mx.agroweb.cliente.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClGrupoMaquinariaVO;

public interface ClGrupoMaquinariaDAO {

	
	public final String QUERY_INSERT = "INSERT INTO CAT_GRUPO_MAQUINARIA(GMA_DESCRIPCION) VALUES (?)";
	public final String QUERY_GET_BY_ID = "SELECT * FROM CAT_GRUPO_MAQUINARIA WHERE BINARY ID = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_GRUPO_MAQUINARIA";
	public final String QUERY_DELETE_BY_ID = "DELETE FROM CAT_GRUPO_MAQUINARIA WHERE BINARY ID = ?";
	public final String QUERY_UPDATE_BY_ID = "UPDATE CAT_GRUPO_MAQUINARIA	SET	GMA_DESCRIPCION = ? WHERE BINARY ID = ?";
	public final String QUERY_GET_ID = "SELECT ID FROM CAT_GRUPO_MAQUINARIA WHERE BINARY GMA_DESCRIPCION = ?";
	
	
	
	public void insertGrupoMaquinaria(ClGrupoMaquinariaVO clGrupoMaquinariaVO);

	public ClGrupoMaquinariaVO getGrupoMaquinaria(int id);

	public List<ClGrupoMaquinariaVO> getGruposMaquinaria();

	public void setDinamicDataSource(DataSource dataSource);
	
	public void deleteGrupoMaquinaria(int id) throws DataIntegrityViolationException;
	
	public void updateGrupoMaquinaria(ClGrupoMaquinariaVO clGrupoMaquinariaVO);
	
	public int getId(ClGrupoMaquinariaVO clGrupoMaquinariaVO);
}
