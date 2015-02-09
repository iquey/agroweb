package com.mx.agroweb.cliente.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.mx.agroweb.cliente.service.ClCatCatalogoService;
import com.mx.agroweb.cliente.service.ClProveedorService;
import com.mx.agroweb.cliente.utils.ConstantesClienteCatCatalogo;
import com.mx.agroweb.cliente.vo.ClCatalogoVO;
import com.mx.agroweb.cliente.vo.ClEmpresaVO;
import com.mx.agroweb.cliente.vo.ClProveedorAuxVO;
import com.mx.agroweb.cliente.vo.ClProveedorVO;
import com.mx.agroweb.utils.DataSourceUtils;
import com.mx.agroweb.utils.SessionUtils;

@ManagedBean
@ViewScoped
public class CatProveedorMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 590114657877084604L;

	private List<ClProveedorAuxVO> proveedoresList;
	private ClProveedorService clProveedorService;
	private ClCatCatalogoService catalogoService;
	private ClEmpresaVO clEmpresaSeleccionada;
	private ClProveedorVO clProveedorSeleccionado;
	private ClProveedorVO proveedorNuevo = new ClProveedorVO();

	private ClCatalogoVO catalogoNuevoTipoProveedor = new ClCatalogoVO();
	private ClCatalogoVO catalogoNuevoEstatus = new ClCatalogoVO();

	@PostConstruct
	public void init() {

		if (DataSourceUtils.existDS()) {

			clEmpresaSeleccionada = (ClEmpresaVO) SessionUtils.getValue(IndexClienteMB.EMPRESA_SELECCIONADA_FIELD);
			ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");
			clProveedorService = (ClProveedorService) ctx.getBean("clProveedorServiceImpl");
			catalogoService = (ClCatCatalogoService) ctx.getBean("clCatCatalogoServiceImpl");
			// Settear nuevo dataSource
			clProveedorService.setDinamicDataSource();
			catalogoService.setDinamicDataSource();

			// Cargar listas
			proveedoresList = clProveedorService.getProovedores();
		}

	}

	public void getProveedores() {
		proveedoresList = clProveedorService.getProovedores();
	}

	public void delete() {
		try {
			clProveedorService.deleteProovedor(clProveedorSeleccionado.getId());
			getProveedores();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado:",
							"Se elimino el proveedor satisfactoriamente"));

		} catch (DataIntegrityViolationException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:",
							"EL PROVEEDOR NO SE PUEDE ELIMINAR, BORRAR LA REFERENCIA PRIMERO"));
		}
	}

	public void add() {

		if (proveedorNuevo.getId() == 0) {
			clProveedorService.insertProovedor(proveedorNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el proveedor "
							+ proveedorNuevo.getNombre() + " satisfactoriamente"));
		} else {
			clProveedorService.updateProovedor(proveedorNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion:",
							"La Actualizacion se realizo satisfactoriamente."));
		}
		getProveedores();
		proveedorNuevo = new ClProveedorVO();
	}

	public void addCatalogTipoProveedor() {
		catalogoNuevoTipoProveedor.setIdCatalogo(ConstantesClienteCatCatalogo.CATALOGO_TIPO_PROVEEDORES);
		catalogoService.createCatalogByCatalog(catalogoNuevoTipoProveedor);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el tipo de proveedor "
						+ catalogoNuevoTipoProveedor.getNombre() + " satisfactoriamente"));

		proveedorNuevo.setIdTipo(catalogoService.getId(catalogoNuevoTipoProveedor));
		catalogoNuevoTipoProveedor = new ClCatalogoVO();
	}

	public void addCatalogEstatus() {
		catalogoNuevoEstatus.setIdCatalogo(ConstantesClienteCatCatalogo.CATALOGO_TIPO_ESTATUS);
		catalogoService.createCatalogByCatalog(catalogoNuevoEstatus);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego estatus "
						+ catalogoNuevoEstatus.getNombre() + " satisfactoriamente"));

		proveedorNuevo.setIdEstatus(catalogoService.getId(catalogoNuevoEstatus));

		catalogoNuevoEstatus = new ClCatalogoVO();
	}

	public void cancelar() {
		proveedorNuevo = new ClProveedorVO();
		catalogoNuevoTipoProveedor = new ClCatalogoVO();
		catalogoNuevoEstatus = new ClCatalogoVO();
	}

	public List<ClProveedorAuxVO> getProveedoresList() {
		return proveedoresList;
	}

	public void setProveedoresList(List<ClProveedorAuxVO> proveedoresList) {
		this.proveedoresList = proveedoresList;
	}

	public ClProveedorService getClProveedorService() {
		return clProveedorService;
	}

	public void setClProveedorService(ClProveedorService clProveedorService) {
		this.clProveedorService = clProveedorService;
	}

	public ClEmpresaVO getClEmpresaSeleccionada() {
		return clEmpresaSeleccionada;
	}

	public void setClEmpresaSeleccionada(ClEmpresaVO clEmpresaSeleccionada) {
		this.clEmpresaSeleccionada = clEmpresaSeleccionada;
	}

	public ClProveedorVO getClProveedorSeleccionado() {
		return clProveedorSeleccionado;
	}

	public void setClProveedorSeleccionado(ClProveedorVO clProveedorSeleccionado) {
		this.clProveedorSeleccionado = clProveedorSeleccionado;
	}

	public ClProveedorVO getProveedorNuevo() {
		return proveedorNuevo;
	}

	public void setProveedorNuevo(ClProveedorVO proveedorNuevo) {
		this.proveedorNuevo = proveedorNuevo;
	}

	public List<ClCatalogoVO> getListaTipoProveedor() {

		if (catalogoService != null) {
			return catalogoService.getCatalogoByCatalogo(ConstantesClienteCatCatalogo.CATALOGO_TIPO_PROVEEDORES);
		}
		return null;
	}

	public List<ClCatalogoVO> getListaTipoEstatus() {

		if (catalogoService != null) {
			return catalogoService.getCatalogoByCatalogo(ConstantesClienteCatCatalogo.CATALOGO_TIPO_ESTATUS);
		}
		return null;

	}

	public ClCatalogoVO getCatalogoNuevoTipoProveedor() {
		return catalogoNuevoTipoProveedor;
	}

	public void setCatalogoNuevoTipoProveedor(ClCatalogoVO catalogoNuevoTipoProveedor) {
		this.catalogoNuevoTipoProveedor = catalogoNuevoTipoProveedor;
	}

	public ClCatalogoVO getCatalogoNuevoEstatus() {
		return catalogoNuevoEstatus;
	}

	public void setCatalogoNuevoEstatus(ClCatalogoVO catalogoNuevoEstatus) {
		this.catalogoNuevoEstatus = catalogoNuevoEstatus;
	}

}
