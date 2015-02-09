package com.mx.agroweb.admin.dao;

import java.util.List;

import javax.sql.DataSource;

import com.mx.agroweb.admin.vo.LicenciaVO;

public interface LicenciaDAO {

	
	public final String QUERY_INSERT = "INSERT INTO CAT_LICENCIAS (LIC_NOMBRE_BASE, LIC_DIRECCION_MAC, LIC_USUARIO, LIC_PASSWORD, LIC_FECHA_INICIO, LIC_FECHA_FIN, LIC_ID_CLIENTE, LIC_ID_TIPO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	public final String QUERY_GET_BY_USR_PASS ="SELECT * FROM CAT_LICENCIAS WHERE BINARY LIC_USUARIO = ? AND LIC_PASSWORD = ?";
	public final String QUERY_GET_BY_ID ="SELECT * FROM CAT_LICENCIAS WHERE BINARY ID = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_LICENCIAS";
	
	public void insertLicencia(LicenciaVO licenciaVO);

	public LicenciaVO getLicencia(String username, String password);

	public List<LicenciaVO> getLicencias();
	
	public LicenciaVO getLicenciaById(int id);
	
	public void setDataSourceDynamic(DataSource dataSource);
	


}
