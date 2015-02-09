package com.mx.agroweb.cliente.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClZonasVO;

public interface ClZonasService {
	
	public void insertZona(ClZonasVO clZonasVO);
	
	public ClZonasVO getZona(int id);

	public List<ClZonasVO> getZonas();

	public void setDinamicDataSource();
	
	public void deleteZona(int id) throws DataIntegrityViolationException;
	
	public void updateZona(ClZonasVO clZonasVO);
	
	public Map<Integer, ClZonasVO> createMap(List<ClZonasVO> listaZonas);
	
	public int getId(ClZonasVO clZonasVO);
}
