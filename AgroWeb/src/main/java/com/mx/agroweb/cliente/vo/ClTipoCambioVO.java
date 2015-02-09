package com.mx.agroweb.cliente.vo;


public class ClTipoCambioVO {

	private int id;
	private String fecha;
	private String tipoCambio;
	
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_FECHA = "tcam_fecha";
	public static final String COLUMN_TIPO_CAMBIO = "tcam_tipo_cambio";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
}
