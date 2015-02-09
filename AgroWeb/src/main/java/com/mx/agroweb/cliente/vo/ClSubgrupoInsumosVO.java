package com.mx.agroweb.cliente.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class ClSubgrupoInsumosVO {

	private int id;
	private String descripcion;
	private int idGrupo;

	public static final String COLUMN_ID = "id";
	public static final String COLUMN_DESCRIPCION = "sgi_descripcion";
	public static final String COLUMN_ID_GRUPO = "sgi_id_grupo";
	
	public ClSubgrupoInsumosVO()
	{
		
	}

	public ClSubgrupoInsumosVO(ClSubgrupoInsumosVO clSubgrupoInsumosVO) {
		try {
			BeanUtils.copyProperties(this, clSubgrupoInsumosVO);
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

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
}
