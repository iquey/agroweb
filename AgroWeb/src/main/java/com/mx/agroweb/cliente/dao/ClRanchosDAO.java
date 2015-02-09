package com.mx.agroweb.cliente.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClRanchosVO;

public interface ClRanchosDAO {

	
	public final String QUERY_INSERT = "INSERT INTO CAT_RANCHOS(ran_descripcion, ran_id_zona) VALUES (?,?)";
	public final String QUERY_GET_BY_ID = "SELECT * FROM CAT_RANCHOS WHERE BINARY ID = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_RANCHOS";
	public final String QUERY_DELETE_BY_ID = "DELETE FROM CAT_RANCHOS WHERE BINARY ID = ?";
	public final String QUERY_UPDATE_BY_ID = "UPDATE CAT_RANCHOS SET	ran_descripcion = ?, ran_id_zona = ? WHERE BINARY ID = ?;";
	public final String QUERY_GET_ID = "SELECT ID FROM CAT_RANCHOS WHERE BINARY ran_descripcion = ? AND ran_id_zona = ?";
	
	public void insertRancho(ClRanchosVO clRanchosVO);

	public ClRanchosVO getRancho(int id);

	public List<ClRanchosVO> getRanchos();

	public void setDinamicDataSource(DataSource dataSource);
	
	public void deleteRancho(int id) throws DataIntegrityViolationException;
	
	public void updateRancho(ClRanchosVO clRanchosVO);
	
	public int getId(ClRanchosVO clRanchosVO);
	
}
