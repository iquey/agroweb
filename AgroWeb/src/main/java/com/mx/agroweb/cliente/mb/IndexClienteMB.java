package com.mx.agroweb.cliente.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mx.agroweb.cliente.service.ClEmpresaService;
import com.mx.agroweb.cliente.service.ClUsuarioService;
import com.mx.agroweb.cliente.vo.ClEmpresaVO;
import com.mx.agroweb.cliente.vo.ClUsuarioVO;
import com.mx.agroweb.login.beans.NavigationBean;
import com.mx.agroweb.utils.DataSourceUtils;
import com.mx.agroweb.utils.SessionUtils;

@ManagedBean
@RequestScoped
public class IndexClienteMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7475473179644967854L;

	public static final String EMPRESA_SELECCIONADA_FIELD = "empresaSeleccionada";

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	private ClUsuarioService clUsuarioService;
	private ClEmpresaService clEmpresaService;
	private String nombreUsuario;

	private ClEmpresaVO empresaSeleccionada = new ClEmpresaVO();

	List<ClEmpresaVO> empresasList = new ArrayList<ClEmpresaVO>();

	@PostConstruct
	public void init() {
		cargarEmpresas();
	}

	public void cargarEmpresas() {
		String user = null;
		String pass = null;
		if (DataSourceUtils.existDS()) {
			FacesContext context = FacesContext.getCurrentInstance();
			user = (String) context.getExternalContext().getSessionMap().get("user");
			pass = (String) context.getExternalContext().getSessionMap().get("psw");
			ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");
			clUsuarioService = (ClUsuarioService) ctx.getBean("clUsuarioServiceImpl");
			clEmpresaService = (ClEmpresaService) ctx.getBean("clEmpresaServiceImpl");
			// Settear nuevo dataSource
			clUsuarioService.setDinamicDataSource();
			clEmpresaService.setDinamicDataSource();
			ClUsuarioVO clUsuarioVO = clUsuarioService.getUsuario(user, pass);
			empresasList = clEmpresaService.getEmpresasByIdUser(clUsuarioVO.getId());
		}
	}

	public String onRowSelect() {

		SessionUtils.putValue(empresaSeleccionada, EMPRESA_SELECCIONADA_FIELD);
		return navigationBean.redirectToProveedor();
	}

	// GETTERS AND SETTERS

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public ClEmpresaVO getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	public void setEmpresaSeleccionada(ClEmpresaVO empresaSeleccionada) {
		this.empresaSeleccionada = empresaSeleccionada;
	}

	public List<ClEmpresaVO> getEmpresasList() {
		return empresasList;
	}

	public void setEmpresasList(List<ClEmpresaVO> empresasList) {
		this.empresasList = empresasList;
	}

}
