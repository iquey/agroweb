package com.mx.agroweb.cliente.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mx.agroweb.cliente.dao.ClGrupoInsumosDAO;
import com.mx.agroweb.cliente.service.ClGrupoInsumosService;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClGrupoInsumosServiceImpl implements ClGrupoInsumosService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4926615154209326575L;

	@Autowired
	ClGrupoInsumosDAO clGrupoInsumosDAO;

	@Override
	public void insertGrupoInsumos(ClGrupoInsumosVO clGrupoInsumosVO) {
		clGrupoInsumosDAO.insertGrupoInsumos(clGrupoInsumosVO);

	}

	@Override
	public ClGrupoInsumosVO getGrupoInsumos(int id) {
		return clGrupoInsumosDAO.getGrupoInsumos(id);
	}

	@Override
	public List<ClGrupoInsumosVO> getGrupoInsumos() {
		return clGrupoInsumosDAO.getGruposInsumos();
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		clGrupoInsumosDAO.setDinamicDataSource(dataSource);
	}

	@Override
	public void deleteGrupoInsumos(int id) throws DataIntegrityViolationException{
		clGrupoInsumosDAO.deleteGrupoInsumos(id);
	}

	@Override
	public void updateGrupoInsumos(ClGrupoInsumosVO clGrupoInsumosVO) {
		clGrupoInsumosDAO.updateGrupoInsumos(clGrupoInsumosVO);
	}

	@Override
	public Map<Integer, ClGrupoInsumosVO> createMap(List<ClGrupoInsumosVO> listaGrupos) {

		Map<Integer, ClGrupoInsumosVO> mapa = new HashMap<Integer, ClGrupoInsumosVO>();

		for (ClGrupoInsumosVO grupo : listaGrupos) {
			mapa.put(grupo.getId(), grupo);
		}
		return mapa;
	}

	@Override
	public int getId(ClGrupoInsumosVO clGrupoInsumosVO) {
		return clGrupoInsumosDAO.getId(clGrupoInsumosVO);
	}

}
