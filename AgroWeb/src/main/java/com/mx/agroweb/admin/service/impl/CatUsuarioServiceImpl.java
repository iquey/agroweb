package com.mx.agroweb.admin.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.agroweb.admin.dao.CatUsuarioDAO;
import com.mx.agroweb.admin.dao.LicenciaDAO;
import com.mx.agroweb.admin.service.CatUsuarioService;
import com.mx.agroweb.admin.vo.CatUsuarioVO;
import com.mx.agroweb.admin.vo.LicenciaVO;
import com.mx.agroweb.utils.DataSourceUtils;
import com.mx.agroweb.utils.DateUtils;

@Service
public class CatUsuarioServiceImpl implements CatUsuarioService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8687193460758861347L;

	@Autowired
	private CatUsuarioDAO catUsuarioDAO;

	@Autowired
	private LicenciaDAO licenciaDAO;

	@Override
	public void insertUsuario(CatUsuarioVO catUsuarioVO) {
		catUsuarioDAO.insertUsuario(catUsuarioVO);
	}

	@Override
	public CatUsuarioVO getUsuario(String username, String password) {

		return catUsuarioDAO.getUsuario(username, password);
	}

	@Override
	public List<CatUsuarioVO> getUsuarios() {
		// TODO Auto-generated method stub
		return catUsuarioDAO.getUsuarios();
	}

	@Override
	public void setDinamicDataSource() {
		DataSource dataSource = DataSourceUtils.getDataSource();
		catUsuarioDAO.setDataSourceDynamic(dataSource);
	}

	@Override
	public boolean isValidateUsuario(CatUsuarioVO catUsuarioVO) {

		// /METODO PARA VALIDAR VIGENCIA ETC
		LicenciaVO licenciaVO = licenciaDAO.getLicenciaById(catUsuarioVO.getIdLicencia());

		// Si existe la licencia validar la vigencia.
		if (licenciaVO != null) {
			// Si esta vigente crear el dataSource
			if (DateUtils.isVigente(licenciaVO.getFechaFin())) {
				DataSourceUtils.createDataSource(licenciaVO);
			
				//Poner en session nombre y pass del usuario
				
				FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().getSessionMap().remove("user");
				context.getExternalContext().getSessionMap().remove("psw");
				context.getExternalContext().getSessionMap().put("user", catUsuarioVO.getUsuario());
				context.getExternalContext().getSessionMap().put("psw", catUsuarioVO.getPassword());
				
				return true;
			}
		}
		return false;
	}
}
