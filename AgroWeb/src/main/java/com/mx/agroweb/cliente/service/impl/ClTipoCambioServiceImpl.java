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

import com.mx.agroweb.cliente.dao.ClTipoCambioDAO;
import com.mx.agroweb.cliente.service.ClTipoCambioService;
import com.mx.agroweb.cliente.vo.ClTipoCambioVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClTipoCambioServiceImpl implements ClTipoCambioService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4926615154209326575L;

	@Autowired
	ClTipoCambioDAO clTipoCambioDAO;

	@Override
	public void insertTipoCambio(ClTipoCambioVO clTipoCambioVO) {
		clTipoCambioDAO.insertTipoCambio(clTipoCambioVO);

	}

	@Override
	public ClTipoCambioVO getTipoCambio(int id) {
		return clTipoCambioDAO.getTipoCambio(id);
	}

	@Override
	public List<ClTipoCambioVO> getTiposCambio() {
		return clTipoCambioDAO.getTiposCambio();
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		clTipoCambioDAO.setDinamicDataSource(dataSource);
	}

	@Override
	public void deleteTipoCambio(int id) throws DataIntegrityViolationException{
		clTipoCambioDAO.deleteTipoCambio(id);
	}

	@Override
	public void updateTipoCambio(ClTipoCambioVO clTipoCambioVO) {
		clTipoCambioDAO.updateTipoCambio(clTipoCambioVO);
	}

	@Override
	public Map<Integer, ClTipoCambioVO> createMap(List<ClTipoCambioVO> listaGrupos) {

		Map<Integer, ClTipoCambioVO> mapa = new HashMap<Integer, ClTipoCambioVO>();

		for (ClTipoCambioVO grupo : listaGrupos) {
			mapa.put(grupo.getId(), grupo);
		}
		return mapa;
	}

	@Override
	public int getId(ClTipoCambioVO clTipoCambioVO) {
		return clTipoCambioDAO.getId(clTipoCambioVO);
	}

}
