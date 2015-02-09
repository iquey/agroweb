package com.mx.agroweb.cliente.mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mx.agroweb.cliente.service.ClCatCatalogoService;
import com.mx.agroweb.cliente.utils.ConstantesClienteCatCatalogo;
import com.mx.agroweb.cliente.vo.ClCatalogoVO;
import com.mx.agroweb.cliente.vo.ClProveedorVO;
import com.mx.agroweb.utils.DataSourceUtils;

@ManagedBean
@ViewScoped
public class CatCatalogoMB {

	private ClCatCatalogoService catalogoService;
	private ClCatalogoVO catalogoNuevo = new ClCatalogoVO();;

	@PostConstruct
	public void init() {

		if (DataSourceUtils.existDS()) {

			ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");
			catalogoService = (ClCatCatalogoService) ctx.getBean("clCatCatalogoServiceImpl");
			catalogoService.setDinamicDataSource();
		}

	}

	public void addCatalog() {
		catalogoNuevo.setIdCatalogo(ConstantesClienteCatCatalogo.CATALOGO_UNIDADES);
		catalogoService.createCatalogByCatalog(catalogoNuevo);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado:", "Se Agrego el proveedor "
						+ catalogoNuevo.getNombre() + " satisfactoriamente"));

		catalogoNuevo = new ClCatalogoVO();
	}

}
