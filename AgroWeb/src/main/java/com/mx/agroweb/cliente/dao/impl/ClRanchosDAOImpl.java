package com.mx.agroweb.cliente.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.mx.agroweb.cliente.dao.ClRanchosDAO;
import com.mx.agroweb.cliente.mappers.ClRanchosMapper;
import com.mx.agroweb.cliente.vo.ClRanchosVO;

@Component
public class ClRanchosDAOImpl extends JdbcDaoSupport implements ClRanchosDAO {

	@Autowired
	public ClRanchosDAOImpl(DataSource dataSourceTemp) {
		setDataSource(dataSourceTemp);
	}

	@Override
	public void insertRancho(ClRanchosVO clRanchosVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(QUERY_INSERT,
				new Object[] { clRanchosVO.getDescripcion(), clRanchosVO.getIdZona() });

	}

	@Override
	public ClRanchosVO getRancho(int id) {
		ClRanchosVO clRanchosVO = null;
		try {
			clRanchosVO = getJdbcTemplate().queryForObject(QUERY_GET_BY_ID, new Object[] { id },
					new ClRanchosMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return clRanchosVO;
	}

	@Override
	public List<ClRanchosVO> getRanchos() {
		List<ClRanchosVO> RanchosList = getJdbcTemplate().query(QUERY_GET_ALL,
				new ClRanchosMapper());
		return RanchosList;
	}

	@Override
	public void setDinamicDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void deleteRancho(int id) throws DataIntegrityViolationException{
		getJdbcTemplate().update(QUERY_DELETE_BY_ID, new Object[] { id });
	}

	@Override
	public void updateRancho(ClRanchosVO clRanchosVO) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(
				QUERY_UPDATE_BY_ID,
				new Object[] { clRanchosVO.getDescripcion(), clRanchosVO.getIdZona(),
						clRanchosVO.getId() });
	}

	@Override
	public int getId(ClRanchosVO clRanchosVO) {

		Integer idSubZona = (Integer) getJdbcTemplate().queryForObject(QUERY_GET_ID,
				new Object[] { clRanchosVO.getDescripcion(), clRanchosVO.getIdZona() }, Integer.class);
		if (idSubZona != null)
			return idSubZona.intValue();
		return 0;
	}
}
