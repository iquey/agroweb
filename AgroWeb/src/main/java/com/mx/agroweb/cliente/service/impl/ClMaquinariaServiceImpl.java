package com.mx.agroweb.cliente.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mx.agroweb.cliente.dao.ClMaquinariaDAO;
import com.mx.agroweb.cliente.service.ClGrupoMaquinariaService;
import com.mx.agroweb.cliente.service.ClMaquinariaService;
import com.mx.agroweb.cliente.service.ClMarcasService;
import com.mx.agroweb.cliente.service.ClPropietarioService;
import com.mx.agroweb.cliente.service.ClProveedorService;
import com.mx.agroweb.cliente.service.ClRanchosService;
import com.mx.agroweb.cliente.service.ClTipoCambioService;
import com.mx.agroweb.cliente.vo.ClGrupoMaquinariaVO;
import com.mx.agroweb.cliente.vo.ClMaquinariaAuxVO;
import com.mx.agroweb.cliente.vo.ClMaquinariaVO;
import com.mx.agroweb.cliente.vo.ClMarcasVO;
import com.mx.agroweb.cliente.vo.ClPropietarioVO;
import com.mx.agroweb.cliente.vo.ClProveedorVO;
import com.mx.agroweb.cliente.vo.ClRanchosVO;
import com.mx.agroweb.cliente.vo.ClTipoCambioVO;
import com.mx.agroweb.utils.DataSourceUtils;

@Service
public class ClMaquinariaServiceImpl implements ClMaquinariaService {

	@Autowired
	ClMaquinariaDAO clMaquinariaDAO;

	@Autowired
	ClGrupoMaquinariaService clGrupoMaquinariaService;

	@Autowired
	ClMarcasService clMarcasService;

	@Autowired
	ClPropietarioService clPropietarioService;

	@Autowired
	ClRanchosService clRanchosService;

	@Autowired
	ClTipoCambioService clTipoCambioService;

	@Autowired
	ClProveedorService clProveedorService;

	@Override
	public void insertMaquinaria(ClMaquinariaVO clMaquinariaVO) {
		clMaquinariaDAO.insertMaquinaria(clMaquinariaVO);
	}

	@Override
	public ClMaquinariaVO getMaquinariaById(int id) {
		return clMaquinariaDAO.getMaquinaria(id);
	}

	@Override
	public List<ClMaquinariaAuxVO> getMaquinaria() {

		List<ClGrupoMaquinariaVO> grupoMaquinariaList = clGrupoMaquinariaService.getGrupoMaquinaria();
		List<ClMarcasVO> marcasList = clMarcasService.getMarcas();
		List<ClPropietarioVO> propietarioList = clPropietarioService.getPropietarios();
		List<ClRanchosVO> ranchosList = clRanchosService.getRanchosVO();
		List<ClTipoCambioVO> tipoCambioList = clTipoCambioService.getTiposCambio();
		List<ClProveedorVO> proveedorList = clProveedorService.getProovedoresVO();

		List<ClMaquinariaAuxVO> maquinariaAuxList = new ArrayList<>();

		List<ClMaquinariaVO> maquinariaList = clMaquinariaDAO.getMaquinarias();

		// MAPAS
		Map<Integer, ClGrupoMaquinariaVO> mapaGrupoMaq = clGrupoMaquinariaService.createMap(grupoMaquinariaList);
		Map<Integer, ClMarcasVO> mapaMarcas = clMarcasService.createMap(marcasList);
		Map<Integer, ClPropietarioVO> mapaPropietario = clPropietarioService.createMap(propietarioList);
		Map<Integer, ClRanchosVO> mapaRanchos = clRanchosService.createMap(ranchosList);
		Map<Integer, ClTipoCambioVO> mapaTipoCambio = clTipoCambioService.createMap(tipoCambioList);
		Map<Integer, ClProveedorVO> mapaProveedor = clProveedorService.createMap(proveedorList);

		for (ClMaquinariaVO clMaquinariaVO : maquinariaList) {

			ClMaquinariaAuxVO clMaquinariaAuxVO = new ClMaquinariaAuxVO(clMaquinariaVO);

			clMaquinariaAuxVO.setIdGrupoMaquinariaVO(mapaGrupoMaq.get(clMaquinariaAuxVO.getIdGrupo()));
			clMaquinariaAuxVO.setIdMarcaVO(mapaMarcas.get(clMaquinariaAuxVO.getIdMarca()));
			clMaquinariaAuxVO.setIdPropietarioVO(mapaPropietario.get(clMaquinariaAuxVO.getIdPropietario()));
			clMaquinariaAuxVO.setIdRanchosVO(mapaRanchos.get(clMaquinariaAuxVO.getIdRancho()));
			clMaquinariaAuxVO.setIdTipoCambioVO(mapaTipoCambio.get(clMaquinariaAuxVO.getIdTipoCambio()));
			clMaquinariaAuxVO.setIdProveedorVO(mapaProveedor.get(clMaquinariaAuxVO.getIdProveedor()));

			maquinariaAuxList.add(clMaquinariaAuxVO);
		}

		return maquinariaAuxList;
	}

	@Override
	public List<ClMaquinariaVO> getMaquinariaVO() {
		return clMaquinariaDAO.getMaquinarias();
	}

	@Override
	public void setDinamicDataSource() {

		DataSource dataSource = DataSourceUtils.getDataSource();
		clMaquinariaDAO.setDinamicDataSource(dataSource);

	}

	@Override
	public void deleteMaquinaria(int id) throws DataIntegrityViolationException {
		clMaquinariaDAO.deleteMaquinaria(id);
	}

	@Override
	public void updateMaquinaria(ClMaquinariaVO clMaquinariaVO) {
		clMaquinariaDAO.updateMaquinaria(clMaquinariaVO);
	}

}
