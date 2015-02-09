package com.mx.agroweb.login.beans;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mx.agroweb.admin.service.CatUsuarioService;
import com.mx.agroweb.admin.vo.CatUsuarioVO;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 7765876811740798583L;
	private String username = "usuario";
	private String password = "123";
	private boolean loggedIn;

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	private CatUsuarioService catUsuarioService;

	public String doLogin() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");
		catUsuarioService = (CatUsuarioService) ctx.getBean("catUsuarioServiceImpl");

		CatUsuarioVO catUsuarioVO = catUsuarioService.getUsuario(username, password);

		// Si existe el usuario validar la vigencia
		if (catUsuarioVO != null) {

			// Si es vigente loggear
			if (catUsuarioService.isValidateUsuario(catUsuarioVO)) {

				loggedIn = true;
				return navigationBean.redirectToIndexCliente();

			} else {
				// Set login ERROR
				mostrarMensaje("Login error: La Vigencia esta vencida!");
			}

		} else {
			// Set login ERROR
			mostrarMensaje("Login error: El Usuario no existe!");
		}

		// To to login page
		return navigationBean.toLogin();

	}

	public String doLogout() {
		// Set the paremeter indicating that user is logged in to false
		loggedIn = false;

		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("dataSourceCustom");
		context.getExternalContext().getSessionMap().remove("user");
		context.getExternalContext().getSessionMap().remove("psw");

		return navigationBean.toLogin();
	}

	public void mostrarMensaje(String msgError) {
		// Set logout message
		FacesMessage msg = new FacesMessage(msgError, "INFO MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	// ------------------------------
	// Getters & Setters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

}
