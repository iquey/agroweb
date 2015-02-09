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
import com.mx.agroweb.cliente.dao.ClGrupoInsumosDAO;
import com.mx.agroweb.cliente.dao.ClGrupoMaquinariaDAO;
import com.mx.agroweb.cliente.dao.ClPropietarioDAO;
import com.mx.agroweb.cliente.dao.ClProveedorDAO;
import com.mx.agroweb.cliente.service.ClCatCatalogoService;
import com.mx.agroweb.cliente.service.ClCentroCostosService;
import com.mx.agroweb.cliente.service.ClGrupoInsumosService;
import com.mx.agroweb.cliente.service.ClGrupoMaquinariaService;
import com.mx.agroweb.cliente.service.ClPropietarioService;
import com.mx.agroweb.cliente.service.ClProveedorService;
import com.mx.agroweb.cliente.utils.ConstantesClienteCatCatalogo;
import com.mx.agroweb.cliente.vo.ClCatalogoVO;
import com.mx.agroweb.cliente.vo.ClCentroCostosVO;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClGrupoMaquinariaVO;
import com.mx.agroweb.cliente.vo.ClPropietarioVO;
import com.mx.agroweb.cliente.vo.ClProveedorAuxVO;
import com.mx.agroweb.cliente.vo.ClProveedorVO;
import com.mx.agroweb.cliente.vo.ClUsuarioVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClPropietarioServiceImpl implements ClPropietarioService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4926615154209326575L;

	@Autowired
	ClPropietarioDAO clPropietarioDAO;

	@Override
	public void insertPropietario(ClPropietarioVO clPropietarioVO) {
		clPropietarioDAO.insertPropietario(clPropietarioVO);

	}

	@Override
	public ClPropietarioVO getPropietario(int id) {
		return clPropietarioDAO.getPropietario(id);
	}

	@Override
	public List<ClPropietarioVO> getPropietarios() {
		return clPropietarioDAO.getPropietarios();
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		clPropietarioDAO.setDinamicDataSource(dataSource);
	}

	@Override
	public void deletePropietario(int id) throws DataIntegrityViolationException {
		clPropietarioDAO.deletePropietario(id);
	}

	@Override
	public void updatePropietario(ClPropietarioVO clPropietarioVO) {
		clPropietarioDAO.updatePropietario(clPropietarioVO);
	}

	@Override
	public Map<Integer, ClPropietarioVO> createMap(List<ClPropietarioVO> listaGrupos) {

		Map<Integer, ClPropietarioVO> mapa = new HashMap<Integer, ClPropietarioVO>();

		for (ClPropietarioVO grupo : listaGrupos) {
			mapa.put(grupo.getId(), grupo);
		}
		return mapa;
	}

	@Override
	public int getId(ClPropietarioVO clPropietarioVO) {
		return clPropietarioDAO.getId(clPropietarioVO);
	}

}
