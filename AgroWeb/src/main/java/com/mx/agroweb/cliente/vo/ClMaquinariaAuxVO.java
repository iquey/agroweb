package com.mx.agroweb.cliente.vo;

import java.io.ByteArrayInputStream;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class ClMaquinariaAuxVO extends ClMaquinariaVO {

	private ClGrupoMaquinariaVO idGrupoMaquinariaVO;
	private ClMarcasVO idMarcaVO;
	private ClPropietarioVO idPropietarioVO;
	private ClRanchosVO idRanchosVO;
	private ClTipoCambioVO idTipoCambioVO;
	private ClProveedorVO idProveedorVO;
	private StreamedContent img;

	public ClMaquinariaAuxVO(ClMaquinariaVO clMaquinariaVO) {
		super(clMaquinariaVO);
	}

	public ClGrupoMaquinariaVO getIdGrupoMaquinariaVO() {
		return idGrupoMaquinariaVO;
	}

	public void setIdGrupoMaquinariaVO(ClGrupoMaquinariaVO idGrupoMaquinariaVO) {
		this.idGrupoMaquinariaVO = idGrupoMaquinariaVO;
	}

	public ClMarcasVO getIdMarcaVO() {
		return idMarcaVO;
	}

	public void setIdMarcaVO(ClMarcasVO idMarcaVO) {
		this.idMarcaVO = idMarcaVO;
	}

	public ClPropietarioVO getIdPropietarioVO() {
		return idPropietarioVO;
	}

	public void setIdPropietarioVO(ClPropietarioVO idPropietarioVO) {
		this.idPropietarioVO = idPropietarioVO;
	}

	public ClRanchosVO getIdRanchosVO() {
		return idRanchosVO;
	}

	public void setIdRanchosVO(ClRanchosVO idRanchosVO) {
		this.idRanchosVO = idRanchosVO;
	}

	public ClTipoCambioVO getIdTipoCambioVO() {
		return idTipoCambioVO;
	}

	public void setIdTipoCambioVO(ClTipoCambioVO idTipoCambioVO) {
		this.idTipoCambioVO = idTipoCambioVO;
	}

	public ClProveedorVO getIdProveedorVO() {
		return idProveedorVO;
	}

	public void setIdProveedorVO(ClProveedorVO idProveedorVO) {
		this.idProveedorVO = idProveedorVO;
	}

	public StreamedContent getImg() {
		img = new DefaultStreamedContent(new ByteArrayInputStream(this.getFoto()));
		return img;
	}

	public void setImg(StreamedContent img) {
		this.img = img;
	}
	
}