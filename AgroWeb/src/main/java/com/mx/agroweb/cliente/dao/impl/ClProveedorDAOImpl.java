package com.mx.agroweb.cliente.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.mx.agroweb.cliente.dao.ClProveedorDAO;
import com.mx.agroweb.cliente.mappers.ClProveedorMapper;
import com.mx.agroweb.cliente.vo.ClProveedorVO;

@Component
public class ClProveedorDAOImpl extends JdbcDaoSupport implements ClProveedorDAO {

	@Autowired
	public ClProveedorDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertProovedor(ClProveedorVO clProovedorVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(
				QUERY_INSERT,
				new Object[] { clProovedorVO.getNombre(), clProovedorVO.getNombreCompleto(), clProovedorVO.getIdTipo(),
						clProovedorVO.getDireccion(), clProovedorVO.getColonia(), clProovedorVO.getCiudad(),
						clProovedorVO.getEstado(), clProovedorVO.getCodigoPostal(), clProovedorVO.getTelefono(),
						clProovedorVO.getTelefono1(), clProovedorVO.getCelular(), clProovedorVO.getRfc(),
						clProovedorVO.getCurp(), clProovedorVO.getEmail(), clProovedorVO.getFechaAlta(),
						clProovedorVO.getIdEstatus() });

	}

	@Override
	public ClProveedorVO getProovedor(int id) {
		ClProveedorVO clProovedorVO = null;
		try {
			clProovedorVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_ID, new Object[] { id },
					new ClProveedorMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return clProovedorVO;
	}

	@Override
	public List<ClProveedorVO> getProovedores() {
		List<ClProveedorVO> proovedoresList = getJdbcTemplate().query(QUERY_GET_ALL, new ClProveedorMapper());
		return proovedoresList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void deleteProovedor(int id) throws DataIntegrityViolationException {
		getJdbcTemplate().update(QUERY_DELETE_BY_ID, new Object[] { id });
	}

	@Override
	public void updateProovedor(ClProveedorVO clProovedorVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(
				QUERY_UPDATE_BY_ID,
				new Object[] { clProovedorVO.getNombre(), clProovedorVO.getNombreCompleto(), clProovedorVO.getIdTipo(),
						clProovedorVO.getDireccion(), clProovedorVO.getColonia(), clProovedorVO.getCiudad(),
						clProovedorVO.getEstado(), clProovedorVO.getCodigoPostal(), clProovedorVO.getTelefono(),
						clProovedorVO.getTelefono1(), clProovedorVO.getCelular(), clProovedorVO.getRfc(),
						clProovedorVO.getCurp(), clProovedorVO.getEmail(), clProovedorVO.getFechaAlta(),
						clProovedorVO.getIdEstatus(), clProovedorVO.getId() });
	}

	@Override
	public int getId(ClProveedorVO clProveedorVO) {
		Integer idProveedor = (Integer) getJdbcTemplate().queryForObject(QUERY_GET_ID,
				new Object[] { clProveedorVO.getNombre() }, Integer.class);
		if (idProveedor != null)
			return idProveedor.intValue();
		return 0;
	}

}
