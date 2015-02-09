package com.mx.agroweb.cliente.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClCentroCostosVO;
import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosVO;

public interface ClCentroCostosService {
	
	public void insertCentroCostos(ClCentroCostosVO clCentroCostosVO);
	
	public ClCentroCostosVO getCentroCostos(int id);

	public List<ClCentroCostosVO> getCentrosCostos();

	public void setDinamicDataSource();
	
	public void deleteCentroCostos(int id) throws DataIntegrityViolationException;
	
	public void updateCentroCostos(ClCentroCostosVO clCentroCostosVO);
	
	public Map<Integer, ClCentroCostosVO> createMap(List<ClCentroCostosVO> listaCentroCostos);
	
	public int getId(ClCentroCostosVO clCentroCostosVO);
}
