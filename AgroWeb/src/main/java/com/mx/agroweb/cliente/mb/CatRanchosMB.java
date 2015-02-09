package com.mx.agroweb.cliente.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mx.agroweb.cliente.service.ClRanchosService;
import com.mx.agroweb.cliente.service.ClZonasService;
import com.mx.agroweb.cliente.vo.ClRanchosAuxVO;
import com.mx.agroweb.cliente.vo.ClRanchosVO;
import com.mx.agroweb.cliente.vo.ClZonasVO;
import com.mx.agroweb.utils.DataSourceUtils;

@ManagedBean
@ViewScoped
public class CatRanchosMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3682318615788624384L;

	private List<ClRanchosAuxVO> listaRanchos = new ArrayList<ClRanchosAuxVO>();
	private ClRanchosVO clRanchosSeleccionado;
	private ClRanchosVO clRanchosNuevo = new ClRanchosVO();

	private ClZonasVO clZonasNuevo = new ClZonasVO();

	private ClZonasService clZonasService;
	private ClRanchosService clRanchosService;

	@PostConstruct
	public void init() {

		if (DataSourceUtils.existDS()) {

			ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");
			clRanchosService = (ClRanchosService) ctx.getBean("clRanchosServiceImpl");
			clZonasService = (ClZonasService) ctx.getBean("clZonasServiceImpl");

			// Settear nuevo dataSource
			clRanchosService.setDinamicDataSource();
			clZonasService.setDinamicDataSource();

			// Cargar listas
			getRanchos();
		}

	}

	public void getRanchos() {
		listaRanchos = clRanchosService.getRanchos();
	}

	public void delete() {
		clRanchosService.deleteRancho(clRanchosSeleccionado.getId());
		getRanchos();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado:", "Se elimino el Rancho satisfactoriamente"));
	}

	public void add() {

		if (clRanchosNuevo.getId() == 0) {
			clRanchosService.insertRancho(clRanchosNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el Rancho "
							+ clRanchosNuevo.getDescripcion() + " satisfactoriamente"));

		} else {

			clRanchosService.updateRancho(clRanchosNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion:",
							"La Actualizacion se realizo satisfactoriamente."));

		}
		getRanchos();
		clRanchosNuevo = new ClRanchosVO();
	}

	public void addZona() {
		clZonasService.insertZona(clZonasNuevo);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego la zona de insumo"
						+ clZonasNuevo.getDescripcion() + " satisfactoriamente"));

		clRanchosNuevo.setIdZona(clZonasService.getId(clZonasNuevo));
		clZonasNuevo = new ClZonasVO();
	}

	public void cancelar() {
		clRanchosNuevo = new ClRanchosVO();
		clZonasNuevo = new ClZonasVO();
	}

	public List<ClZonasVO> getListaZonas() {

		if (clZonasService != null) {
			return clZonasService.getZonas();
		}
		return null;
	}

	public List<ClRanchosAuxVO> getListaRanchos() {
		return listaRanchos;
	}

	public void setListaRanchos(List<ClRanchosAuxVO> listaRanchos) {
		this.listaRanchos = listaRanchos;
	}

	public ClRanchosVO getClRanchosSeleccionado() {
		return clRanchosSeleccionado;
	}

	public void setClRanchosSeleccionado(ClRanchosVO clRanchosSeleccionado) {
		this.clRanchosSeleccionado = clRanchosSeleccionado;
	}

	public ClRanchosVO getClRanchosNuevo() {
		return clRanchosNuevo;
	}

	public void setClRanchosNuevo(ClRanchosVO clRanchosNuevo) {
		this.clRanchosNuevo = clRanchosNuevo;
	}

	public ClZonasVO getClZonasNuevo() {
		return clZonasNuevo;
	}

	public void setClZonasNuevo(ClZonasVO clZonasNuevo) {
		this.clZonasNuevo = clZonasNuevo;
	}

}
