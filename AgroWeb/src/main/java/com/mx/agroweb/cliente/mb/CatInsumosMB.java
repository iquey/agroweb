package com.mx.agroweb.cliente.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mx.agroweb.cliente.service.ClCatCatalogoService;
import com.mx.agroweb.cliente.service.ClCentroCostosService;
import com.mx.agroweb.cliente.service.ClGrupoInsumosService;
import com.mx.agroweb.cliente.service.ClInsumosService;
import com.mx.agroweb.cliente.service.ClSubgrupoInsumosService;
import com.mx.agroweb.cliente.utils.ConstantesClienteCatCatalogo;
import com.mx.agroweb.cliente.vo.ClCatalogoVO;
import com.mx.agroweb.cliente.vo.ClCentroCostosVO;
import com.mx.agroweb.cliente.vo.ClGrupoInsumosVO;
import com.mx.agroweb.cliente.vo.ClInsumosAuxVO;
import com.mx.agroweb.cliente.vo.ClInsumosVO;
import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosAuxVO;
import com.mx.agroweb.cliente.vo.ClSubgrupoInsumosVO;
import com.mx.agroweb.utils.DataSourceUtils;

@ManagedBean
@ViewScoped
public class CatInsumosMB {

	private ClSubgrupoInsumosService clSubgrupoInsumosService;
	private ClCatCatalogoService clCatCatalogoService;
	private ClCentroCostosService clCentroCostosService;
	private ClInsumosService clInsumosService;
	private ClGrupoInsumosService clGrupoInsumosService;

	private ClInsumosVO clInsumosSeleccionado;
	private ClInsumosVO clInsumosNuevo = new ClInsumosVO();
	private List<ClInsumosAuxVO> listaInsumos;
	private ClCatalogoVO catalogoNuevoCompra = new ClCatalogoVO();
	private ClCatalogoVO catalogoNuevoVenta = new ClCatalogoVO();
	private ClCentroCostosVO clCentroCostosNuevo = new ClCentroCostosVO();

	private ClSubgrupoInsumosVO clSubgrupoInsumosNuevo = new ClSubgrupoInsumosVO();
	private ClGrupoInsumosVO clGrupoInsumosNuevo = new ClGrupoInsumosVO();

	@PostConstruct
	public void init() {

		if (DataSourceUtils.existDS()) {

			ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");
			clInsumosService = (ClInsumosService) ctx.getBean("clInsumosServiceImpl");

			clSubgrupoInsumosService = (ClSubgrupoInsumosService) ctx.getBean("clSubgrupoInsumosServiceImpl");
			clCatCatalogoService = (ClCatCatalogoService) ctx.getBean("clCatCatalogoServiceImpl");
			clCentroCostosService = (ClCentroCostosService) ctx.getBean("clCentroCostosServiceImpl");
			clGrupoInsumosService = (ClGrupoInsumosService) ctx.getBean("clGrupoInsumosServiceImpl");

			// Settear nuevo dataSource
			clInsumosService.setDinamicDataSource();
			clSubgrupoInsumosService.setDinamicDataSource();
			clCatCatalogoService.setDinamicDataSource();
			clCentroCostosService.setDinamicDataSource();
			clGrupoInsumosService.setDinamicDataSource();

			getInsumos();

		}
	}

	public void getInsumos() {
		listaInsumos = clInsumosService.getInsumos();
	}

	public void delete() {
		clInsumosService.deleteInsumos(clInsumosSeleccionado.getId());
		getInsumos();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado:", "Se elimino el Insumo satisfactoriamente"));
	}

	public void add() {

		if (clInsumosNuevo.getId() == 0) {

			clInsumosService.insertInsumos(clInsumosNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el insumo "
							+ clInsumosNuevo.getDescripcion() + " satisfactoriamente"));

		} else {
			clInsumosService.updateInsumos(clInsumosNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizado:", "Se Actualizo el insumo "
							+ clInsumosNuevo.getDescripcion() + " satisfactoriamente"));
		}
		getInsumos();
		clInsumosNuevo = new ClInsumosVO();
	}

	public void addSubGrupoInsumo() {
		clSubgrupoInsumosService.insertSubgrupoInsumos(clSubgrupoInsumosNuevo);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el sub grupo insumo "
						+ clSubgrupoInsumosNuevo.getDescripcion() + " satisfactoriamente"));

		clInsumosNuevo.setIdSubgrupo(clSubgrupoInsumosService.getId(clSubgrupoInsumosNuevo));
		clSubgrupoInsumosNuevo = new ClSubgrupoInsumosVO();
	}

	public void addGrupoInsumo() {
		clGrupoInsumosService.insertGrupoInsumos(clGrupoInsumosNuevo);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el grupo de insumo"
						+ clGrupoInsumosNuevo.getDescripcion() + " satisfactoriamente"));

		clSubgrupoInsumosNuevo.setIdGrupo(clGrupoInsumosService.getId(clGrupoInsumosNuevo));
		clGrupoInsumosNuevo = new ClGrupoInsumosVO();
	}

	public void addCatalogCompra() {
		catalogoNuevoCompra.setIdCatalogo(ConstantesClienteCatCatalogo.CATALOGO_UNIDADES);
		clCatCatalogoService.createCatalogByCatalog(catalogoNuevoCompra);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el proveedor "
						+ catalogoNuevoCompra.getNombre() + " satisfactoriamente"));

		clInsumosNuevo.setIdUnidadCompra(clCatCatalogoService.getId(catalogoNuevoCompra));
		catalogoNuevoCompra = new ClCatalogoVO();
	}

	public void addCatalogVenta() {
		catalogoNuevoVenta.setIdCatalogo(ConstantesClienteCatCatalogo.CATALOGO_UNIDADES);
		clCatCatalogoService.createCatalogByCatalog(catalogoNuevoVenta);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el proveedor "
						+ catalogoNuevoVenta.getNombre() + " satisfactoriamente"));

		clInsumosNuevo.setIdUnidadSalida(clCatCatalogoService.getId(catalogoNuevoVenta));
		catalogoNuevoVenta = new ClCatalogoVO();
	}

	public void addCentroCostos() {
		clCentroCostosService.insertCentroCostos(clCentroCostosNuevo);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el Centro de Costo "
						+ clCentroCostosNuevo.getDescripcion() + " satisfactoriamente"));

		clInsumosNuevo.setIdCentroCostos(clCentroCostosService.getId(clCentroCostosNuevo));
		clCentroCostosNuevo = new ClCentroCostosVO();
	}

	public void onDialogClose() {
		cancelar();
	}

	public void cancelar() {
		clInsumosNuevo = new ClInsumosVO();
		catalogoNuevoCompra = new ClCatalogoVO();
		clSubgrupoInsumosNuevo = new ClSubgrupoInsumosVO();
		clGrupoInsumosNuevo = new ClGrupoInsumosVO();
		clCentroCostosNuevo = new ClCentroCostosVO();
	}

	public List<ClCatalogoVO> getListaUnidades() {

		if (clCatCatalogoService != null) {
			return clCatCatalogoService.getCatalogoByCatalogo(ConstantesClienteCatCatalogo.CATALOGO_UNIDADES);
		}
		return null;
	}

	public List<ClCentroCostosVO> getListaCentroCostos() {
		if (clCentroCostosService != null) {
			return clCentroCostosService.getCentrosCostos();
		}
		return null;
	}

	public List<ClSubgrupoInsumosAuxVO> getListaSubGrupo() {
		if (clSubgrupoInsumosService != null) {
			return clSubgrupoInsumosService.getSubgrupoInsumos();
		}
		return null;
	}

	public ClInsumosVO getClInsumosSeleccionado() {
		return clInsumosSeleccionado;
	}

	public void setClInsumosSeleccionado(ClInsumosVO clInsumosSeleccionado) {
		this.clInsumosSeleccionado = clInsumosSeleccionado;
	}

	public ClInsumosVO getClInsumosNuevo() {
		return clInsumosNuevo;
	}

	public void setClInsumosNuevo(ClInsumosVO clInsumosNuevo) {
		this.clInsumosNuevo = clInsumosNuevo;
	}

	public List<ClInsumosAuxVO> getListaInsumos() {
		return listaInsumos;
	}

	public void setListaInsumos(List<ClInsumosAuxVO> listaInsumos) {
		this.listaInsumos = listaInsumos;
	}

	public ClSubgrupoInsumosVO getClSubgrupoInsumosNuevo() {
		return clSubgrupoInsumosNuevo;
	}

	public void setClSubgrupoInsumosNuevo(ClSubgrupoInsumosVO clSubgrupoInsumosNuevo) {
		this.clSubgrupoInsumosNuevo = clSubgrupoInsumosNuevo;
	}

	public ClGrupoInsumosVO getClGrupoInsumosNuevo() {
		return clGrupoInsumosNuevo;
	}

	public void setClGrupoInsumosNuevo(ClGrupoInsumosVO clGrupoInsumosNuevo) {
		this.clGrupoInsumosNuevo = clGrupoInsumosNuevo;
	}

	public ClCatalogoVO getCatalogoNuevoCompra() {
		return catalogoNuevoCompra;
	}

	public void setCatalogoNuevoCompra(ClCatalogoVO catalogoNuevoCompra) {
		this.catalogoNuevoCompra = catalogoNuevoCompra;
	}

	public ClCatalogoVO getCatalogoNuevoVenta() {
		return catalogoNuevoVenta;
	}

	public void setCatalogoNuevoVenta(ClCatalogoVO catalogoNuevoVenta) {
		this.catalogoNuevoVenta = catalogoNuevoVenta;
	}

	public ClCentroCostosVO getClCentroCostosNuevo() {
		return clCentroCostosNuevo;
	}

	public void setClCentroCostosNuevo(ClCentroCostosVO clCentroCostosNuevo) {
		this.clCentroCostosNuevo = clCentroCostosNuevo;
	}
}
