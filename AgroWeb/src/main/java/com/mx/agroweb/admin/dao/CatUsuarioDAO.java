package com.mx.agroweb.admin.dao;

import java.util.List;

import javax.sql.DataSource;

import com.mx.agroweb.admin.vo.CatUsuarioVO;

public interface CatUsuarioDAO {

	public final String QUERY_INSERT = "INSERT INTO CAT_USUARIOS (USU_USUARIO, USU_PASSWORD, USU_FECHA_ALTA, USU_ID_ESTATUS, USU_ID_LICENCIA) VALUES (?, ?, ?, ?, ?)";
	public final String QUERY_GET_BY_USR_PASS = "SELECT * FROM CAT_USUARIOS WHERE BINARY USU_USUARIO = ? AND USU_PASSWORD = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_USUARIOS";

	public void insertUsuario(CatUsuarioVO catUsuarioVO);

	public CatUsuarioVO getUsuario(String username, String password);

	public List<CatUsuarioVO> getUsuarios();

	public void setDataSourceDynamic(DataSource dataSource);

}
