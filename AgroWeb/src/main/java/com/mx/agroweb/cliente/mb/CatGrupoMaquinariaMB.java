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
import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.service.ClGrupoMaquinariaService;
import com.mx.agroweb.cliente.vo.ClGrupoMaquinariaVO;
import com.mx.agroweb.utils.DataSourceUtils;

@ManagedBean
@ViewScoped
public class CatGrupoMaquinariaMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4104945149425405884L;

	private List<ClGrupoMaquinariaVO> listaMaquinaria = new ArrayList<ClGrupoMaquinariaVO>();
	private ClGrupoMaquinariaVO clGrupoMaquinariaSeleccionado;
	private ClGrupoMaquinariaVO clGrupoMaquinariaNuevo = new ClGrupoMaquinariaVO();

	private ClGrupoMaquinariaService clGrupoMaquinariaService;

	@PostConstruct
	public void init() {

		if (DataSourceUtils.existDS()) {

			ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");
			clGrupoMaquinariaService = (ClGrupoMaquinariaService) ctx.getBean("clGrupoMaquinariaServiceImpl");
			clGrupoMaquinariaService.setDinamicDataSource();
			getPropietarios();

		}

	}

	public void getPropietarios() {
		listaMaquinaria = clGrupoMaquinariaService.getGrupoMaquinaria();
	}

	public void delete() {

		try {
			clGrupoMaquinariaService.deleteGrupoMaquinaria(clGrupoMaquinariaSeleccionado.getId());
			getPropietarios();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado:",
							"Se elimino el Grupo de Maquinaria satisfactoriamente"));
		} catch (DataIntegrityViolationException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:",
							"EL GRUPO DE MAQUINARIA NO SE PUEDE ELIMINAR, BORRAR LA REFERENCIA PRIMERO"));
		}
	}

	public void add() {
		if (clGrupoMaquinariaNuevo.getId() == 0) {
			clGrupoMaquinariaService.insertGrupoMaquinaria(clGrupoMaquinariaNuevo);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el grupo de maquinaria "
							+ clGrupoMaquinariaNuevo.getDescripcion() + " satisfactoriamente"));
		} else {
			clGrupoMaquinariaService.updateGrupoMaquinaria(clGrupoMaquinariaNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion:",
							"La Actualizacion se realizo satisfactoriamente."));
		}
		getPropietarios();
		clGrupoMaquinariaNuevo = new ClGrupoMaquinariaVO();
	}

	public void cancelar() {
		clGrupoMaquinariaNuevo = new ClGrupoMaquinariaVO();
	}

	public List<ClGrupoMaquinariaVO> getListaMaquinaria() {
		return listaMaquinaria;
	}

	public void setListaMaquinaria(List<ClGrupoMaquinariaVO> listaMaquinaria) {
		this.listaMaquinaria = listaMaquinaria;
	}

	public ClGrupoMaquinariaVO getClGrupoMaquinariaSeleccionado() {
		return clGrupoMaquinariaSeleccionado;
	}

	public void setClGrupoMaquinariaSeleccionado(ClGrupoMaquinariaVO clGrupoMaquinariaSeleccionado) {
		this.clGrupoMaquinariaSeleccionado = clGrupoMaquinariaSeleccionado;
	}

	public ClGrupoMaquinariaVO getClGrupoMaquinariaNuevo() {
		return clGrupoMaquinariaNuevo;
	}

	public void setClGrupoMaquinariaNuevo(ClGrupoMaquinariaVO clGrupoMaquinariaNuevo) {
		this.clGrupoMaquinariaNuevo = clGrupoMaquinariaNuevo;
	}
}
