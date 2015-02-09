package com.mx.agroweb.cliente.dao;

import java.util.List;

import javax.sql.DataSource;

import com.mx.agroweb.cliente.vo.ClUsuarioVO;

public interface ClUsuarioDAO {
	
	public final String QUERY_INSERT = "INSERT INTO CAT_USUARIOS (USU_USUARIO, USU_PASSWORD, USU_FECHA_ALTA, USU_ID_ESTATUS) VALUES (?, ?, ?, ?)";
	public final String QUERY_GET_BY_USR_PASS = "SELECT * FROM CAT_USUARIOS WHERE BINARY USU_USUARIO = ? AND USU_PASSWORD = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_USUARIOS";

	public void insertUsuario(ClUsuarioVO clUsuarioVO);

	public ClUsuarioVO getUsuario(String username, String password);

	public List<ClUsuarioVO> getUsuarios();

	public void setDinamicDataSource(DataSource dataSource);

}
