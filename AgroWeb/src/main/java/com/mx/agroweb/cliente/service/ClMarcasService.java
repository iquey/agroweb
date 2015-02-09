package com.mx.agroweb.cliente.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClMarcasVO;

public interface ClMarcasService {
	
	public void insertMarca(ClMarcasVO clMarcasVO);
	
	public ClMarcasVO getMarca(int id);

	public List<ClMarcasVO> getMarcas();

	public void setDinamicDataSource();
	
	public void deleteMarca(int id) throws DataIntegrityViolationException;
	
	public void updateMarca(ClMarcasVO clMarcasVO);
	
	public Map<Integer, ClMarcasVO> createMap(List<ClMarcasVO> listaMarcas);
	
	public int getId(ClMarcasVO clMarcasVO);
}
