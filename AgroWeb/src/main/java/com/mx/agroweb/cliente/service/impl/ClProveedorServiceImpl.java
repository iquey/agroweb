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

import com.mx.agroweb.cliente.dao.ClProveedorDAO;
import com.mx.agroweb.cliente.service.ClCatCatalogoService;
import com.mx.agroweb.cliente.service.ClProveedorService;
import com.mx.agroweb.cliente.utils.ConstantesClienteCatCatalogo;
import com.mx.agroweb.cliente.vo.ClCatalogoVO;
import com.mx.agroweb.cliente.vo.ClProveedorAuxVO;
import com.mx.agroweb.cliente.vo.ClProveedorVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClProveedorServiceImpl implements ClProveedorService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4926615154209326575L;

	@Autowired
	ClCatCatalogoService catalogoService;

	@Autowired
	ClProveedorDAO clProovedorDAO;

	@Override
	public void insertProovedor(ClProveedorVO clProovedorVO) {
		clProovedorDAO.insertProovedor(clProovedorVO);

	}

	@Override
	public ClProveedorAuxVO getProovedor(int id) {
		// return clProovedorDAO.getProovedor(id);
		return null;
	}

	@Override
	public List<ClProveedorAuxVO> getProovedores() {

		List<ClCatalogoVO> listaTipo = new ArrayList<ClCatalogoVO>();
		List<ClCatalogoVO> listaEstatus = new ArrayList<ClCatalogoVO>();
		List<ClProveedorVO> listaProveedores = new ArrayList<ClProveedorVO>();
		List<ClProveedorAuxVO> listaProveedoresAux = new ArrayList<ClProveedorAuxVO>();

		listaTipo = catalogoService.getCatalogoByCatalogo(ConstantesClienteCatCatalogo.CATALOGO_TIPO_PROVEEDORES);
		listaEstatus = catalogoService.getCatalogoByCatalogo(ConstantesClienteCatCatalogo.CATALOGO_TIPO_ESTATUS);
		Map<Integer, ClCatalogoVO> mapaTipo = catalogoService.createMap(listaTipo);
		Map<Integer, ClCatalogoVO> mapaEstatus = catalogoService.createMap(listaEstatus);

		listaProveedores = clProovedorDAO.getProovedores();

		for (ClProveedorVO clProveedorVO : listaProveedores) {
			ClProveedorAuxVO clProveedorAuxVO = new ClProveedorAuxVO(clProveedorVO);
			clProveedorAuxVO.setCatalogoTipoEstatus(mapaEstatus.get(clProveedorVO.getIdEstatus()));
			clProveedorAuxVO.setCatalogoTipoProveedor(mapaTipo.get(clProveedorVO.getIdTipo()));

			listaProveedoresAux.add(clProveedorAuxVO);

		}

		return listaProveedoresAux;
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		clProovedorDAO.setDinamicDataSource(dataSource);
	}

	@Override
	public void deleteProovedor(int id) throws DataIntegrityViolationException {
		clProovedorDAO.deleteProovedor(id);
	}

	@Override
	public void updateProovedor(ClProveedorVO clProovedorVO) {
		clProovedorDAO.updateProovedor(clProovedorVO);
	}

	@Override
	public List<ClProveedorVO> getProovedoresVO() {
		return clProovedorDAO.getProovedores();
	}

	@Override
	public Map<Integer, ClProveedorVO> createMap(List<ClProveedorVO> proveedorList) {
		Map<Integer, ClProveedorVO> mapa = new HashMap<Integer, ClProveedorVO>();
		for (ClProveedorVO proveedor : proveedorList) {
			mapa.put(proveedor.getId(), proveedor);
		}
		return mapa;
	}

	@Override
	public int getId(ClProveedorVO clProveedorVO) {
		return clProovedorDAO.getId(clProveedorVO);
	}
}
