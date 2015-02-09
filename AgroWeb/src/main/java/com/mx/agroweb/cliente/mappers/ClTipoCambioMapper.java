package com.mx.agroweb.cliente.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.mx.agroweb.cliente.vo.ClTipoCambioVO;

public class ClTipoCambioMapper implements RowMapper<ClTipoCambioVO>{

	@Override
	public ClTipoCambioVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClTipoCambioVO clTipoCambioVO = new ClTipoCambioVO();

		clTipoCambioVO.setId(rs.getInt(ClTipoCambioVO.COLUMN_ID));
		clTipoCambioVO.setFecha(rs.getString(ClTipoCambioVO.COLUMN_FECHA));
		clTipoCambioVO.setTipoCambio(rs.getString(ClTipoCambioVO.COLUMN_TIPO_CAMBIO));
	
		return clTipoCambioVO;
	}


}
