package com.mx.agroweb.cliente.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.service.ClCentroCostosService;
import com.mx.agroweb.cliente.vo.ClCentroCostosVO;
import com.mx.agroweb.utils.DataSourceUtils;

@ManagedBean
@ViewScoped
public class CatCentroCostosMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -319409641394119815L;
	private ClCentroCostosService clCentroCostosService;
	private List<ClCentroCostosVO> centroCostosList;
	private ClCentroCostosVO clCentroCostosSeleccionado;
	private ClCentroCostosVO clCentroCostosNuevo = new ClCentroCostosVO();

	@PostConstruct
	public void init() {

		if (DataSourceUtils.existDS()) {

			ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");
			clCentroCostosService = (ClCentroCostosService) ctx.getBean("clCentroCostosServiceImpl");

			clCentroCostosService.setDinamicDataSource();

			getCostos();

		}

	}

	public void getCostos() {
		centroCostosList = clCentroCostosService.getCentrosCostos();
	}

	public void delete() {

		try {
			clCentroCostosService.deleteCentroCostos(clCentroCostosSeleccionado.getId());
			getCostos();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado:",
							"Se elimino el centro de costo satisfactoriamente"));
		} catch (DataIntegrityViolationException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:",
							"EL CENTRO DE COSTO NO SE PUEDE ELIMINAR, BORRAR LA REFERENCIA PRIMERO"));
		}

	}

	public void add() {
		if (clCentroCostosNuevo.getId() == 0) {
			clCentroCostosService.insertCentroCostos(clCentroCostosNuevo);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el Centro de Costo "
							+ clCentroCostosNuevo.getDescripcion() + " satisfactoriamente"));
		} else {
			clCentroCostosService.updateCentroCostos(clCentroCostosNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion:",
							"La Actualizacion se realizo satisfactoriamente."));
		}
		getCostos();
		clCentroCostosNuevo = new ClCentroCostosVO();
	}

	public void cancelar() {
		clCentroCostosNuevo = new ClCentroCostosVO();
	}

	public ClCentroCostosService getClCentroCostosService() {
		return clCentroCostosService;
	}

	public void setClCentroCostosService(ClCentroCostosService clCentroCostosService) {
		this.clCentroCostosService = clCentroCostosService;
	}

	public List<ClCentroCostosVO> getCentroCostosList() {
		return centroCostosList;
	}

	public void setCentroCostosList(List<ClCentroCostosVO> centroCostosList) {
		this.centroCostosList = centroCostosList;
	}

	public ClCentroCostosVO getClCentroCostosSeleccionado() {
		return clCentroCostosSeleccionado;
	}

	public void setClCentroCostosSeleccionado(ClCentroCostosVO clCentroCostosSeleccionado) {
		this.clCentroCostosSeleccionado = clCentroCostosSeleccionado;
	}

	public ClCentroCostosVO getClCentroCostosNuevo() {
		return clCentroCostosNuevo;
	}

	public void setClCentroCostosNuevo(ClCentroCostosVO clCentroCostosNuevo) {
		this.clCentroCostosNuevo = clCentroCostosNuevo;
	}

}
