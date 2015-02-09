package com.mx.agroweb.cliente.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClCatalogoVO;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClGrupoMaquinariaVO;

public interface ClGrupoMaquinariaService {
	
	public void insertGrupoMaquinaria(ClGrupoMaquinariaVO clGrupoMaquinariaVO);
	
	public ClGrupoMaquinariaVO getGrupoMaquinaria(int id);

	public List<ClGrupoMaquinariaVO> getGrupoMaquinaria();

	public void setDinamicDataSource();
	
	public void deleteGrupoMaquinaria(int id) throws DataIntegrityViolationException ;
	
	public void updateGrupoMaquinaria(ClGrupoMaquinariaVO clGrupoMaquinariaVO);
	
	public Map<Integer, ClGrupoMaquinariaVO> createMap(List<ClGrupoMaquinariaVO> listaGrupos);
	
	public int getId(ClGrupoMaquinariaVO clGrupoMaquinariaVO);
}
