package com.mx.agroweb.utils;

import javax.faces.context.FacesContext;

public class SessionUtils {

	public static void putValue(Object value, String key) {
		FacesContext context = FacesContext.getCurrentInstance();

		removeValue(key);

		context.getExternalContext().getSessionMap().put(key, value);
	}

	public static void removeValue(String key) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove(key);

	}

	public static Object getValue(String key) {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getExternalContext().getSessionMap().get(key);
	}

}
