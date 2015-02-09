package com.mx.agroweb.cliente.vo;


public class ClGrupoInsumosVO {

	private int id;
	private String descripcion;
	private String orden;
	
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_DESCRIPCION = "gin_descripcion";
	public static final String COLUMN_ORDEN = "gin_orden";

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
	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}
}
