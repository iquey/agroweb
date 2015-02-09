package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.agroweb.cliente.vo.ClCatalogoVO;

public class ClCatCatalogoMapperAux implements RowMapper<ClCatalogoVO> {

	@Override
	public ClCatalogoVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		ClCatalogoVO catalogoVO = new ClCatalogoVO();

		catalogoVO.setIdElemento(rs.getInt(ClCatalogoVO.COLUMN_ID_ELEMENTO));

		return catalogoVO;
	}

}
