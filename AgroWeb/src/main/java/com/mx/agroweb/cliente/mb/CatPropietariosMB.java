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

import com.mx.agroweb.cliente.service.ClPropietarioService;
import com.mx.agroweb.cliente.vo.ClPropietarioVO;
import com.mx.agroweb.utils.DataSourceUtils;

@ManagedBean
@ViewScoped
public class CatPropietariosMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1422408424398821612L;

	private List<ClPropietarioVO> listaPropietarios = new ArrayList<ClPropietarioVO>();
	private ClPropietarioVO clPropietariosSeleccionado;
	private ClPropietarioVO clPropietariosNuevo = new ClPropietarioVO();

	private ClPropietarioService clPropietarioService;

	@PostConstruct
	public void init() {

		if (DataSourceUtils.existDS()) {

			ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");
			clPropietarioService = (ClPropietarioService) ctx.getBean("clPropietarioServiceImpl");
			clPropietarioService.setDinamicDataSource();
			getPropietarios();

		}

	}

	public void getPropietarios() {
		listaPropietarios = clPropietarioService.getPropietarios();
	}

	public void delete() {
		try {
			clPropietarioService.deletePropietario(clPropietariosSeleccionado.getId());
			getPropietarios();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado:",
							"Se elimino el Propietario satisfactoriamente"));
		} catch (DataIntegrityViolationException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:",
							"EL PROPIETARIO NO SE PUEDE ELIMINAR, BORRAR LA REFERENCIA PRIMERO"));
		}
	}

	public void add() {
		if (clPropietariosNuevo.getId() == 0) {
			clPropietarioService.insertPropietario(clPropietariosNuevo);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el propietario "
							+ clPropietariosNuevo.getDescripcion() + " satisfactoriamente"));
		} else {
			clPropietarioService.updatePropietario(clPropietariosNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion:",
							"La Actualizacion se realizo satisfactoriamente."));
		}
		getPropietarios();
		clPropietariosNuevo = new ClPropietarioVO();
	}

	public void cancelar() {
		clPropietariosNuevo = new ClPropietarioVO();
	}

	public List<ClPropietarioVO> getListaPropietarios() {
		return listaPropietarios;
	}

	public void setListaPropietarios(List<ClPropietarioVO> listaPropietarios) {
		this.listaPropietarios = listaPropietarios;
	}

	public ClPropietarioVO getClPropietariosSeleccionado() {
		return clPropietariosSeleccionado;
	}

	public void setClPropietariosSeleccionado(ClPropietarioVO clPropietariosSeleccionado) {
		this.clPropietariosSeleccionado = clPropietariosSeleccionado;
	}

	public ClPropietarioVO getClPropietariosNuevo() {
		return clPropietariosNuevo;
	}

	public void setClPropietariosNuevo(ClPropietarioVO clPropietariosNuevo) {
		this.clPropietariosNuevo = clPropietariosNuevo;
	}
}
