package com.mx.agroweb.admin.vo;

public class LicenciaVO {

	private int id;
	private int idCliente;
	private String nombreBase;
	private String direccionMac;
	private String usuario;
	private String contrasena;
	private String fechaInicio;
	private String fechaFin;
	private int idTipoLicencia;

	// Constantes para la tabla "Licencias" en "Administrador_agroweb"
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_ID_CLIENTE = "lic_id_cliente";
	public static final String COLUMN_NOMBRE_BASE = "lic_nombre_base";
	public static final String COLUMN_DIRECCION_MAC = "lic_direccion_mac";
	public static final String COLUMN_USUARIO = "lic_usuario";
	public static final String COLUMN_CONTRASENA = "lic_password";
	public static final String COLUMN_FECHA_INICIO = "lic_fecha_inicio";
	public static final String COLUMN_FECHA_FIN = "lic_fecha_fin";
	public static final String COLUMN_ID_TIPO_LICENCIA = "lic_id_tipo_licencia";

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente
	 *            the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * @return the nombreBase
	 */
	public String getNombreBase() {
		return nombreBase;
	}

	/**
	 * @param nombreBase
	 *            the nombreBase to set
	 */
	public void setNombreBase(String nombreBase) {
		this.nombreBase = nombreBase;
	}

	/**
	 * @return the direccionMac
	 */
	public String getDireccionMac() {
		return direccionMac;
	}

	/**
	 * @param direccionMac
	 *            the direccionMac to set
	 */
	public void setDireccionMac(String direccionMac) {
		this.direccionMac = direccionMac;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * @param contrasena
	 *            the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio
	 *            the fechaInicio to set
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin
	 *            the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the idTipo
	 */
	public int getIdTipoLicencia() {
		return idTipoLicencia;
	}

	/**
	 * @param idTipo
	 *            the idTipo to set
	 */
	public void setIdTipoLicencia(int idTipoLicencia) {
		this.idTipoLicencia = idTipoLicencia;
	}
}
