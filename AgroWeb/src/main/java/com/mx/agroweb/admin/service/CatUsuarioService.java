package com.mx.agroweb.admin.service;

import java.util.List;

import com.mx.agroweb.admin.vo.CatUsuarioVO;
import com.mx.agroweb.login.beans.UserLoginBean;

public interface CatUsuarioService {

	public void insertUsuario(CatUsuarioVO catUsuarioVO);

	public CatUsuarioVO getUsuario(String username, String password);

	public List<CatUsuarioVO> getUsuarios();

	public void setDinamicDataSource();

	public boolean isValidateUsuario(CatUsuarioVO catUsuarioVO);

}
