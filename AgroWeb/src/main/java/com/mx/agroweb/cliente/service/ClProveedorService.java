package com.mx.agroweb.cliente.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClProveedorAuxVO;
import com.mx.agroweb.cliente.vo.ClProveedorVO;

public interface ClProveedorService {
	
	public void insertProovedor(ClProveedorVO clProovedorVO);

	public ClProveedorAuxVO getProovedor(int id);

	public List<ClProveedorAuxVO> getProovedores();
	
	public List<ClProveedorVO> getProovedoresVO();

	public void setDinamicDataSource();
	
	public void deleteProovedor(int id) throws DataIntegrityViolationException ;
	
	public void updateProovedor(ClProveedorVO clProovedorVO);

	public Map<Integer, ClProveedorVO> createMap(List<ClProveedorVO> proveedorList);

	public int getId(ClProveedorVO clProveedorNuevo);
}
