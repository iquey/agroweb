package com.mx.agroweb.cliente.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.agroweb.cliente.dao.ClEmpresaUsuarioDAO;
import com.mx.agroweb.cliente.service.ClEmpresaUsuarioService;
import com.mx.agroweb.cliente.vo.ClEmpresaUsuarioVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClEmpresaUsuarioServiceImpl implements ClEmpresaUsuarioService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4604719518115603036L;

	@Autowired
	ClEmpresaUsuarioDAO clEmpresaUsuarioDAO;

	@Override
	public void insertEmpresa(ClEmpresaUsuarioVO clEmpresaUsuarioVO) {
		clEmpresaUsuarioDAO.insertEmpresa(clEmpresaUsuarioVO);
	}

	@Override
	public ClEmpresaUsuarioVO getEmpresa(int id) {
		return clEmpresaUsuarioDAO.getEmpresa(id);
	}

	@Override
	public List<ClEmpresaUsuarioVO> getEmpresasByUser(int idUsuario) {
		return clEmpresaUsuarioDAO.getEmpresasByUser(idUsuario);
	}

	@Override
	public List<ClEmpresaUsuarioVO> getEmpresas() {
		return clEmpresaUsuarioDAO.getEmpresas();
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		clEmpresaUsuarioDAO.setDinamicDataSource(dataSource);
	}

}
