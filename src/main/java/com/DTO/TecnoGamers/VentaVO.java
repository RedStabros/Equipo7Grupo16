package com.DTO.TecnoGamers;

import java.io.Serializable;

public class VentaVO implements Serializable {
	
	//identificador unico de las clases entidad
		private static final long serialVersionUID = 1L;
		
		private Integer codigo_venta;
		private Integer cedula_c;
		private Integer cedula_usuario;
		private Double ivaventa;
		private Double total_venta;
		private Double valor_venta;
		
		
		public Integer getCodigo_venta() {
			return codigo_venta;
		}
		public void setCodigo_venta(Integer codigo_venta) {
			this.codigo_venta = codigo_venta;
		}
		public Integer getCedula_c() {
			return cedula_c;
		}
		public void setCedula_c(Integer cedula_c) {
			this.cedula_c = cedula_c;
		}
		public Integer getCedula_usuario() {
			return cedula_usuario;
		}
		public void setCedula_usuario(Integer cedula_usuario) {
			this.cedula_usuario = cedula_usuario;
		}
		public Double getIvaventa() {
			return ivaventa;
		}
		public void setIvaventa(Double ivaventa) {
			this.ivaventa = ivaventa;
		}
		public Double getTotal_venta() {
			return total_venta;
		}
		public void setTotal_venta(Double total_venta) {
			this.total_venta = total_venta;
		}
		public Double getValor_venta() {
			return valor_venta;
		}
		public void setValor_venta(Double valor_venta) {
			this.valor_venta = valor_venta;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
				
		
}



/*
public class VentaVO {
	Long codigo_venta;
	Long cedula_c;
	Long cedula_usuario;
	Double ivaventa;
	Double total_venta;
	Double valor_venta;
	Long codigo_producto;
	Long cantidad_producto;
	Long codigo_detalle_venta;
	String numerofactura;
	String nombre_producto;
	Double subtotal;
	String estado;
	
	public VentaVO(){
		
	}
	
	public VentaVO(Long codigo_venta, Long cedula_c, Long cedula_usuario, Double ivaventa, Double total_venta,
			Double valor_venta, Long codigo_producto, Long cantidad_producto, Long codigo_detalle_venta,
			String numerofactura, String nombre_producto, Double subtotal, String estado) {
		super();
		this.codigo_venta = codigo_venta;
		this.cedula_c = cedula_c;
		this.cedula_usuario = cedula_usuario;
		this.ivaventa = ivaventa;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
		this.codigo_producto = codigo_producto;
		this.cantidad_producto = cantidad_producto;
		this.codigo_detalle_venta = codigo_detalle_venta;
		this.numerofactura = numerofactura;
		this.nombre_producto = nombre_producto;
		this.subtotal = subtotal;
		this.estado = estado;
	}

	public Long getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public Long getCedula_c() {
		return cedula_c;
	}

	public void setCedula_c(Long cedula_c) {
		this.cedula_c = cedula_c;
	}

	public Long getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(Long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public Double getIvaventa() {
		return ivaventa;
	}

	public void setIvaventa(Double ivaventa) {
		this.ivaventa = ivaventa;
	}

	public Double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(Double total_venta) {
		this.total_venta = total_venta;
	}

	public Double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public Long getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public Long getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(Long cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public Long getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}

	public void setCodigo_detalle_venta(Long codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}

	public String getNumerofactura() {
		return numerofactura;
	}

	public void setNumerofactura(String numerofactura) {
		this.numerofactura = numerofactura;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}*/
