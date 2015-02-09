package com.mx.agroweb.cliente.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;

public interface ClGrupoInsumosService {
	
	public void insertGrupoInsumos(ClGrupoInsumosVO clGrupoInsumosVO);
	
	public ClGrupoInsumosVO getGrupoInsumos(int id);

	public List<ClGrupoInsumosVO> getGrupoInsumos();

	public void setDinamicDataSource();
	
	public void deleteGrupoInsumos(int id) throws DataIntegrityViolationException;
	
	public void updateGrupoInsumos(ClGrupoInsumosVO clGrupoInsumosVO);
	
	public Map<Integer, ClGrupoInsumosVO> createMap(List<ClGrupoInsumosVO> listaGrupos);
	
	public int getId(ClGrupoInsumosVO clGrupoInsumosVO);
}
