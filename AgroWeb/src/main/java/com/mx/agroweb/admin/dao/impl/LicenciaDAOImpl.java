package com.mx.agroweb.admin.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.mx.agroweb.admin.dao.LicenciaDAO;
import com.mx.agroweb.admin.mappers.LicenciaMapper;
import com.mx.agroweb.admin.vo.LicenciaVO;

@Component
public class LicenciaDAOImpl extends JdbcDaoSupport implements LicenciaDAO {

	private DataSource dataSource;

	@Autowired
	public LicenciaDAOImpl(DataSource dataSourceTemp) {

		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertLicencia(LicenciaVO licenciaVO) {
		getJdbcTemplate().update(
				QUERY_INSERT,
				new Object[] { licenciaVO.getNombreBase(), licenciaVO.getDireccionMac(), licenciaVO.getUsuario(),
						licenciaVO.getContrasena(), licenciaVO.getFechaInicio(), licenciaVO.getFechaFin(),
						licenciaVO.getIdCliente(), licenciaVO.getIdTipoLicencia() });

	}

	@Override
	public LicenciaVO getLicencia(String username, String password) {
		LicenciaVO licenciaVO = null;
		try {

			licenciaVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_USR_PASS, new Object[] { username, password },
					new LicenciaMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return licenciaVO;
	}

	@Override
	public List<LicenciaVO> getLicencias() {
		List<LicenciaVO> licenciaList = getJdbcTemplate().query(QUERY_GET_ALL, new LicenciaMapper());
		return licenciaList;
	}

	/**
	 * @param dataSource
	 *            the dataSource to set
	 */
	public void setDataSourceDynamic(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public LicenciaVO getLicenciaById(int id) {
		LicenciaVO licenciaVO = null;
		try {

			licenciaVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_ID, new Object[] { id }, new LicenciaMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return licenciaVO;
	}

}
