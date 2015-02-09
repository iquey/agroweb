package com.mx.agroweb.login.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Simple navigation bean
 * 
 * @author itcuties
 * 
 */
@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {

	private static final long serialVersionUID = 1520318172495977648L;

	/**
	 * Redirect to login page.
	 * 
	 * @return Login page name.
	 */
	public String redirectToLogin() {
		return "/login.xhtml?faces-redirect=true";
	}

	/**
	 * Go to login page.
	 * 
	 * @return Login page name.
	 */
	public String toLogin() {
		return "/login.xhtml";
	}

	/**
	 * Redirect to info page.
	 * 
	 * @return Info page name.
	 */
	public String redirectToInfo() {
		return "/info.xhtml?faces-redirect=true";
	}

	/**
	 * Go to info page.
	 * 
	 * @return Info page name.
	 */
	public String toInfo() {
		return "/info.xhtml";
	}

	/**
	 * Redirect to welcome page.
	 * 
	 * @return Welcome page name.
	 */
	public String redirectToWelcome() {
		return "/secured/welcome.xhtml?faces-redirect=true";
	}

	/**
	 * Go to welcome page.
	 * 
	 * @return Welcome page name.
	 */
	public String toWelcome() {
		return "/secured/welcome.xhtml";
	}

	/**
	 * Redirect to welcome page.
	 * 
	 * @return Welcome page name.
	 */
	public String redirectToIndexCliente() {
		return "/secured/clientes/indexCliente.xhtml?faces-redirect=true";
		// return
		// "/secured/clientes/pruebaUsoTemplate.xhtml?faces-redirect=true";
	}

	/**
	 * Redirect to proveedor page.
	 * 
	 * @return Welcome page name.
	 */
	public String redirectToProveedor() {
		return "/secured/clientes/catProveedor.xhtml?faces-redirect=true";
	}
	
	/**
	 * Redirect to proveedor page.
	 * 
	 * @return Welcome page name.
	 */
	public String redirectToCCostos() {
		return "/secured/clientes/catCentroCostos.xhtml?faces-redirect=true";
	}
	
	/**
	 * Redirect to proveedor page.
	 * 
	 * @return Welcome page name.
	 */
	public String redirectToGInsumos() {
		return "/secured/clientes/catGrupoInsumos.xhtml?faces-redirect=true";
	}
	
	/**
	 * Redirect to proveedor page.
	 * 
	 * @return Welcome page name.
	 */
	public String redirectTosubGInsumos() {
		return "/secured/clientes/catSubGrupoInsumo.xhtml?faces-redirect=true";
	}
	
	/**
	 * Redirect to proveedor page.
	 * 
	 * @return Welcome page name.
	 */
	public String redirectToInsumos() {
		return "/secured/clientes/catInsumos.xhtml?faces-redirect=true";
	}


	/**
	 * Go to welcome page.
	 * 
	 * @return Welcome page name.
	 */
	public String toIndexCliente() {
		return "/secured/clientes/indexCliente.xhtml";
	}

}
