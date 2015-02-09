package com.mx.agroweb.cliente.service;

import java.util.List;
import com.mx.agroweb.cliente.vo.ClEmpresaVO;

public interface ClEmpresaService {

	public void insertEmpresa(ClEmpresaVO clEmpresaVO);

	public ClEmpresaVO getEmpresa(int id);

	public List<ClEmpresaVO> getEmpresas();
	
	public List<ClEmpresaVO> getEmpresasByIdUser(int id);

	public void setDinamicDataSource();

}
