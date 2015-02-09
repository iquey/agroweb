package com.mx.agroweb.cliente.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.vo.ClProveedorVO;
import com.mx.agroweb.cliente.vo.ClTipoCambioVO;

public interface ClProveedorDAO {

	public final String QUERY_INSERT = "INSERT INTO CAT_PROVEEDORES(PRO_NOMBRE,PRO_NOMBRE_COMERCIAL,PRO_ID_TIPO,PRO_DIRECCION,PRO_COLONIA,PRO_CIUDAD,PRO_ESTADO,PRO_CODIGO_POSTAL,PRO_TELEFONO,PRO_TELEFONO1,PRO_CELULAR,PRO_RFC,PRO_CURP,PRO_EMAIL,PRO_FECHA_ALTA,PRO_ID_ESTATUS) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public final String QUERY_GET_BY_ID = "SELECT * FROM CAT_PROVEEDORES WHERE BINARY ID = ?";
	public final String QUERY_GET_ALL = "SELECT * FROM CAT_PROVEEDORES";
	public final String QUERY_DELETE_BY_ID = "DELETE FROM CAT_PROVEEDORES WHERE BINARY ID = ?";
	public final String QUERY_UPDATE_BY_ID = "UPDATE CAT_PROVEEDORES	SET	PRO_NOMBRE = ?, PRO_NOMBRE_COMERCIAL = ?, PRO_ID_TIPO = ?, PRO_DIRECCION = ?, PRO_COLONIA = ?, PRO_CIUDAD = ?, PRO_ESTADO = ?, PRO_CODIGO_POSTAL = ?, PRO_TELEFONO = ?, PRO_TELEFONO1 = ?, PRO_CELULAR = ?, PRO_RFC = ?, PRO_CURP = ?, PRO_EMAIL = ?, PRO_FECHA_ALTA = ?, PRO_ID_ESTATUS = ?	WHERE BINARY ID = ?;";
	public final String QUERY_GET_ID = "SELECT ID FROM CAT_PROVEEDORES WHERE BINARY PRO_NOMBRE = ?";

	public void insertProovedor(ClProveedorVO clProovedorVO);

	public ClProveedorVO getProovedor(int id);

	public List<ClProveedorVO> getProovedores();

	public void setDinamicDataSource(DataSource dataSource);

	public void deleteProovedor(int id) throws DataIntegrityViolationException;

	public void updateProovedor(ClProveedorVO clProovedorVO);

	public int getId(ClProveedorVO clProveedorVO);
}
