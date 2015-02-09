package com.mx.agroweb.cliente.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClMaquinariaAuxVO;
import com.mx.agroweb.cliente.vo.ClMaquinariaVO;

public interface ClMaquinariaService {
	
	public void insertMaquinaria(ClMaquinariaVO clMaquinariaVO);

	public ClMaquinariaVO getMaquinariaById(int id);

	public List<ClMaquinariaAuxVO> getMaquinaria();
	
	public List<ClMaquinariaVO> getMaquinariaVO();

	public void setDinamicDataSource();
	
	public void deleteMaquinaria(int id) throws DataIntegrityViolationException;
	
	public void updateMaquinaria(ClMaquinariaVO clMaquinariaVO);

}
