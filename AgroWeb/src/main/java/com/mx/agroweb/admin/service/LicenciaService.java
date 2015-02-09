package com.mx.agroweb.admin.service;

import java.util.List;

import com.mx.agroweb.admin.vo.LicenciaVO;

public interface LicenciaService {

	public void insertLicencia(LicenciaVO licenciaVO);

	public LicenciaVO getLicencia(String username, String password);

	public List<LicenciaVO> getLicencias();
	
	public void setDinamicDataSource();

}
