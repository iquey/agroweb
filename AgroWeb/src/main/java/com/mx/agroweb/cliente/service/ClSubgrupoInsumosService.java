package com.mx.agroweb.cliente.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClCatalogoVO;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosAuxVO;
import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosVO;

public interface ClSubgrupoInsumosService {

	public void insertSubgrupoInsumos(ClSubgrupoInsumosVO clSubgrupoInsumosVO);

	public ClSubgrupoInsumosAuxVO getSubgrupoInsumos(int id);

	public List<ClSubgrupoInsumosAuxVO> getSubgrupoInsumos();

	public void setDinamicDataSource();

	public void deleteSubgrupoInsumos(int id) throws DataIntegrityViolationException;

	public void updateSubgrupoInsumos(ClSubgrupoInsumosVO clSubgrupoInsumosVO);

	public Map<Integer, ClSubgrupoInsumosAuxVO> createMap(List<ClSubgrupoInsumosAuxVO> listaSubGrupo);
	
	public int getId(ClSubgrupoInsumosVO clSubgrupoInsumosVO);
}
