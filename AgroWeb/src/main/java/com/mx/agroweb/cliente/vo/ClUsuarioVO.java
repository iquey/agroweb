package com.mx.agroweb.cliente.vo;

public class ClUsuarioVO {
	
	private int id;
	private String usuario;
	private String password;
	private String fechaAlta;
	private int idEstatus;
	
	public static final String COLUMN_ID ="id";
	public static final String COLUMN_USUARIO ="usu_usuario";
	public static final String COLUMN_PASSWORD ="usu_password";
	public static final String COLUMN_FECHA_ALTA ="usu_fecha_alta";
	public static final String COLUMN_ID_ESTATUS ="usu_id_estatus";
	

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

}
