package com.mx.agroweb.utils;

import javax.faces.context.FacesContext;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.mx.agroweb.admin.vo.CatUsuarioVO;
import com.mx.agroweb.admin.vo.LicenciaVO;
import com.mx.agroweb.login.beans.UserLoginBean;

public class DataSourceUtils {

	public static final String NAME_DATASOURCE_FIELD = "dataSourceCustom";

	public static void createDataSource(LicenciaVO licenciaVO) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUsername(licenciaVO.getUsuario());
		dataSource.setPassword(licenciaVO.getContrasena());
		dataSource.setUrl(licenciaVO.getNombreBase());
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");

		SessionUtils.putValue(dataSource, NAME_DATASOURCE_FIELD);
	}

	public static DataSource getDataSource() {
		DataSource dataSource = (DataSource) SessionUtils.getValue(NAME_DATASOURCE_FIELD);
		if (dataSource != null) {
			return dataSource;
		}
		return null;
	}
	
	public static boolean existDS()
	{
		DataSource dataSource = (DataSource) SessionUtils.getValue(NAME_DATASOURCE_FIELD);
		if (dataSource != null) {
			return true;
		}
		return false;
	}

}
