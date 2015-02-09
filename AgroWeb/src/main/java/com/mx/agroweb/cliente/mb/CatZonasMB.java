package com.mx.agroweb.cliente.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.service.ClZonasService;
import com.mx.agroweb.cliente.vo.ClZonasVO;
import com.mx.agroweb.utils.DataSourceUtils;

@ManagedBean
@ViewScoped
public class CatZonasMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6134828945515602322L;

	private List<ClZonasVO> listaClZonas = new ArrayList<ClZonasVO>();
	private ClZonasVO clZonasSeleccionado;
	private ClZonasVO clZonasNuevo = new ClZonasVO();
	private ClZonasService clZonasService;

	@PostConstruct
	public void init() {

		if (DataSourceUtils.existDS()) {

			ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");
			clZonasService = (ClZonasService) ctx.getBean("clZonasServiceImpl");
			clZonasService.setDinamicDataSource();
			getZonas();

		}

	}

	public void getZonas() {
		listaClZonas = clZonasService.getZonas();
	}

	public void delete() {

		try {
			clZonasService.deleteZona(clZonasSeleccionado.getId());
			getZonas();
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado:",
									"Se elimino la zona satisfactoriamente"));
		} catch (DataIntegrityViolationException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:",
							"LA ZONA NO SE PUEDE ELIMINAR, BORRAR LA REFERENCIA PRIMERO"));
		}
	}

	public void add() {
		if (clZonasNuevo.getId() == 0) {
			clZonasService.insertZona(clZonasNuevo);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego la Zona "
							+ clZonasNuevo.getDescripcion() + " satisfactoriamente"));
		} else {
			clZonasService.updateZona(clZonasNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion:",
							"La Actualizacion se realizo satisfactoriamente."));
		}
		getZonas();
		clZonasNuevo = new ClZonasVO();
	}

	public void cancelar() {
		clZonasNuevo = new ClZonasVO();
	}

	public List<ClZonasVO> getListaClZonas() {
		return listaClZonas;
	}

	public void setListaClZonas(List<ClZonasVO> listaClZonas) {
		this.listaClZonas = listaClZonas;
	}

	public ClZonasVO getClZonasSeleccionado() {
		return clZonasSeleccionado;
	}

	public void setClZonasSeleccionado(ClZonasVO clZonasSeleccionado) {
		this.clZonasSeleccionado = clZonasSeleccionado;
	}

	public ClZonasVO getClZonasNuevo() {
		return clZonasNuevo;
	}

	public void setClZonasNuevo(ClZonasVO clZonasNuevo) {
		this.clZonasNuevo = clZonasNuevo;
	}

}
