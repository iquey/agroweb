package com.mx.agroweb.cliente.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mx.agroweb.cliente.dao.ClZonasDAO;
import com.mx.agroweb.cliente.service.ClZonasService;
import com.mx.agroweb.cliente.vo.ClZonasVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClZonasServiceImpl implements ClZonasService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4926615154209326575L;

	@Autowired
	ClZonasDAO clZonasDAO;

	@Override
	public void insertZona(ClZonasVO clZonasVO) {
		clZonasDAO.insertZona(clZonasVO);

	}

	@Override
	public ClZonasVO getZona(int id) {
		return clZonasDAO.getZona(id);
	}

	@Override
	public List<ClZonasVO> getZonas() {
		return clZonasDAO.getZonas();
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		clZonasDAO.setDinamicDataSource(dataSource);
	}

	@Override
	public void deleteZona(int id) throws DataIntegrityViolationException{
		clZonasDAO.deleteZona(id);
	}

	@Override
	public void updateZona(ClZonasVO clZonasVO) {
		clZonasDAO.updateZona(clZonasVO);
	}

	@Override
	public Map<Integer, ClZonasVO> createMap(List<ClZonasVO> listaGrupos) {

		Map<Integer, ClZonasVO> mapa = new HashMap<Integer, ClZonasVO>();

		for (ClZonasVO grupo : listaGrupos) {
			mapa.put(grupo.getId(), grupo);
		}
		return mapa;
	}

	@Override
	public int getId(ClZonasVO clZonasVO) {
		return clZonasDAO.getId(clZonasVO);
	}

}
