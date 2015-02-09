package com.mx.agroweb.cliente.vo;


public class ClPropietarioVO {

	private int id;
	private String descripcion;
	
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_DESCRIPCION = "prop_descripcion";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
