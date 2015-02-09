package com.mx.agroweb.cliente.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClTipoCambioVO;

public interface ClTipoCambioService {
	
	public void insertTipoCambio(ClTipoCambioVO clTipoCambioVO);
	
	public ClTipoCambioVO getTipoCambio(int id);

	public List<ClTipoCambioVO> getTiposCambio();

	public void setDinamicDataSource();
	
	public void deleteTipoCambio(int id) throws DataIntegrityViolationException;
	
	public void updateTipoCambio(ClTipoCambioVO clTipoCambioVO);
	
	public Map<Integer, ClTipoCambioVO> createMap(List<ClTipoCambioVO> listaTipoCambio);
	
	public int getId(ClTipoCambioVO clTipoCambioVO);
}
