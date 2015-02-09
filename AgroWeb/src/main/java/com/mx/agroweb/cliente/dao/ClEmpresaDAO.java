package com.mx.agroweb.cliente.dao;

import java.util.List;

import javax.sql.DataSource;

import com.mx.agroweb.cliente.vo.ClEmpresaVO;

public interface ClEmpresaDAO {

	public final String QUERY_INSERT = "INSERT INTO CAT_EMPRESAS (EMP_NOMBRE, EMP_DIRECCION) VALUES (?, ?)";
	public final String QUERY_GET_BY_ID = "SELECT * FROM CAT_EMPRESAS WHERE BINARY ID = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_EMPRESAS";
	public final String QUERY_GET_ALL_EMPRESAS_BY_USER = "select e.id as id, e.emp_nombre as emp_nombre, e.emp_direccion as emp_direccion from empresa_usuario eu, cat_empresas e, cat_usuarios u where eu.emp_usu_id_usuario = u.id AND eu.emp_usu_id_empresa = e.id AND u.id = ?; ";

	public void insertEmpresa(ClEmpresaVO clEmpresaVO);

	public ClEmpresaVO getEmpresa(int id);

	public List<ClEmpresaVO> getEmpresas();
	
	public List<ClEmpresaVO> getEmpresasByIdUser(int id);

	public void setDinamicDataSource(DataSource dataSource);

}
