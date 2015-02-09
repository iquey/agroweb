package com.mx.agroweb.cliente.dao;

import java.util.List;

import javax.sql.DataSource;

import com.mx.agroweb.cliente.vo.ClCatalogoVO;

public interface ClCatCatalogoDAO {

	public final String QUERY_INSERT = "INSERT INTO CAT_CATALOGO (CAT_ID_CATALOGO,CAT_ID_ELEMENTO,CAT_NOMBRE) VALUES (?, ?, ?)";

	public final String QUERY_GET_CATALOG_BY_CATALOG = "SELECT * FROM CAT_CATALOGO WHERE CAT_ID_CATALOGO = ?  AND CAT_ID_ELEMENTO > 0; ";

	public final String QUERY_GET_CATALOG_BY_ELEMENT = "SELECT * FROM CAT_CATALOGO WHERE CAT_ID_CATALOGO = ? AND CAT_ID_ELEMENTO = ?";
	
	public final String QUERY_GET_ID = "SELECT ID FROM CAT_CATALOGO WHERE CAT_ID_CATALOGO = ? AND CAT_ID_ELEMENTO = ?";
	
	public final String QUERY_GET_CATALOG_ID_CATALOG = "select max(cat_id_elemento + 1) as cat_id_elemento from cat_catalogo where cat_id_catalogo = ?";

	public List<ClCatalogoVO> getCatalogoByCatalogo(int idCatalogo);
	
	public Integer getIdElement(int idCatalogo);
	
	public void insert(ClCatalogoVO clCatalogoVO);

	public List<ClCatalogoVO> getCatalogoByCatalogoElemento(int idCatalogo, int idElemento);

	public void setDinamicDataSource(DataSource dataSource);
	
	public int getId(ClCatalogoVO clCatalogoVO);

}
