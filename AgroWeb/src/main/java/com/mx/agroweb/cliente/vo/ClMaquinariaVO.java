package com.mx.agroweb.cliente.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class ClMaquinariaVO {

	private int id;
	private int idGrupo;
	private String codigo;
	private String descripcion;
	private String anio;
	private int idMarca;
	private String modelo;
	private String numSerie;
	private int idPropietario;
	private String numTransmision;
	private String numSerieMotor;
	private String capacidadMotor;
	private String fechaCompra;
	private int idRancho;
	private byte[] foto;
	private String costoHora1;
	private String costoHora2;
	private String costoHora3;
	private String costoHora4;
	private String horometroCompra;
	private String horometroInicial;
	private int idTipoCambio;
	private String pedimientoImportacion;
	private int idProveedor;
	private String observaciones;
	private String fechaVenta;
	private String comprador;
	private String precioVenta;
	private String precioCompraPesos;
	private String precioCompraDlls;
	private String fleteAmericanoPesos;
	private String fleteAmericanoDlls;
	private String costoBrokerPesos;
	private String costoBrokerDlls;
	private String aduanalesPesos;
	private String aduanalesDlls;
	private String impuestosMexicanosPesos;
	private String impuestosMexicanosDlls;
	private String fleteMexicanoPesos;
	private String fleteMexicanoDlls;
	private String seguroPesos;
	private String seguroDlls;
	private String otrosGastosPesos;
	private String otrosGastosDlls;

	public static final String COLUMN_ID = "id";
	public static final String COLUMN_ID_GRUPO = "maq_id_grupo";
	public static final String COLUMN_CODIGO = "maq_codigo";
	public static final String COLUMN_DESCRIPCION = "maq_descripcion";
	public static final String COLUMN_ID_MARCA = "maq_id_marca";
	public static final String COLUMN_ANIO = "maq_anio";
	public static final String COLUMN_MODELO = "maq_modelo";
	public static final String COLUMN_ID_PROPIETARIO = "maq_id_propietario";
	public static final String COLUMN_NUM_SERIE = "maq_num_serie";
	public static final String COLUMN_NUM_TRANSMISION = "maq_num_transmision";
	public static final String COLUMN_NUM_SERIE_MOTOR = "maq_num_serie_motor";
	public static final String COLUMN_CAPACIDAD_MOTOR = "maq_capacidad_motor";
	public static final String COLUMN_FECHA_COMPRA = "maq_fecha_compra";
	public static final String COLUMN_ID_RANCHO = "maq_id_rancho";
	public static final String COLUMN_FOTO = "maq_foto";
	public static final String COLUMN_COSTO_HORA1 = "maq_costo_hora1";
	public static final String COLUMN_COSTO_HORA2 = "maq_costo_hora2";
	public static final String COLUMN_COSTO_HORA3 = "maq_costo_hora3";
	public static final String COLUMN_COSTO_HORA4 = "maq_costo_hora4";
	public static final String COLUMN_HOROMETRO_COMPRA = "maq_horometro_compra";
	public static final String COLUMN_HOROMETRO_INICIAL = "maq_horometro_inicial";
	public static final String COLUMN_ID_TIPO_CAMBIO = "maq_id_tipo_cambio";
	public static final String COLUMN_PEDIMIENTO_IMPORTACION = "maq_pedimiento_importacion";
	public static final String COLUMN_ID_PROVEEDOR = "maq_id_proveedor";
	public static final String COLUMN_OBSERVACIONES = "maq_observaciones";
	public static final String COLUMN_FECHA_VENTA = "maq_fecha_venta";
	public static final String COLUMN_COMPRADOR = "maq_comprador";
	public static final String COLUMN_PRECIO_VENTA = "maq_precio_venta";
	public static final String COLUMN_PRECIO_COMPRA_PESOS = "maq_precio_compra_pesos";
	public static final String COLUMN_PRECIO_COMPRA_DLLS = "maq_precio_compra_dlls";
	public static final String COLUMN_FLETE_AMERICANO_PESOS = "maq_flete_americano_pesos";
	public static final String COLUMN_FLETE_AMERICANO_DLLS = "maq_flete_americano_dlls";
	public static final String COLUMN_COSTO_BROKER_PESOS = "maq_costo_broker_pesos";
	public static final String COLUMN_COSTO_BROKER_DLLS = "maq_costo_broker_dlls";
	public static final String COLUMN_ADUANALES_PESOS = "maq_aduanales_pesos";
	public static final String COLUMN_ADUANALES_DLLS = "maq_aduanales_dlls";
	public static final String COLUMN_IMPUESTOS_MEXICANOS_PESOS = "maq_impuestos_mexicanos_pesos";
	public static final String COLUMN_IMPUESTOS_MEXICANOS_DLLS = "maq_impuestos_mexicanos_dlls";
	public static final String COLUMN_FLETE_MEXICANO_PESOS = "maq_flete_mexicano_pesos";
	public static final String COLUMN_FLETE_MEXICANO_DLLS = "maq_flete_mexicano_dlls";
	public static final String COLUMN_SEGURO_PESOS = "maq_seguro_pesos";
	public static final String COLUMN_SEGURO_DLLS = "maq_seguro_dlls";
	public static final String COLUMN_OTROS_GASTOS_PESOS = "maq_otros_gastos_pesos";
	public static final String COLUMN_OTROS_GASTOS_DLLS = "maq_otros_gastos_dlls";

	public ClMaquinariaVO() {

	}

	public ClMaquinariaVO(ClMaquinariaVO clMaquinariaVO) {
		try {
			BeanUtils.copyProperties(this, clMaquinariaVO);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public int getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}

	public String getNumTransmision() {
		return numTransmision;
	}

	public void setNumTransmision(String numTransmision) {
		this.numTransmision = numTransmision;
	}

	public String getNumSerieMotor() {
		return numSerieMotor;
	}

	public void setNumSerieMotor(String numSerieMotor) {
		this.numSerieMotor = numSerieMotor;
	}

	public String getCapacidadMotor() {
		return capacidadMotor;
	}

	public void setCapacidadMotor(String capacidadMotor) {
		this.capacidadMotor = capacidadMotor;
	}

	public String getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public int getIdRancho() {
		return idRancho;
	}

	public void setIdRancho(int idRancho) {
		this.idRancho = idRancho;
	}
	
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getCostoHora1() {
		return costoHora1;
	}

	public void setCostoHora1(String costoHora1) {
		this.costoHora1 = costoHora1;
	}

	public String getCostoHora2() {
		return costoHora2;
	}

	public void setCostoHora2(String costoHora2) {
		this.costoHora2 = costoHora2;
	}

	public String getCostoHora3() {
		return costoHora3;
	}

	public void setCostoHora3(String costoHora3) {
		this.costoHora3 = costoHora3;
	}

	public String getCostoHora4() {
		return costoHora4;
	}

	public void setCostoHora4(String costoHora4) {
		this.costoHora4 = costoHora4;
	}

	public String getHorometroCompra() {
		return horometroCompra;
	}

	public void setHorometroCompra(String horometroCompra) {
		this.horometroCompra = horometroCompra;
	}

	public String getHorometroInicial() {
		return horometroInicial;
	}

	public void setHorometroInicial(String horometroInicial) {
		this.horometroInicial = horometroInicial;
	}

	public int getIdTipoCambio() {
		return idTipoCambio;
	}

	public void setIdTipoCambio(int idTipoCambio) {
		this.idTipoCambio = idTipoCambio;
	}

	public String getPedimientoImportacion() {
		return pedimientoImportacion;
	}

	public void setPedimientoImportacion(String pedimientoImportacion) {
		this.pedimientoImportacion = pedimientoImportacion;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getComprador() {
		return comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public String getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(String precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getPrecioCompraPesos() {
		return precioCompraPesos;
	}

	public void setPrecioCompraPesos(String precioCompraPesos) {
		this.precioCompraPesos = precioCompraPesos;
	}

	public String getPrecioCompraDlls() {
		return precioCompraDlls;
	}

	public void setPrecioCompraDlls(String precioCompraDlls) {
		this.precioCompraDlls = precioCompraDlls;
	}

	public String getFleteAmericanoPesos() {
		return fleteAmericanoPesos;
	}

	public void setFleteAmericanoPesos(String fleteAmericanoPesos) {
		this.fleteAmericanoPesos = fleteAmericanoPesos;
	}

	public String getFleteAmericanoDlls() {
		return fleteAmericanoDlls;
	}

	public void setFleteAmericanoDlls(String fleteAmericanoDlls) {
		this.fleteAmericanoDlls = fleteAmericanoDlls;
	}

	public String getCostoBrokerPesos() {
		return costoBrokerPesos;
	}

	public void setCostoBrokerPesos(String costoBrokerPesos) {
		this.costoBrokerPesos = costoBrokerPesos;
	}

	public String getCostoBrokerDlls() {
		return costoBrokerDlls;
	}

	public void setCostoBrokerDlls(String costoBrokerDlls) {
		this.costoBrokerDlls = costoBrokerDlls;
	}

	public String getAduanalesPesos() {
		return aduanalesPesos;
	}

	public void setAduanalesPesos(String aduanalesPesos) {
		this.aduanalesPesos = aduanalesPesos;
	}

	public String getAduanalesDlls() {
		return aduanalesDlls;
	}

	public void setAduanalesDlls(String aduanalesDlls) {
		this.aduanalesDlls = aduanalesDlls;
	}

	public String getImpuestosMexicanosPesos() {
		return impuestosMexicanosPesos;
	}

	public void setImpuestosMexicanosPesos(String impuestosMexicanosPesos) {
		this.impuestosMexicanosPesos = impuestosMexicanosPesos;
	}

	public String getImpuestosMexicanosDlls() {
		return impuestosMexicanosDlls;
	}

	public void setImpuestosMexicanosDlls(String impuestosMexicanosDlls) {
		this.impuestosMexicanosDlls = impuestosMexicanosDlls;
	}

	public String getFleteMexicanoPesos() {
		return fleteMexicanoPesos;
	}

	public void setFleteMexicanoPesos(String fleteMexicanoPesos) {
		this.fleteMexicanoPesos = fleteMexicanoPesos;
	}

	public String getFleteMexicanoDlls() {
		return fleteMexicanoDlls;
	}

	public void setFleteMexicanoDlls(String fleteMexicanoDlls) {
		this.fleteMexicanoDlls = fleteMexicanoDlls;
	}

	public String getSeguroPesos() {
		return seguroPesos;
	}

	public void setSeguroPesos(String seguroPesos) {
		this.seguroPesos = seguroPesos;
	}

	public String getSeguroDlls() {
		return seguroDlls;
	}

	public void setSeguroDlls(String seguroDlls) {
		this.seguroDlls = seguroDlls;
	}

	public String getOtrosGastosPesos() {
		return otrosGastosPesos;
	}

	public void setOtrosGastosPesos(String otrosGastosPesos) {
		this.otrosGastosPesos = otrosGastosPesos;
	}

	public String getOtrosGastosDlls() {
		return otrosGastosDlls;
	}

	public void setOtrosGastosDlls(String otrosGastosDlls) {
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

}
