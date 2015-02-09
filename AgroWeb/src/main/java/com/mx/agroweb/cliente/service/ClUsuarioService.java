package com.mx.agroweb.cliente.service;

import java.util.List;

import com.mx.agroweb.cliente.vo.ClUsuarioVO;

public interface ClUsuarioService {

	public void insertUsuario(ClUsuarioVO clUsuarioVO);

	public ClUsuarioVO getUsuario(String username, String password);

	public List<ClUsuarioVO> getUsuarios();

	public void setDinamicDataSource();

	public boolean isValidateUsuario(ClUsuarioVO clUsuarioVO);

}
