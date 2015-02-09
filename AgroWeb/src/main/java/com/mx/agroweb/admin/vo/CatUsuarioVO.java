package com.mx.agroweb.admin.vo;

public class CatUsuarioVO {

	private int id;
	private String usuario;
	private String password;
	private String fechaAlta;
	private int idEstatus;
	private int idLicencia;
	
	public static final String COLUMN_ID ="id";
	public static final String COLUMN_USUARIO ="usu_usuario";
	public static final String COLUMN_PASSWORD ="usu_password";
	public static final String COLUMN_FECHA_ALTA ="usu_fecha_alta";
	public static final String COLUMN_ID_ESTATUS ="usu_id_estatus";
	public static final String COLUMN_ID_LICENCIA ="usu_id_licencia";
	

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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the fechaAlta
	 */
	public String getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta
	 *            the fechaAlta to set
	 */
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * @return the idEstatus
	 */
	public int getIdEstatus() {
		return idEstatus;
	}

	/**
	 * @param idEstatus
	 *            the idEstatus to set
	 */
	public void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}

	/**
	 * @return the idLicencia
	 */
	public int getIdLicencia() {
		return idLicencia;
	}

	/**
	 * @param idLicencia
	 *            the idLicencia to set
	 */
	public void setIdLicencia(int idLicencia) {
		this.idLicencia = idLicencia;
	}

}
