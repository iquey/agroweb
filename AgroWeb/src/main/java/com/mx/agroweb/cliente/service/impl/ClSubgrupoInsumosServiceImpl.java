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

import com.mx.agroweb.cliente.dao.ClGrupoInsumosDAO;
import com.mx.agroweb.cliente.dao.ClSubgrupoInsumosDAO;
import com.mx.agroweb.cliente.service.ClGrupoInsumosService;
import com.mx.agroweb.cliente.service.ClSubgrupoInsumosService;
import com.mx.agroweb.cliente.utils.ConstantesClienteCatCatalogo;
import com.mx.agroweb.cliente.vo.ClCatalogoVO;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClProveedorAuxVO;
import com.mx.agroweb.cliente.vo.ClProveedorVO;
import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosAuxVO;
import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClSubgrupoInsumosServiceImpl implements ClSubgrupoInsumosService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4926615154209326575L;

	@Autowired
	ClGrupoInsumosService grupoInsumosService;

	@Autowired
	ClSubgrupoInsumosDAO clSubgrupoInsumosDAO;

	@Override
	public void insertSubgrupoInsumos(ClSubgrupoInsumosVO clSubgrupoInsumosVO) {
		clSubgrupoInsumosDAO.insertSubgrupoInsumos(clSubgrupoInsumosVO);

	}

	@Override
	public ClSubgrupoInsumosAuxVO getSubgrupoInsumos(int id) {
		return null;
	}

	@Override
	public List<ClSubgrupoInsumosAuxVO> getSubgrupoInsumos() {

		List<ClGrupoInsumosVO> listaGrupos = new ArrayList<ClGrupoInsumosVO>();
		List<ClSubgrupoInsumosVO> listaSubGrupoInsumos = new ArrayList<ClSubgrupoInsumosVO>();
		List<ClSubgrupoInsumosAuxVO> listaSubgrupoInsumosAux = new ArrayList<ClSubgrupoInsumosAuxVO>();

		grupoInsumosService.setDinamicDataSource();
		listaGrupos = grupoInsumosService.getGrupoInsumos();
		Map<Integer, ClGrupoInsumosVO> mapaGrupos = grupoInsumosService.createMap(listaGrupos);

		//
		listaSubGrupoInsumos = clSubgrupoInsumosDAO.getSubgruposInsumos();
		//
		for (ClSubgrupoInsumosVO clSubgrupoInsumosVO : listaSubGrupoInsumos) {

			ClSubgrupoInsumosAuxVO clSubgrupoInsumosAuxVO = new ClSubgrupoInsumosAuxVO(clSubgrupoInsumosVO);

			clSubgrupoInsumosAuxVO.setCatalogoGrupoInsumo(mapaGrupos.get(clSubgrupoInsumosAuxVO.getIdGrupo()));

			listaSubgrupoInsumosAux.add(clSubgrupoInsumosAuxVO);

		}

		return listaSubgrupoInsumosAux;
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		clSubgrupoInsumosDAO.setDinamicDataSource(dataSource);
	}

	@Override
	public void deleteSubgrupoInsumos(int id) throws DataIntegrityViolationException{
		clSubgrupoInsumosDAO.deleteSubgrupoInsumos(id);
	}

	@Override
	public void updateSubgrupoInsumos(ClSubgrupoInsumosVO clSubgrupoInsumosVO) {
		clSubgrupoInsumosDAO.updateSubgrupoInsumos(clSubgrupoInsumosVO);
	}

	@Override
	public Map<Integer, ClSubgrupoInsumosAuxVO> createMap(List<ClSubgrupoInsumosAuxVO> listaSubGrupo) {
		Map<Integer, ClSubgrupoInsumosAuxVO> mapa = new HashMap<Integer, ClSubgrupoInsumosAuxVO>();

		for (ClSubgrupoInsumosAuxVO subGrupo : listaSubGrupo) {
			mapa.put(subGrupo.getId(), subGrupo);
		}

		return mapa;
	}

	@Override
	public int getId(ClSubgrupoInsumosVO clSubgrupoInsumosVO) {
		return clSubgrupoInsumosDAO.getId(clSubgrupoInsumosVO);
	}

}
