package com.mx.agroweb.cliente.service;

import java.util.List;
import java.util.Map;

import com.mx.agroweb.cliente.vo.ClCatalogoVO;

public interface ClCatCatalogoService {

	public List<ClCatalogoVO> getCatalogoByCatalogo(int idCatalogo);

	public List<ClCatalogoVO> getCatalogoByCatalogoElemento(int idCatalogo, int idElemento);

	public void insert(ClCatalogoVO catalogoVO);

	public void createCatalogByCatalog(ClCatalogoVO catalogoVO);

	public void setDinamicDataSource();

	public Map<Integer, ClCatalogoVO> createMap(List<ClCatalogoVO> listaCatalogo);
	
	public int getId(ClCatalogoVO clCatalogoVO);

}
