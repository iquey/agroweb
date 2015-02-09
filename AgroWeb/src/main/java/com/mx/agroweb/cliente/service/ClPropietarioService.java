package com.mx.agroweb.cliente.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClCatalogoVO;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClGrupoMaquinariaVO;
import com.mx.agroweb.cliente.vo.ClPropietarioVO;

public interface ClPropietarioService {
	
	public void insertPropietario(ClPropietarioVO clPropietarioVO);
	
	public ClPropietarioVO getPropietario(int id);

	public List<ClPropietarioVO> getPropietarios();

	public void setDinamicDataSource();
	
	public void deletePropietario(int id) throws DataIntegrityViolationException;
	
	public void updatePropietario(ClPropietarioVO clPropietarioVO);
	
	public Map<Integer, ClPropietarioVO> createMap(List<ClPropietarioVO> listaPropietarios);
	
	public int getId(ClPropietarioVO clPropietarioVO);
}
