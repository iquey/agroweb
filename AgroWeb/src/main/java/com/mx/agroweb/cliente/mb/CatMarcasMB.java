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

import com.mx.agroweb.cliente.service.ClMarcasService;
import com.mx.agroweb.cliente.vo.ClMarcasVO;
import com.mx.agroweb.utils.DataSourceUtils;

@ManagedBean
@ViewScoped
public class CatMarcasMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5287133953088597990L;

	private List<ClMarcasVO> listaMarcas = new ArrayList<ClMarcasVO>();
	private ClMarcasVO clMarcasSeleccionado;
	private ClMarcasVO clMarcasNuevo = new ClMarcasVO();
	private ClMarcasService clMarcasService;

	@PostConstruct
	public void init() {

		if (DataSourceUtils.existDS()) {

			ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");
			clMarcasService = (ClMarcasService) ctx.getBean("clMarcasServiceImpl");
			clMarcasService.setDinamicDataSource();
			getMarcas();

		}

	}

	public void getMarcas() {
		listaMarcas = clMarcasService.getMarcas();
	}

	public void delete() {

		try {
			clMarcasService.deleteMarca(clMarcasSeleccionado.getId());
			getMarcas();
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado:",
									"Se elimino la marca satisfactoriamente"));
		} catch (DataIntegrityViolationException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:",
							"LA MARCA NO SE PUEDE ELIMINAR, BORRAR LA REFERENCIA PRIMERO"));
		}
	}

	public void add() {
		if (clMarcasNuevo.getId() == 0) {
			clMarcasService.insertMarca(clMarcasNuevo);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego la Marca "
							+ clMarcasNuevo.getDescripcion() + " satisfactoriamente"));
		} else {
			clMarcasService.updateMarca(clMarcasNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion:",
							"La Actualizacion se realizo satisfactoriamente."));
		}
		getMarcas();
		clMarcasNuevo = new ClMarcasVO();
	}

	public void cancelar() {
		clMarcasNuevo = new ClMarcasVO();
	}

	public List<ClMarcasVO> getListaMarcas() {
		return listaMarcas;
	}

	public void setListaMarcas(List<ClMarcasVO> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}

	public ClMarcasVO getClMarcasSeleccionado() {
		return clMarcasSeleccionado;
	}

	public void setClMarcasSeleccionado(ClMarcasVO clMarcasSeleccionado) {
		this.clMarcasSeleccionado = clMarcasSeleccionado;
	}

	public ClMarcasVO getClMarcasNuevo() {
		return clMarcasNuevo;
	}

	public void setClMarcasNuevo(ClMarcasVO clMarcasNuevo) {
		this.clMarcasNuevo = clMarcasNuevo;
	}

}
