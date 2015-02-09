package com.mx.agroweb.cliente.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClGrupoMaquinariaVO;
import com.mx.agroweb.cliente.vo.ClPropietarioVO;

public interface ClPropietarioDAO {

	
	public final String QUERY_INSERT = "INSERT INTO CAT_PROPIETARIOS(PROP_DESCRIPCION) VALUES (?)";
	public final String QUERY_GET_BY_ID = "SELECT * FROM CAT_PROPIETARIOS WHERE BINARY ID = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_PROPIETARIOS";
	public final String QUERY_DELETE_BY_ID = "DELETE FROM CAT_PROPIETARIOS WHERE BINARY ID = ?";
	public final String QUERY_UPDATE_BY_ID = "UPDATE CAT_PROPIETARIOS	SET	PROP_DESCRIPCION = ? WHERE BINARY ID = ?";
	public final String QUERY_GET_ID = "SELECT ID FROM CAT_PROPIETARIOS WHERE BINARY PROP_DESCRIPCION = ?";
	
	
	
	public void insertPropietario(ClPropietarioVO clPropietarioVO);

	public ClPropietarioVO getPropietario(int id);

	public List<ClPropietarioVO> getPropietarios();

	public void setDinamicDataSource(DataSource dataSource);
	
	public void deletePropietario(int id) throws DataIntegrityViolationException;
	
	public void updatePropietario(ClPropietarioVO clPropietarioVO);
	
	public int getId(ClPropietarioVO clPropietarioVO);
}
