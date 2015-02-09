package com.mx.agroweb.admin.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.agroweb.admin.dao.LicenciaDAO;
import com.mx.agroweb.admin.service.LicenciaService;
import com.mx.agroweb.admin.vo.LicenciaVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class LicenciaServiceImpl implements LicenciaService {

	@Autowired
	private LicenciaDAO licenciaDAO;

	@Override
	public void insertLicencia(LicenciaVO licenciaVO) {
		licenciaDAO.insertLicencia(licenciaVO);

	}

	@Override
	public LicenciaVO getLicencia(String username, String password) {
		// TODO Auto-generated method stub
		return licenciaDAO.getLicencia(username, password);
	}

	@Override
	public List<LicenciaVO> getLicencias() {
		// TODO Auto-generated method stub
		return licenciaDAO.getLicencias();
	}

	@Override
	public void setDinamicDataSource() {
		// TODO Auto-generated method stub
		DataSource dataSource = DataSourceUtils.getDataSource();
		licenciaDAO.setDataSourceDynamic(dataSource);
		
	}

}
