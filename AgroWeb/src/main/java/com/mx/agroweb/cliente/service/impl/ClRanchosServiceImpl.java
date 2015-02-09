package com.mx.agroweb.cliente.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mx.agroweb.cliente.dao.ClRanchosDAO;
import com.mx.agroweb.cliente.service.ClRanchosService;
import com.mx.agroweb.cliente.service.ClZonasService;
import com.mx.agroweb.cliente.vo.ClRanchosAuxVO;
import com.mx.agroweb.cliente.vo.ClRanchosVO;
import com.mx.agroweb.cliente.vo.ClZonasVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClRanchosServiceImpl implements ClRanchosService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4926615154209326575L;

	@Autowired
	ClZonasService zonasService;

	@Autowired
	ClRanchosDAO clRanchosDAO;

	@Override
	public void insertRancho(ClRanchosVO clRanchosVO) {
		clRanchosDAO.insertRancho(clRanchosVO);

	}

	@Override
	public ClRanchosAuxVO getRancho(int id) {
		return null;
	}

	@Override
	public List<ClRanchosAuxVO> getRanchos() {

		List<ClZonasVO> listaZonas = new ArrayList<ClZonasVO>();
		List<ClRanchosVO> listaRanchos = new ArrayList<ClRanchosVO>();
		List<ClRanchosAuxVO> listaRanchosAux = new ArrayList<ClRanchosAuxVO>();

		zonasService.setDinamicDataSource();
		listaZonas = zonasService.getZonas();
		Map<Integer, ClZonasVO> mapaZonas = zonasService.createMap(listaZonas);

		//
		listaRanchos = clRanchosDAO.getRanchos();
		//
		for (ClRanchosVO clRanchosVO : listaRanchos) {

			ClRanchosAuxVO clRanchosAuxVO = new ClRanchosAuxVO(clRanchosVO);

			clRanchosAuxVO.setCatalogoZonas(mapaZonas.get(clRanchosAuxVO.getIdZona()));

			listaRanchosAux.add(clRanchosAuxVO);

		}

		return listaRanchosAux;
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		clRanchosDAO.setDinamicDataSource(dataSource);
	}

	@Override
	public void deleteRancho(int id) throws DataIntegrityViolationException {
		clRanchosDAO.deleteRancho(id);
	}

	@Override
	public void updateRancho(ClRanchosVO clRanchosVO) {
		clRanchosDAO.updateRancho(clRanchosVO);
	}

	@Override
	public Map<Integer, ClRanchosVO> createMap(List<ClRanchosVO> listaSubGrupo) {
		Map<Integer, ClRanchosVO> mapa = new HashMap<Integer, ClRanchosVO>();

		for (ClRanchosVO subGrupo : listaSubGrupo) {
			mapa.put(subGrupo.getId(), subGrupo);
		}

		return mapa;
	}

	@Override
	public int getId(ClRanchosVO clRanchosVO) {
		return clRanchosDAO.getId(clRanchosVO);
	}

	@Override
	public List<ClRanchosVO> getRanchosVO() {
		return clRanchosDAO.getRanchos();
	}

}
