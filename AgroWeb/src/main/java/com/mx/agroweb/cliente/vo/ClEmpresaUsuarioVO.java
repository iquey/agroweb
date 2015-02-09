package com.mx.agroweb.cliente.vo;

public class ClEmpresaUsuarioVO {

	private int id; // `id` int(11) NOT NULL AUTO_INCREMENT,
	private int idEmpresa; // `id_empresa` int(11) DEFAULT NULL,
	private int idUsuario; // `id_usuario` int(11) DEFAULT NULL,
	
	public static final String COLUMN_ID ="id";
	public static final String COLUMN_ID_EMPRESA ="emp_usu_id_empresa";
	public static final String COLUMN_ID_USUARIO ="emp_usu_id_usuario";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
}
