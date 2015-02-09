package com.mx.agroweb.cliente.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mx.agroweb.cliente.service.ClCatCatalogoService;
import com.mx.agroweb.cliente.service.ClGrupoMaquinariaService;
import com.mx.agroweb.cliente.service.ClMaquinariaService;
import com.mx.agroweb.cliente.service.ClMarcasService;
import com.mx.agroweb.cliente.service.ClPropietarioService;
import com.mx.agroweb.cliente.service.ClProveedorService;
import com.mx.agroweb.cliente.service.ClRanchosService;
import com.mx.agroweb.cliente.service.ClTipoCambioService;
import com.mx.agroweb.cliente.service.ClZonasService;
import com.mx.agroweb.cliente.utils.ConstantesClienteCatCatalogo;
import com.mx.agroweb.cliente.vo.ClCatalogoVO;
import com.mx.agroweb.cliente.vo.ClGrupoMaquinariaVO;
import com.mx.agroweb.cliente.vo.ClMaquinariaAuxVO;
import com.mx.agroweb.cliente.vo.ClMaquinariaVO;
import com.mx.agroweb.cliente.vo.ClMarcasVO;
import com.mx.agroweb.cliente.vo.ClPropietarioVO;
import com.mx.agroweb.cliente.vo.ClProveedorVO;
import com.mx.agroweb.cliente.vo.ClRanchosVO;
import com.mx.agroweb.cliente.vo.ClTipoCambioVO;
import com.mx.agroweb.cliente.vo.ClZonasVO;
import com.mx.agroweb.utils.DataSourceUtils;

@ManagedBean
@ViewScoped
public class CatMaquinariaMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6091653227797685012L;

	private ClMaquinariaService clMaquinariaService;
	private ClGrupoMaquinariaService clGrupoMaquinariaService;
	private ClMarcasService clMarcasService;
	private ClPropietarioService clPropietarioService;
	private ClRanchosService clRanchosService;
	private ClTipoCambioService clTipoCambioService;
	private ClProveedorService clProveedorService;
	private ClCatCatalogoService catalogoService;
	private ClZonasService clZonasService;

	private ClGrupoMaquinariaVO clGrupoMaquinariaNuevo = new ClGrupoMaquinariaVO();
	private ClMarcasVO clMarcasNuevo = new ClMarcasVO();
	private ClPropietarioVO clPropietarioNuevo = new ClPropietarioVO();
	private ClRanchosVO clRanchosNuevo = new ClRanchosVO();
	private ClTipoCambioVO clTipoCambioNuevo = new ClTipoCambioVO();
	private ClProveedorVO clProveedorNuevo = new ClProveedorVO();
	private ClCatalogoVO catalogoNuevoTipoProveedor = new ClCatalogoVO();
	private ClCatalogoVO catalogoNuevoEstatus = new ClCatalogoVO();
	private ClZonasVO clZonasNuevo = new ClZonasVO();

	private List<ClMaquinariaAuxVO> maquinariaList;
	private ClMaquinariaVO clMaquinariaNuevo = new ClMaquinariaVO();
	private ClMaquinariaVO clMaquinariaSeleccionado = new ClMaquinariaVO();

	@PostConstruct
	public void init() {

		if (DataSourceUtils.existDS()) {

			ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");

			clMaquinariaService = (ClMaquinariaService) ctx.getBean("clMaquinariaServiceImpl");
			clGrupoMaquinariaService = (ClGrupoMaquinariaService) ctx.getBean("clGrupoMaquinariaServiceImpl");
			clMarcasService = (ClMarcasService) ctx.getBean("clMarcasServiceImpl");
			clPropietarioService = (ClPropietarioService) ctx.getBean("clPropietarioServiceImpl");
			clRanchosService = (ClRanchosService) ctx.getBean("clRanchosServiceImpl");
			clTipoCambioService = (ClTipoCambioService) ctx.getBean("clTipoCambioServiceImpl");
			clProveedorService = (ClProveedorService) ctx.getBean("clProveedorServiceImpl");
			catalogoService = (ClCatCatalogoService) ctx.getBean("clCatCatalogoServiceImpl");
			clZonasService = (ClZonasService) ctx.getBean("clZonasServiceImpl");

			// Settear nuevo dataSource
			clMaquinariaService.setDinamicDataSource();
			clGrupoMaquinariaService.setDinamicDataSource();
			clMarcasService.setDinamicDataSource();
			clPropietarioService.setDinamicDataSource();
			clRanchosService.setDinamicDataSource();
			clTipoCambioService.setDinamicDataSource();
			clProveedorService.setDinamicDataSource();
			catalogoService.setDinamicDataSource();
			clZonasService.setDinamicDataSource();

			getMaquinaria();

		}
	}

	public void delete() {
		clMaquinariaService.deleteMaquinaria(clMaquinariaSeleccionado.getId());
		getMaquinaria();
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado:",
						"Se elimino la Maquinaria satisfactoriamente"));
	}

	public void getMaquinaria() {
		maquinariaList = clMaquinariaService.getMaquinaria();
	}

	public void add() {

		if (clMaquinariaNuevo.getId() == 0) {

			clMaquinariaService.insertMaquinaria(clMaquinariaNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego la Maquinaria "
							+ clMaquinariaNuevo.getDescripcion() + " satisfactoriamente"));

		} else {
			clMaquinariaService.updateMaquinaria(clMaquinariaNuevo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizado:", "Se Actualizo el insumo "
							+ clMaquinariaNuevo.getDescripcion() + " satisfactoriamente"));
		}
		getMaquinaria();
		clMaquinariaNuevo = new ClMaquinariaVO();
	}

	public void cancelar() {
		clGrupoMaquinariaNuevo = new ClGrupoMaquinariaVO();
		clMarcasNuevo = new ClMarcasVO();
		clPropietarioNuevo = new ClPropietarioVO();
		clRanchosNuevo = new ClRanchosVO();
		clTipoCambioNuevo = new ClTipoCambioVO();
		clProveedorNuevo = new ClProveedorVO();
		catalogoNuevoTipoProveedor = new ClCatalogoVO();
		catalogoNuevoEstatus = new ClCatalogoVO();
		clZonasNuevo = new ClZonasVO();
		clMaquinariaNuevo = new ClMaquinariaVO();
	}

	// AGREGAR CATALOGOS EXTERNOS
	public void addGrupoMaq() {
		clGrupoMaquinariaService.insertGrupoMaquinaria(clGrupoMaquinariaNuevo);

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el grupo de maquinaria "
						+ clGrupoMaquinariaNuevo.getDescripcion() + " satisfactoriamente"));

		clMaquinariaNuevo.setIdGrupo(clGrupoMaquinariaService.getId(clGrupoMaquinariaNuevo));
		clGrupoMaquinariaNuevo = new ClGrupoMaquinariaVO();

	}

	public void addMarcas() {
		clMarcasService.insertMarca(clMarcasNuevo);

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego la Marca "
						+ clMarcasNuevo.getDescripcion() + " satisfactoriamente"));

		clMaquinariaNuevo.setIdMarca(clMarcasService.getId(clMarcasNuevo));
		clMarcasNuevo = new ClMarcasVO();

	}

	public void addPropietario() {
		clPropietarioService.insertPropietario(clPropietarioNuevo);

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el propietario "
						+ clPropietarioNuevo.getDescripcion() + " satisfactoriamente"));

		clMaquinariaNuevo.setIdPropietario(clPropietarioService.getId(clPropietarioNuevo));
		clPropietarioNuevo = new ClPropietarioVO();
	}

	public void addTipoCambio() {
		clTipoCambioService.insertTipoCambio(clTipoCambioNuevo);

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el Tipo de Cambio "
						+ clTipoCambioNuevo.getTipoCambio() + " satisfactoriamente"));

		clMaquinariaNuevo.setIdTipoCambio(clTipoCambioService.getId(clTipoCambioNuevo));
		clTipoCambioNuevo = new ClTipoCambioVO();
	}

	public void addProveedor() {

		clProveedorService.insertProovedor(clProveedorNuevo);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el proveedor "
						+ clProveedorNuevo.getNombre() + " satisfactoriamente"));

		clMaquinariaNuevo.setIdProveedor(clProveedorService.getId(clProveedorNuevo));
		clProveedorNuevo = new ClProveedorVO();
	}

	public void addCatalogTipoProveedor() {
		catalogoNuevoTipoProveedor.setIdCatalogo(ConstantesClienteCatCatalogo.CATALOGO_TIPO_PROVEEDORES);
		catalogoService.createCatalogByCatalog(catalogoNuevoTipoProveedor);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el tipo de proveedor "
						+ catalogoNuevoTipoProveedor.getNombre() + " satisfactoriamente"));

		clProveedorNuevo.setIdTipo(catalogoService.getId(catalogoNuevoTipoProveedor));
		catalogoNuevoTipoProveedor = new ClCatalogoVO();
	}

	public void addCatalogEstatus() {
		catalogoNuevoEstatus.setIdCatalogo(ConstantesClienteCatCatalogo.CATALOGO_TIPO_ESTATUS);
		catalogoService.createCatalogByCatalog(catalogoNuevoEstatus);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego estatus "
						+ catalogoNuevoEstatus.getNombre() + " satisfactoriamente"));

		clProveedorNuevo.setIdEstatus(catalogoService.getId(catalogoNuevoEstatus));
		catalogoNuevoEstatus = new ClCatalogoVO();
	}

	public void addRancho() {

		clRanchosService.insertRancho(clRanchosNuevo);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el Rancho "
						+ clRanchosNuevo.getDescripcion() + " satisfactoriamente"));

		clMaquinariaNuevo.setIdRancho(clRanchosService.getId(clRanchosNuevo));
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

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	// LLENAR LISTA PARA LOS COMBOS
	public List<ClGrupoMaquinariaVO> getGrupoMaquinariaList() {
		if (clGrupoMaquinariaService != null) {
			return clGrupoMaquinariaService.getGrupoMaquinaria();
		}
		return null;
	}

	public List<ClMarcasVO> getMarcasList() {
		if (clMarcasService != null) {
			return clMarcasService.getMarcas();
		}
		return null;
	}

	public List<ClPropietarioVO> getPropietarioList() {
		if (clPropietarioService != null) {
			return clPropietarioService.getPropietarios();
		}
		return null;
	}

	public List<ClRanchosVO> getRanchosList() {
		if (clRanchosService != null) {
			return clRanchosService.getRanchosVO();
		}
		return null;
	}

	public List<ClTipoCambioVO> getTipoCambioList() {
		if (clTipoCambioService != null) {
			return clTipoCambioService.getTiposCambio();
		}
		return null;
	}

	public List<ClProveedorVO> getProveedorList() {
		if (clProveedorService != null) {
			return clProveedorService.getProovedoresVO();
		}
		return null;
	}

	public List<ClZonasVO> getZonasList() {
		if (clZonasService != null) {
			return clZonasService.getZonas();
		}
		return null;
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

	// GETTERS AND SETTER
	public ClGrupoMaquinariaVO getClGrupoMaquinariaNuevo() {
		return clGrupoMaquinariaNuevo;
	}

	public void setClGrupoMaquinariaNuevo(ClGrupoMaquinariaVO clGrupoMaquinariaNuevo) {
		this.clGrupoMaquinariaNuevo = clGrupoMaquinariaNuevo;
	}

	public ClMarcasVO getClMarcasNuevo() {
		return clMarcasNuevo;
	}

	public void setClMarcasNuevo(ClMarcasVO clMarcasNuevo) {
		this.clMarcasNuevo = clMarcasNuevo;
	}

	public ClPropietarioVO getClPropietarioNuevo() {
		return clPropietarioNuevo;
	}

	public void setClPropietarioNuevo(ClPropietarioVO clPropietarioNuevo) {
		this.clPropietarioNuevo = clPropietarioNuevo;
	}

	public ClRanchosVO getClRanchosNuevo() {
		return clRanchosNuevo;
	}

	public void setClRanchosNuevo(ClRanchosVO clRanchosNuevo) {
		this.clRanchosNuevo = clRanchosNuevo;
	}

	public ClTipoCambioVO getClTipoCambioNuevo() {
		return clTipoCambioNuevo;
	}

	public void setClTipoCambioNuevo(ClTipoCambioVO clTipoCambioNuevo) {
		this.clTipoCambioNuevo = clTipoCambioNuevo;
	}

	public ClProveedorVO getClProveedorNuevo() {
		return clProveedorNuevo;
	}

	public void setClProveedorNuevo(ClProveedorVO clProveedorNuevo) {
		this.clProveedorNuevo = clProveedorNuevo;
	}

	public List<ClMaquinariaAuxVO> getMaquinariaList() {
		return maquinariaList;
	}

	public void setMaquinariaList(List<ClMaquinariaAuxVO> maquinariaList) {
		this.maquinariaList = maquinariaList;
	}

	public ClMaquinariaVO getClMaquinariaNuevo() {
		return clMaquinariaNuevo;
	}

	public void setClMaquinariaNuevo(ClMaquinariaVO clMaquinariaNuevo) {
		this.clMaquinariaNuevo = clMaquinariaNuevo;
	}

	public ClMaquinariaVO getClMaquinariaSeleccionado() {
		return clMaquinariaSeleccionado;
	}

	public void setClMaquinariaSeleccionado(ClMaquinariaVO clMaquinariaSeleccionado) {
		this.clMaquinariaSeleccionado = clMaquinariaSeleccionado;
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

	public ClZonasVO getClZonasNuevo() {
		return clZonasNuevo;
	}

	public void setClZonasNuevo(ClZonasVO clZonasNuevo) {
		this.clZonasNuevo = clZonasNuevo;
	}
}
