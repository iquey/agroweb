package com.mx.agroweb.cliente.vo;

public class ClRanchosAuxVO extends ClRanchosVO{
	
	private ClZonasVO catalogoZonas;
	
	public ClRanchosAuxVO(ClRanchosVO clRanchosVO)
	{
		super(clRanchosVO);
	}
	
	public ClZonasVO getCatalogoZonas() {
		return catalogoZonas;
	}
	public void setCatalogoZonas(ClZonasVO catalogoZonas) {
		this.catalogoZonas = catalogoZonas;
	}
}
