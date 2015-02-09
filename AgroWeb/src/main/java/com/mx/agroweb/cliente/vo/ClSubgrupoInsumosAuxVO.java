package com.mx.agroweb.cliente.vo;

public class ClSubgrupoInsumosAuxVO extends ClSubgrupoInsumosVO{
	
	private ClGrupoInsumosVO catalogoGrupoInsumo;
	
	public ClSubgrupoInsumosAuxVO(ClSubgrupoInsumosVO clSubgrupoInsumosVO)
	{
		super(clSubgrupoInsumosVO);
	}
	
	public ClGrupoInsumosVO getCatalogoGrupoInsumo() {
		return catalogoGrupoInsumo;
	}
	public void setCatalogoGrupoInsumo(ClGrupoInsumosVO catalogoGrupoInsumo) {
		this.catalogoGrupoInsumo = catalogoGrupoInsumo;
	}
}
