package com.mx.agroweb.cliente.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.agroweb.cliente.dao.ClCatCatalogoDAO;
import com.mx.agroweb.cliente.service.ClCatCatalogoService;
import com.mx.agroweb.cliente.vo.ClCatalogoVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClCatCatalogoServiceImpl implements ClCatCatalogoService {

	@Autowired
	ClCatCatalogoDAO catCatalogoDAO;

	@Override
	public List<ClCatalogoVO> getCatalogoByCatalogo(int idCatalogo) {
		return catCatalogoDAO.getCatalogoByCatalogo(idCatalogo);
	}

	@Override
	public List<ClCatalogoVO> getCatalogoByCatalogoElemento(int idCatalogo, int idElemento) {
		return catCatalogoDAO.getCatalogoByCatalogoElemento(idCatalogo, idElemento);
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		catCatalogoDAO.setDinamicDataSource(dataSource);
	}

	@Override
	public Map<Integer, ClCatalogoVO> createMap(List<ClCatalogoVO> listaCatalogo) {

		Map<Integer, ClCatalogoVO> mapa = new HashMap<Integer, ClCatalogoVO>();

		for (ClCatalogoVO catalogo : listaCatalogo) {
			mapa.put(catalogo.getId(), catalogo);
		}

		return mapa;
	}

	@Override
	public void insert(ClCatalogoVO catalogoVO) {
		catCatalogoDAO.insert(catalogoVO);
	}

	@Override
	public void createCatalogByCatalog(ClCatalogoVO catalogoVO) {

		Integer maxCatalog = catCatalogoDAO.getIdElement(catalogoVO.getIdCatalogo());

		catalogoVO.setIdElemento(maxCatalog.intValue());

		catCatalogoDAO.insert(catalogoVO);
	}

	@Override
	public int getId(ClCatalogoVO clCatalogoVO) {
		return catCatalogoDAO.getId(clCatalogoVO);
	}

}
