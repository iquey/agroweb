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

import com.mx.agroweb.cliente.service.ClGrupoInsumosService;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.utils.DataSourceUtils;

@ManagedBean
@ViewScoped
public class CatGrupoInsumosMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6814646112737305171L;
	private ClGrupoInsumosService clGrupoInsumosService;
	private List<ClGrupoInsumosVO> listaGrupoInsumos;
	private ClGrupoInsumosVO clGrupoInsumosSeleccionado;
	private ClGrupoInsumosVO clGrupoInsumosNuevo = new ClGrupoInsumosVO();

	@PostConstruct
	public void init() {

		if (DataSourceUtils.existDS()) {

			ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");
			clGrupoInsumosService = (ClGrupoInsumosService) ctx.getBean("clGrupoInsumosServiceImpl");

			clGrupoInsumosService.setDinamicDataSource();

			getGrupoInsumos();

		}

	}

	public void getGrupoInsumos() {
		listaGrupoInsumos = clGrupoInsumosService.getGrupoInsumos();
	}

	public void delete() {
		try {
			clGrupoInsumosService.deleteGrupoInsumos(clGrupoInsumosSeleccionado.getId());
			getGrupoInsumos();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado:",
							"Se elimino el centro de costo satisfactoriamente"));
		
		} catch (DataIntegrityViolationException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:",
							"EL GRUPO DE INSUMO ESTA RELACIONADO A UN SUB GRUPO, BORRAR LA DEPENDENCIA PRIMERO"));
		}
		
	}

	public void add() {

		if (clGrupoInsumosNuevo.getId() == 0) {
			clGrupoInsumosService.insertGrupoInsumos(clGrupoInsumosNuevo);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el Centro de Costo "
							+ clGrupoInsumosNuevo.getDescripcion() + " satisfactoriamente"));
		} else {

			clGrupoInsumosService.updateGrupoInsumos(clGrupoInsumosNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion:",
							"La Actualizacion se realizo satisfactoriamente."));

		}
		getGrupoInsumos();
		clGrupoInsumosNuevo = new ClGrupoInsumosVO();
	}

	public void cancelar() {
		clGrupoInsumosNuevo = new ClGrupoInsumosVO();
	}

	public ClGrupoInsumosService getClGrupoInsumosService() {
		return clGrupoInsumosService;
	}

	public void setClGrupoInsumosService(ClGrupoInsumosService clGrupoInsumosService) {
		this.clGrupoInsumosService = clGrupoInsumosService;
	}

	public List<ClGrupoInsumosVO> getListaGrupoInsumos() {
		return listaGrupoInsumos;
	}

	public void setListaGrupoInsumos(List<ClGrupoInsumosVO> listaGrupoInsumos) {
		this.listaGrupoInsumos = listaGrupoInsumos;
	}

	public ClGrupoInsumosVO getClGrupoInsumosSeleccionado() {
		return clGrupoInsumosSeleccionado;
	}

	public void setClGrupoInsumosSeleccionado(ClGrupoInsumosVO clGrupoInsumosSeleccionado) {
		this.clGrupoInsumosSeleccionado = clGrupoInsumosSeleccionado;
	}

	public ClGrupoInsumosVO getClGrupoInsumosNuevo() {
		return clGrupoInsumosNuevo;
	}

	public void setClGrupoInsumosNuevo(ClGrupoInsumosVO clGrupoInsumosNuevo) {
		this.clGrupoInsumosNuevo = clGrupoInsumosNuevo;
	}
}
