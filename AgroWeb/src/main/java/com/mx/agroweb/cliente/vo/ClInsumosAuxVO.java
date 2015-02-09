package com.mx.agroweb.cliente.vo;

public class ClInsumosAuxVO extends ClInsumosVO {

	private ClSubgrupoInsumosAuxVO catalogoSubgrupoInsumos;
	private ClCatalogoVO catalogoUnidadCompra;
	private ClCatalogoVO catalogoUnidadVenta;
	private ClCentroCostosVO catalogoCentroCostos;

	public ClInsumosAuxVO(ClInsumosVO clInsumosVO) {
		super(clInsumosVO);
	}

	public ClSubgrupoInsumosAuxVO getCatalogoSubgrupoInsumos() {
		return catalogoSubgrupoInsumos;
	}

	public void setCatalogoSubgrupoInsumos(ClSubgrupoInsumosAuxVO catalogoSubgrupoInsumos) {
		this.catalogoSubgrupoInsumos = catalogoSubgrupoInsumos;
	}

	public ClCentroCostosVO getCatalogoCentroCostos() {
		return catalogoCentroCostos;
	}

	public ClCatalogoVO getCatalogoUnidadCompra() {
		return catalogoUnidadCompra;
	}

	public void setCatalogoUnidadCompra(ClCatalogoVO catalogoUnidadCompra) {
		this.catalogoUnidadCompra = catalogoUnidadCompra;
	}

	public ClCatalogoVO getCatalogoUnidadVenta() {
		return catalogoUnidadVenta;
	}

	public void setCatalogoUnidadVenta(ClCatalogoVO catalogoUnidadVenta) {
		this.catalogoUnidadVenta = catalogoUnidadVenta;
	}

	public void setCatalogoCentroCostos(ClCentroCostosVO catalogoCentroCostos) {
		this.catalogoCentroCostos = catalogoCentroCostos;
	}
}
