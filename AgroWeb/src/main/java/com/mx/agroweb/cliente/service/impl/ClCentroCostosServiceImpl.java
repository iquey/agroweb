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

import com.mx.agroweb.cliente.dao.ClCatCatalogoDAO;
import com.mx.agroweb.cliente.dao.ClCentroCostosDAO;
import com.mx.agroweb.cliente.dao.ClProveedorDAO;
import com.mx.agroweb.cliente.service.ClCatCatalogoService;
import com.mx.agroweb.cliente.service.ClCentroCostosService;
import com.mx.agroweb.cliente.service.ClProveedorService;
import com.mx.agroweb.cliente.utils.ConstantesClienteCatCatalogo;
import com.mx.agroweb.cliente.vo.ClCatalogoVO;
import com.mx.agroweb.cliente.vo.ClCentroCostosVO;
import com.mx.agroweb.cliente.vo.ClProveedorAuxVO;
import com.mx.agroweb.cliente.vo.ClProveedorVO;
import com.mx.agroweb.cliente.vo.ClUsuarioVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClCentroCostosServiceImpl implements ClCentroCostosService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4926615154209326575L;

	@Autowired
	ClCentroCostosDAO clCentroCostosDAO;

	@Override
	public void insertCentroCostos(ClCentroCostosVO clCentroCostosVO) {
		clCentroCostosDAO.insertCentroCostos(clCentroCostosVO);

	}

	@Override
	public ClCentroCostosVO getCentroCostos(int id) {
		return clCentroCostosDAO.getCentroCostos(id);
	}

	@Override
	public List<ClCentroCostosVO> getCentrosCostos() {
		return clCentroCostosDAO.getCentrosCostos();
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		clCentroCostosDAO.setDinamicDataSource(dataSource);
	}

	@Override
	public void deleteCentroCostos(int id) throws DataIntegrityViolationException{
		clCentroCostosDAO.deleteCentroCostos(id);
	}

	@Override
	public void updateCentroCostos(ClCentroCostosVO clCentroCostosVO) {
		clCentroCostosDAO.updateCentroCostos(clCentroCostosVO);
	}

	@Override
	public Map<Integer, ClCentroCostosVO> createMap(List<ClCentroCostosVO> listaCentroCostos) {

		Map<Integer, ClCentroCostosVO> mapa = new HashMap<Integer, ClCentroCostosVO>();

		for (ClCentroCostosVO centroCosto : listaCentroCostos) {
			mapa.put(centroCosto.getId(), centroCosto);
		}

		return mapa;
	}

	@Override
	public int getId(ClCentroCostosVO clCentroCostosVO) {
		return clCentroCostosDAO.getId(clCentroCostosVO);
	}

}
