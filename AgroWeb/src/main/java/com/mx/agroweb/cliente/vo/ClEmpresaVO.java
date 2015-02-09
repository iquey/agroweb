package com.mx.agroweb.cliente.vo;

public class ClEmpresaVO {

	private int id; // `id` int(11) NOT NULL AUTO_INCREMENT,
	private String nombre; // `nombre` varchar(45) DEFAULT NULL,
	private String direccion; // `direccion` varchar(45) DEFAULT NULL,

	public static final String COLUMN_ID ="id";
	public static final String COLUMN_NOMBRE ="emp_nombre";
	public static final String COLUMN_DIRECCION ="emp_direccion";
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
