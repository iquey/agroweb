package com.mx.agroweb.cliente.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class ClRanchosVO {

	private int id;
	private String descripcion;
	private int idZona;

	public static final String COLUMN_ID = "id";
	public static final String COLUMN_DESCRIPCION = "ran_descripcion";
	public static final String COLUMN_ID_ZONA = "ran_id_zona";
	
	public ClRanchosVO()
	{
		
	}

	public ClRanchosVO(ClRanchosVO clRanchosVO) {
		try {
			BeanUtils.copyProperties(this, clRanchosVO);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

	public int getIdZona() {
		return idZona;
	}

	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}
}
