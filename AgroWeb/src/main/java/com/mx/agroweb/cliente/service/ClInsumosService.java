package com.mx.agroweb.cliente.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClInsumosAuxVO;
import com.mx.agroweb.cliente.vo.ClInsumosVO;
import com.mx.agroweb.cliente.vo.ClProveedorAuxVO;
import com.mx.agroweb.cliente.vo.ClProveedorVO;
import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosAuxVO;
import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosVO;

public interface ClInsumosService {
	
	public void insertInsumos(ClInsumosVO clInsumosVO);

	public ClSubgrupoInsumosAuxVO getInsumos(int id);

	public List<ClInsumosAuxVO> getInsumos();

	public void setDinamicDataSource();
	
	public void deleteInsumos(int id) throws DataIntegrityViolationException;
	
	public void updateInsumos(ClInsumosVO clInsumosVO);
}
