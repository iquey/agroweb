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

import com.mx.agroweb.cliente.service.ClTipoCambioService;
import com.mx.agroweb.cliente.vo.ClTipoCambioVO;
import com.mx.agroweb.utils.DataSourceUtils;

@ManagedBean
@ViewScoped
public class CatTipoCambioMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -635075739341564266L;

	private List<ClTipoCambioVO> listaTipoCambio = new ArrayList<ClTipoCambioVO>();
	private ClTipoCambioVO clTipoCambioSeleccionado;
	private ClTipoCambioVO clTipoCambioNuevo = new ClTipoCambioVO();

	private ClTipoCambioService clTipoCambioService;

	@PostConstruct
	public void init() {

		if (DataSourceUtils.existDS()) {

			ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");
			clTipoCambioService = (ClTipoCambioService) ctx.getBean("clTipoCambioServiceImpl");
			clTipoCambioService.setDinamicDataSource();
			getPropietarios();

		}

	}

	public void getPropietarios() {
		listaTipoCambio = clTipoCambioService.getTiposCambio();
	}

	public void delete() {
		clTipoCambioService.deleteTipoCambio(clTipoCambioSeleccionado.getId());
		getPropietarios();
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado:",
						"Se elimino el Tipo de Cambio satisfactoriamente"));
	}

	public void add() {
		if (clTipoCambioNuevo.getId() == 0) {
			clTipoCambioService.insertTipoCambio(clTipoCambioNuevo);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el Tipo de Cambio "
							+ clTipoCambioNuevo.getTipoCambio() + " satisfactoriamente"));
		} else {
			clTipoCambioService.updateTipoCambio(clTipoCambioNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion:",
							"La Actualizacion se realizo satisfactoriamente."));
		}
		getPropietarios();
		clTipoCambioNuevo = new ClTipoCambioVO();
	}

	public void cancelar() {
		clTipoCambioNuevo = new ClTipoCambioVO();
	}

	public List<ClTipoCambioVO> getListaTipoCambio() {
		return listaTipoCambio;
	}

	public void setListaTipoCambio(List<ClTipoCambioVO> listaTipoCambio) {
		this.listaTipoCambio = listaTipoCambio;
	}

	public ClTipoCambioVO getClTipoCambioSeleccionado() {
		return clTipoCambioSeleccionado;
	}

	public void setClTipoCambioSeleccionado(ClTipoCambioVO clTipoCambioSeleccionado) {
		this.clTipoCambioSeleccionado = clTipoCambioSeleccionado;
	}

	public ClTipoCambioVO getClTipoCambioNuevo() {
		return clTipoCambioNuevo;
	}

	public void setClTipoCambioNuevo(ClTipoCambioVO clTipoCambioNuevo) {
		this.clTipoCambioNuevo = clTipoCambioNuevo;
	}
}
