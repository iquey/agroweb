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

import com.mx.agroweb.cliente.dao.ClMarcasDAO;
import com.mx.agroweb.cliente.service.ClMarcasService;
import com.mx.agroweb.cliente.vo.ClMarcasVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClMarcasServiceImpl implements ClMarcasService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4926615154209326575L;

	@Autowired
	ClMarcasDAO clMarcasDAO;

	@Override
	public void insertMarca(ClMarcasVO clMarcasVO) {
		clMarcasDAO.insertMarca(clMarcasVO);

	}

	@Override
	public ClMarcasVO getMarca(int id) {
		return clMarcasDAO.getMarca(id);
	}

	@Override
	public List<ClMarcasVO> getMarcas() {
		return clMarcasDAO.getMarcas();
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		clMarcasDAO.setDinamicDataSource(dataSource);
	}

	@Override
	public void deleteMarca(int id) throws DataIntegrityViolationException{
		clMarcasDAO.deleteMarca(id);
	}

	@Override
	public void updateMarca(ClMarcasVO clMarcasVO) {
		clMarcasDAO.updateMarca(clMarcasVO);
	}

	@Override
	public Map<Integer, ClMarcasVO> createMap(List<ClMarcasVO> listaGrupos) {

		Map<Integer, ClMarcasVO> mapa = new HashMap<Integer, ClMarcasVO>();

		for (ClMarcasVO grupo : listaGrupos) {
			mapa.put(grupo.getId(), grupo);
		}
		return mapa;
	}

	@Override
	public int getId(ClMarcasVO clMarcasVO) {
		return clMarcasDAO.getId(clMarcasVO);
	}

}
