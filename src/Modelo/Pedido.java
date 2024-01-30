package Modelo;

import java.util.Date;

public class Pedido {

	private int id_pedido;
	private String nombre_producto, fecha;
	

	public Pedido(int id_pedido, String nombre_producto, String fecha) {
		super();
		this.id_pedido = id_pedido;
		this.nombre_producto = nombre_producto;
		this.fecha = fecha;
	}


	public int getId_pedido() {
		return id_pedido;
	}


	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}


	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	
	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Solicitud [id_pedido=" + id_pedido +", nombre_producto=" + nombre_producto + ", fecha=" + fecha + "]";
	}
	
	
	
}
