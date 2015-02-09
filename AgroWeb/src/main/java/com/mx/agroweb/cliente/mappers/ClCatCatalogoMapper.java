package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.agroweb.cliente.vo.ClCatalogoVO;

public class ClCatCatalogoMapper implements RowMapper<ClCatalogoVO> {

	@Override
	public ClCatalogoVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		ClCatalogoVO catalogoVO = new ClCatalogoVO();

		catalogoVO.setId(rs.getInt(ClCatalogoVO.COLUMN_ID));
		catalogoVO.setIdCatalogo(rs.getInt(ClCatalogoVO.COLUMN_ID_CATALOGO));
		catalogoVO.setIdElemento(rs.getInt(ClCatalogoVO.COLUMN_ID_ELEMENTO));
		catalogoVO.setNombre(rs.getString(ClCatalogoVO.COLUMN_NOMBRE));

		return catalogoVO;
	}

}
