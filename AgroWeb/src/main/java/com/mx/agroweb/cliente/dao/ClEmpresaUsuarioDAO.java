package com.mx.agroweb.cliente.dao;

import java.util.List;

import javax.sql.DataSource;

import com.mx.agroweb.cliente.vo.ClEmpresaUsuarioVO;

public interface ClEmpresaUsuarioDAO {

	public final String QUERY_INSERT = "INSERT INTO EMPRESA_USUARIO (EMP_USU_ID_EMPRESA, EMP_USU_ID_USUARIO) VALUES (?, ?)";
	public final String QUERY_GET_BY_ID_USUARIO = "SELECT * FROM EMPRESA_USUARIO WHERE BINARY EMP_USU_ID_USUARIO = ?";
	public final String QUERY_GET_BY_ID = "SELECT * FROM EMPRESA_USUARIO WHERE BINARY ID = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM EMPRESA_USUARIO";

	public void insertEmpresa(ClEmpresaUsuarioVO clEmpresaUsuarioVO);

	public ClEmpresaUsuarioVO getEmpresa(int id);

	public List<ClEmpresaUsuarioVO> getEmpresasByUser(int idUsuario);

	public List<ClEmpresaUsuarioVO> getEmpresas();

	public void setDinamicDataSource(DataSource dataSource);
}
