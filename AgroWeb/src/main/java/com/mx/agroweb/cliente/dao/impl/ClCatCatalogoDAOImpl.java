package com.mx.agroweb.cliente.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.mx.agroweb.cliente.dao.ClCatCatalogoDAO;
import com.mx.agroweb.cliente.mappers.ClCatCatalogoMapper;
import com.mx.agroweb.cliente.mappers.ClCatCatalogoMapperAux;
import com.mx.agroweb.cliente.vo.ClCatalogoVO;

@Component
public class ClCatCatalogoDAOImpl extends JdbcDaoSupport implements ClCatCatalogoDAO {

	@Autowired
	public ClCatCatalogoDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public List<ClCatalogoVO> getCatalogoByCatalogo(int idCatalogo) {

		List<ClCatalogoVO> catalogoList = getJdbcTemplate().query(QUERY_GET_CATALOG_BY_CATALOG,
				new Object[] { idCatalogo }, new ClCatCatalogoMapper());
		return catalogoList;
	}

	@Override
	public List<ClCatalogoVO> getCatalogoByCatalogoElemento(int idCatalogo, int idElemento) {

		List<ClCatalogoVO> catalogoList = getJdbcTemplate().query(QUERY_GET_CATALOG_BY_ELEMENT,
				new Object[] { idCatalogo, idElemento }, new ClCatCatalogoMapper());
		return catalogoList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public Integer getIdElement(int idCatalogo) {

		Integer idElement = (Integer) getJdbcTemplate().queryForObject(QUERY_GET_CATALOG_ID_CATALOG,
				new Object[] { idCatalogo }, Integer.class);

		return idElement;
	}

	@Override
	public void insert(ClCatalogoVO clCatalogoVO) {
		getJdbcTemplate().update(QUERY_INSERT,
				new Object[] { clCatalogoVO.getIdCatalogo(), clCatalogoVO.getIdElemento(), clCatalogoVO.getNombre() });
	}

	@Override
	public int getId(ClCatalogoVO clCatalogoVO) {

		Integer idCatalogo = (Integer) getJdbcTemplate().queryForObject(QUERY_GET_ID,
				new Object[] { clCatalogoVO.getIdCatalogo(), clCatalogoVO.getIdElemento() }, Integer.class);
		if (idCatalogo != null)
			return idCatalogo.intValue();
		return 0;
	}

}
