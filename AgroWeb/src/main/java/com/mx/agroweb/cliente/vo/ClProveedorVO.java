package com.mx.agroweb.cliente.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class ClProveedorVO {

	private int id;
	private String nombre;
	private String nombreCompleto;
	private String direccion;
	private int idTipo;
	private String colonia;
	private String ciudad;
	private String estado;
	private String codigoPostal;
	private String telefono;
	private String telefono1;
	private String celular;
	private String rfc;
	private String curp;
	private String email;
	private String fechaAlta;
	private int idEstatus;

	public static final String COLUMN_ID = "id";
	public static final String COLUMN_NOMBRE = "pro_nombre";
	public static final String COLUMN_NOMBRE_COMPLETO = "pro_nombre_comercial";
	public static final String COLUMN_ID_TIPO = "pro_id_tipo";
	public static final String COLUMN_DIRECCION = "pro_direccion";
	public static final String COLUMN_COLONIA = "pro_colonia";
	public static final String COLUMN_CIUDAD = "pro_ciudad";
	public static final String COLUMN_ESTADO = "pro_estado";
	public static final String COLUMN_CODIGO_POSTAL = "pro_codigo_postal";
	public static final String COLUMN_TELEFONO = "pro_telefono";
	public static final String COLUMN_TELEFONO1 = "pro_telefono1";
	public static final String COLUMN_CELULAR = "pro_celular";
	public static final String COLUMN_RFC = "pro_rfc";
	public static final String COLUMN_CURP = "pro_curp";
	public static final String COLUMN_EMAIL = "pro_email";
	public static final String COLUMN_FECHA_ALTA = "pro_fecha_alta";
	public static final String COLUMN_ID_ESTATUS = "pro_id_estatus";
	
	public ClProveedorVO()
	{
		
	}

	public ClProveedorVO(ClProveedorVO clProveedorVO) {
		try {
			BeanUtils.copyProperties(this, clProveedorVO);
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}

}
