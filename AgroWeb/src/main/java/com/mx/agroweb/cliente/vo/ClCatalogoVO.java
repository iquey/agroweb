package com.mx.agroweb.cliente.vo;

public class ClCatalogoVO {
		
	private int id; //int(11) NOT NULL AUTO_INCREMENT,
	private int  idCatalogo; //int(11) DEFAULT NULL,
	private int idElemento; //int(11) DEFAULT NULL,
	private String  nombre; //varchar(65) DEFAULT NULL,
	
	public static final String COLUMN_ID ="id";
	public static final String COLUMN_ID_CATALOGO ="cat_id_catalogo";
	public static final String COLUMN_ID_ELEMENTO ="cat_id_elemento";
	public static final String COLUMN_NOMBRE ="cat_nombre";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCatalogo() {
		return idCatalogo;
	}
	public void setIdCatalogo(int idCatalogo) {
		this.idCatalogo = idCatalogo;
	}
	public int getIdElemento() {
		return idElemento;
	}
	public void setIdElemento(int idElemento) {
		this.idElemento = idElemento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
