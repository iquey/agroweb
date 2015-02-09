package com.mx.agroweb.cliente.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class ClInsumosVO {

	private int id;
	private int idSubgrupo;
	private String descripcion;
	private int idUnidadCompra;
	private String costoCompra;
	private int idUnidadSalida;
	private String costoSalida;
	private String porcentajeSalida;
	private int idCentroCostos;
	private String factorConversion;
	private String cuentaContable;

	public static final String COLUMN_ID = "id";
	public static final String COLUMN_ID_SUBGRUPO = "ins_id_subgrupo";
	public static final String COLUMN_DESCRIPCION = "ins_descripcion";
	public static final String COLUMN_ID_UNIDAD_COMPRA = "ins_id_unidad_compra";
	public static final String COLUMN_COSTO_COMPRA = "ins_costo_compra";
	public static final String COLUMN_ID_UNIDAD_SALIDA = "ins_id_unidad_salida";
	public static final String COLUMN_COSTO_SALIDA = "ins_costo_salida";
	public static final String COLUMN_PORCENTAJE_SALIDA = "ins_porcentaje_salida";
	public static final String COLUMN_ID_CENTRO_COSTOS = "ins_id_centro_costos";
	public static final String COLUMN_FACTOR_CONVERSION = "ins_factor_conversion";
	public static final String COLUMN_CUENTA_CONTABLE = "ins_cuenta_contable";

	public ClInsumosVO() {

	}

	public ClInsumosVO(ClInsumosVO clInsumosVO) {
		try {
			BeanUtils.copyProperties(this, clInsumosVO);
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

	public int getIdSubgrupo() {
		return idSubgrupo;
	}

	public void setIdSubgrupo(int idSubgrupo) {
		this.idSubgrupo = idSubgrupo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdUnidadCompra() {
		return idUnidadCompra;
	}

	public void setIdUnidadCompra(int idUnidadCompra) {
		this.idUnidadCompra = idUnidadCompra;
	}

	public String getCostoCompra() {
		return costoCompra;
	}

	public void setCostoCompra(String costoCompra) {
		this.costoCompra = costoCompra;
	}

	public int getIdUnidadSalida() {
		return idUnidadSalida;
	}

	public void setIdUnidadSalida(int idUnidadSalida) {
		this.idUnidadSalida = idUnidadSalida;
	}

	public String getCostoSalida() {
		return costoSalida;
	}

	public void setCostoSalida(String costoSalida) {
		this.costoSalida = costoSalida;
	}

	public String getPorcentajeSalida() {
		return porcentajeSalida;
	}

	public void setPorcentajeSalida(String porcentajeSalida) {
		this.porcentajeSalida = porcentajeSalida;
	}

	public int getIdCentroCostos() {
		return idCentroCostos;
	}

	public void setIdCentroCostos(int idCentroCostos) {
		this.idCentroCostos = idCentroCostos;
	}

	public String getFactorConversion() {
		return factorConversion;
	}

	public void setFactorConversion(String factorConversion) {
		this.factorConversion = factorConversion;
	}

	public String getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(String cuentaContable) {
		this.cuentaContable = cuentaContable;
	}
}
