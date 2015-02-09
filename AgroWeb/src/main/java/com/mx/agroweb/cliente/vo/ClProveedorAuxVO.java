package com.mx.agroweb.cliente.vo;

public class ClProveedorAuxVO extends ClProveedorVO{
	
	private ClCatalogoVO catalogoTipoProveedor;
	private ClCatalogoVO catalogoTipoEstatus;
	
	public ClProveedorAuxVO(ClProveedorVO clProveedorVO)
	{
		super(clProveedorVO);
	}
	
	public ClCatalogoVO getCatalogoTipoProveedor() {
		return catalogoTipoProveedor;
	}
	public void setCatalogoTipoProveedor(ClCatalogoVO catalogoTipoProveedor) {
		this.catalogoTipoProveedor = catalogoTipoProveedor;
	}
	public ClCatalogoVO getCatalogoTipoEstatus() {
		return catalogoTipoEstatus;
	}
	public void setCatalogoTipoEstatus(ClCatalogoVO catalogoTipoEstatus) {
		this.catalogoTipoEstatus = catalogoTipoEstatus;
	}
	
	

}
