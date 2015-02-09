package com.mx.agroweb.cliente.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.agroweb.cliente.dao.ClEmpresaDAO;
import com.mx.agroweb.cliente.service.ClEmpresaService;
import com.mx.agroweb.cliente.vo.ClEmpresaVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClEmpresaServiceImpl implements ClEmpresaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7550188918585772046L;

	@Autowired
	ClEmpresaDAO clEmpresaDAO;

	@Override
	public void insertEmpresa(ClEmpresaVO clEmpresaVO) {
		clEmpresaDAO.insertEmpresa(clEmpresaVO);

	}

	@Override
	public ClEmpresaVO getEmpresa(int id) {
		return clEmpresaDAO.getEmpresa(id);
	}

	@Override
	public List<ClEmpresaVO> getEmpresas() {
		return clEmpresaDAO.getEmpresas();
	}
	
	@Override
	public List<ClEmpresaVO> getEmpresasByIdUser(int id) {
		return clEmpresaDAO.getEmpresasByIdUser(id);
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		clEmpresaDAO.setDinamicDataSource(dataSource);
	}

}
