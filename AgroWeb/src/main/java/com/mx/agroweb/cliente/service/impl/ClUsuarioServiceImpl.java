package com.mx.agroweb.cliente.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.agroweb.cliente.dao.ClUsuarioDAO;
import com.mx.agroweb.cliente.service.ClUsuarioService;
import com.mx.agroweb.cliente.vo.ClUsuarioVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClUsuarioServiceImpl implements ClUsuarioService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -898719509264258033L;

	@Autowired
	public ClUsuarioDAO clUsuarioDAO;

	@Override
	public void insertUsuario(ClUsuarioVO clUsuarioVO) {
		clUsuarioDAO.insertUsuario(clUsuarioVO);

	}

	@Override
	public ClUsuarioVO getUsuario(String username, String password) {
		return clUsuarioDAO.getUsuario(username, password);
	}

	@Override
	public List<ClUsuarioVO> getUsuarios() {
		return clUsuarioDAO.getUsuarios();
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		clUsuarioDAO.setDinamicDataSource(dataSource);
	}

	@Override
	public boolean isValidateUsuario(ClUsuarioVO clUsuarioVO) {
		// TODO Auto-generated method stub
		return false;
	}

}
