package com.mx.agroweb.cliente.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClRanchosAuxVO;
import com.mx.agroweb.cliente.vo.ClRanchosVO;

public interface ClRanchosService {

	public void insertRancho(ClRanchosVO clRanchosVO);

	public ClRanchosAuxVO getRancho(int id);

	public List<ClRanchosAuxVO> getRanchos();
	
	public List<ClRanchosVO> getRanchosVO();

	public void setDinamicDataSource();

	public void deleteRancho(int id) throws DataIntegrityViolationException ;

	public void updateRancho(ClRanchosVO clRanchosVO);

	public Map<Integer, ClRanchosVO> createMap(List<ClRanchosVO> listaRancho);
	
	public int getId(ClRanchosVO clRanchosVO);

}
