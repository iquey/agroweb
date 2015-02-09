package com.mx.agroweb.cliente.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.service.ClGrupoInsumosService;
import com.mx.agroweb.cliente.service.ClSubgrupoInsumosService;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosAuxVO;
import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosVO;
import com.mx.agroweb.utils.DataSourceUtils;

@ManagedBean
@ViewScoped
public class CatSubGrupoInsumosMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3368293700188273438L;
	private ClGrupoInsumosService clGrupoInsumosService;
	private ClSubgrupoInsumosService clSubgrupoInsumosService;

	private ClSubgrupoInsumosVO clSubgrupoInsumosSeleccionado;
	private ClSubgrupoInsumosVO clSubgrupoInsumosNuevo = new ClSubgrupoInsumosVO();
	private ClGrupoInsumosVO clGrupoInsumosNuevo = new ClGrupoInsumosVO();
	private List<ClSubgrupoInsumosAuxVO> subGrupoInsumoslist;

	@PostConstruct
	public void init() {

		if (DataSourceUtils.existDS()) {

			ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");
			clSubgrupoInsumosService = (ClSubgrupoInsumosService) ctx.getBean("clSubgrupoInsumosServiceImpl");
			clGrupoInsumosService = (ClGrupoInsumosService) ctx.getBean("clGrupoInsumosServiceImpl");

			// Settear nuevo dataSource
			clSubgrupoInsumosService.setDinamicDataSource();
			clGrupoInsumosService.setDinamicDataSource();

			// Cargar listas
			getSubGrupo();
		}

	}

	public void getSubGrupo() {
		subGrupoInsumoslist = clSubgrupoInsumosService.getSubgrupoInsumos();
	}

	public void delete() {

		try {
			clSubgrupoInsumosService.deleteSubgrupoInsumos(clSubgrupoInsumosSeleccionado.getId());
			getSubGrupo();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado:",
							"Se elimino el Sub Grupo de insumos satisfactoriamente"));
		} catch (DataIntegrityViolationException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:",
							"EL SUB GRUPO DE INSUMO NO SE PUEDE ELIMINAR, BORRAR LA REFERENCIA PRIMERO"));
		}
	}

	public void add() {

		if (clSubgrupoInsumosNuevo.getId() == 0) {
			clSubgrupoInsumosService.insertSubgrupoInsumos(clSubgrupoInsumosNuevo);
			getSubGrupo();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el sub grupo "
							+ clSubgrupoInsumosNuevo.getDescripcion() + " satisfactoriamente"));

		} else {

			clSubgrupoInsumosService.updateSubgrupoInsumos(clSubgrupoInsumosNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion:",
							"La Actualizacion se realizo satisfactoriamente."));

		}
		clSubgrupoInsumosNuevo = new ClSubgrupoInsumosVO();
	}

	public void addGrupoInsumo() {
		clGrupoInsumosService.insertGrupoInsumos(clGrupoInsumosNuevo);
		getSubGrupo();
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el grupo de insumo"
						+ clGrupoInsumosNuevo.getDescripcion() + " satisfactoriamente"));

		clSubgrupoInsumosNuevo.setIdGrupo(clGrupoInsumosService.getId(clGrupoInsumosNuevo));
		clGrupoInsumosNuevo = new ClGrupoInsumosVO();
	}

	public void cancelar() {
		clSubgrupoInsumosNuevo = new ClSubgrupoInsumosVO();
		clGrupoInsumosNuevo = new ClGrupoInsumosVO();
	}

	public ClGrupoInsumosService getClGrupoInsumosService() {
		return clGrupoInsumosService;
	}

	public void setClGrupoInsumosService(ClGrupoInsumosService clGrupoInsumosService) {
		this.clGrupoInsumosService = clGrupoInsumosService;
	}

	public ClSubgrupoInsumosService getClSubgrupoInsumosService() {
		return clSubgrupoInsumosService;
	}

	public void setClSubgrupoInsumosService(ClSubgrupoInsumosService clSubgrupoInsumosService) {
		this.clSubgrupoInsumosService = clSubgrupoInsumosService;
	}

	public ClSubgrupoInsumosVO getClSubgrupoInsumosSeleccionado() {
		return clSubgrupoInsumosSeleccionado;
	}

	public void setClSubgrupoInsumosSeleccionado(ClSubgrupoInsumosVO clSubgrupoInsumosSeleccionado) {
		this.clSubgrupoInsumosSeleccionado = clSubgrupoInsumosSeleccionado;
	}

	public ClSubgrupoInsumosVO getClSubgrupoInsumosNuevo() {
		return clSubgrupoInsumosNuevo;
	}

	public void setClSubgrupoInsumosNuevo(ClSubgrupoInsumosVO clSubgrupoInsumosNuevo) {
		this.clSubgrupoInsumosNuevo = clSubgrupoInsumosNuevo;
	}

	public List<ClSubgrupoInsumosAuxVO> getSubGrupoInsumoslist() {
		return subGrupoInsumoslist;
	}

	public void setSubGrupoInsumoslist(List<ClSubgrupoInsumosAuxVO> subGrupoInsumoslist) {
		this.subGrupoInsumoslist = subGrupoInsumoslist;
	}

	public ClGrupoInsumosVO getClGrupoInsumosNuevo() {
		return clGrupoInsumosNuevo;
	}

	public void setClGrupoInsumosNuevo(ClGrupoInsumosVO clGrupoInsumosNuevo) {
		this.clGrupoInsumosNuevo = clGrupoInsumosNuevo;
	}

	public List<ClGrupoInsumosVO> getListaGruposInsumos() {

		if (clGrupoInsumosService != null) {
			return clGrupoInsumosService.getGrupoInsumos();
		}
		return null;
	}

}
