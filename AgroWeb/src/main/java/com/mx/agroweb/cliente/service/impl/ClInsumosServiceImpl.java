package com.mx.agroweb.cliente.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mx.agroweb.cliente.dao.ClInsumosDAO;
import com.mx.agroweb.cliente.service.ClCatCatalogoService;
import com.mx.agroweb.cliente.service.ClCentroCostosService;
import com.mx.agroweb.cliente.service.ClInsumosService;
import com.mx.agroweb.cliente.service.ClSubgrupoInsumosService;
import com.mx.agroweb.cliente.utils.ConstantesClienteCatCatalogo;
import com.mx.agroweb.cliente.vo.ClCatalogoVO;
import com.mx.agroweb.cliente.vo.ClCentroCostosVO;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClInsumosAuxVO;
import com.mx.agroweb.cliente.vo.ClInsumosVO;
import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosAuxVO;
import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClInsumosServiceImpl implements ClInsumosService {

	@Autowired
	ClInsumosDAO clInsumosDAO;

	@Autowired
	ClSubgrupoInsumosService clSubgrupoInsumosService;

	@Autowired
	ClCatCatalogoService clCatalogoService;

	@Autowired
	ClCentroCostosService clCentroCostosService;

	@Override
	public void insertInsumos(ClInsumosVO clInsumosVO) {

		clInsumosDAO.insertInsumos(clInsumosVO);

	}

	@Override
	public ClSubgrupoInsumosAuxVO getInsumos(int id) {
		List<ClInsumosVO> listaInsumos = new ArrayList<>();
		return null;
	}

	@Override
	public List<ClInsumosAuxVO> getInsumos() {
		List<ClInsumosVO> listaInsumos = new ArrayList<>();
		listaInsumos = clInsumosDAO.getInsumos();
		return construirAuxInsumos(listaInsumos);
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		clInsumosDAO.setDinamicDataSource(dataSource);
	}

	@Override
	public void deleteInsumos(int id) throws DataIntegrityViolationException{
		clInsumosDAO.deleteInsumos(id);
	}

	@Override
	public void updateInsumos(ClInsumosVO clInsumosVO) {

		clInsumosDAO.updateInsumos(clInsumosVO);
	}

	public List<ClInsumosAuxVO> construirAuxInsumos(List<ClInsumosVO> insumosList) {

		List<ClSubgrupoInsumosAuxVO> listaSubGrupos = new ArrayList<>();
		List<ClCatalogoVO> listaUnidades = new ArrayList<>();
		List<ClCentroCostosVO> listaCentroCostos = new ArrayList<>();

		List<ClInsumosAuxVO> listaInsumosAux = new ArrayList<>();

		listaSubGrupos = clSubgrupoInsumosService.getSubgrupoInsumos();
		listaUnidades = clCatalogoService.getCatalogoByCatalogo(ConstantesClienteCatCatalogo.CATALOGO_UNIDADES);
		listaCentroCostos = clCentroCostosService.getCentrosCostos();

		// Mapas
		Map<Integer, ClSubgrupoInsumosAuxVO> mapaSubGrupos = clSubgrupoInsumosService.createMap(listaSubGrupos);
		Map<Integer, ClCatalogoVO> mapaUnidades = clCatalogoService.createMap(listaUnidades);
		Map<Integer, ClCentroCostosVO> mapaCentroCostos = clCentroCostosService.createMap(listaCentroCostos);

		//
		for (ClInsumosVO clInsumoVO : insumosList) {

			ClInsumosAuxVO clInsumosAuxVO = new ClInsumosAuxVO(clInsumoVO);

			clInsumosAuxVO.setCatalogoSubgrupoInsumos(mapaSubGrupos.get(clInsumoVO.getIdSubgrupo()));

			clInsumosAuxVO.setCatalogoUnidadCompra(mapaUnidades.get(clInsumoVO.getIdUnidadCompra()));

			clInsumosAuxVO.setCatalogoUnidadVenta(mapaUnidades.get(clInsumoVO.getIdUnidadSalida()));

			clInsumosAuxVO.setCatalogoCentroCostos(mapaCentroCostos.get(clInsumoVO.getIdCentroCostos()));

			listaInsumosAux.add(clInsumosAuxVO);

		}
		return listaInsumosAux;
	}

}
