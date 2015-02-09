package com.mx.agroweb.cliente.service;

import java.util.List;

import com.mx.agroweb.cliente.vo.ClEmpresaUsuarioVO;

public interface ClEmpresaUsuarioService {

	public void insertEmpresa(ClEmpresaUsuarioVO clEmpresaUsuarioVO);

	public ClEmpresaUsuarioVO getEmpresa(int id);

	public List<ClEmpresaUsuarioVO> getEmpresasByUser(int idUsuario);

	public List<ClEmpresaUsuarioVO> getEmpresas();

	public void setDinamicDataSource();

}
