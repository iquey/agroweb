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
import com.mx.agroweb.cliente.dao.ClProveedorDAO;
import com.mx.agroweb.cliente.service.ClCatCatalogoService;
import com.mx.agroweb.cliente.service.ClCentroCostosService;
import com.mx.agroweb.cliente.service.ClGrupoInsumosService;
import com.mx.agroweb.cliente.service.ClGrupoMaquinariaService;
import com.mx.agroweb.cliente.service.ClProveedorService;
import com.mx.agroweb.cliente.utils.ConstantesClienteCatCatalogo;
import com.mx.agroweb.cliente.vo.ClCatalogoVO;
import com.mx.agroweb.cliente.vo.ClCentroCostosVO;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClGrupoMaquinariaVO;
import com.mx.agroweb.cliente.vo.ClProveedorAuxVO;
import com.mx.agroweb.cliente.vo.ClProveedorVO;
import com.mx.agroweb.cliente.vo.ClUsuarioVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClGrupoMaquinariaServiceImpl implements ClGrupoMaquinariaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4926615154209326575L;

	@Autowired
	ClGrupoMaquinariaDAO clGrupoMaquinariaDAO;

	@Override
	public void insertGrupoMaquinaria(ClGrupoMaquinariaVO clGrupoMaquinariaVO) {
		clGrupoMaquinariaDAO.insertGrupoMaquinaria(clGrupoMaquinariaVO);

	}

	@Override
	public ClGrupoMaquinariaVO getGrupoMaquinaria(int id) {
		return clGrupoMaquinariaDAO.getGrupoMaquinaria(id);
	}

	@Override
	public List<ClGrupoMaquinariaVO> getGrupoMaquinaria() {
		return clGrupoMaquinariaDAO.getGruposMaquinaria();
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		clGrupoMaquinariaDAO.setDinamicDataSource(dataSource);
	}

	@Override
	public void deleteGrupoMaquinaria(int id) throws DataIntegrityViolationException {
		clGrupoMaquinariaDAO.deleteGrupoMaquinaria(id);
	}

	@Override
	public void updateGrupoMaquinaria(ClGrupoMaquinariaVO clGrupoMaquinariaVO) {
		clGrupoMaquinariaDAO.updateGrupoMaquinaria(clGrupoMaquinariaVO);
	}

	@Override
	public Map<Integer, ClGrupoMaquinariaVO> createMap(List<ClGrupoMaquinariaVO> listaGrupos) {

		Map<Integer, ClGrupoMaquinariaVO> mapa = new HashMap<Integer, ClGrupoMaquinariaVO>();

		for (ClGrupoMaquinariaVO grupo : listaGrupos) {
			mapa.put(grupo.getId(), grupo);
		}
		return mapa;
	}

	@Override
	public int getId(ClGrupoMaquinariaVO clGrupoMaquinariaVO) {
		return clGrupoMaquinariaDAO.getId(clGrupoMaquinariaVO);
	}

}
