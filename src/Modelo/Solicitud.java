package Modelo;

import java.util.Date;

public class Solicitud {

	private int id_solicitud, cantidad;
	private String dni_doctor, nombre_producto, fecha, estado;
	

	public Solicitud(int id_solicitud, String nombre_producto, String dni_doctor, int cantidad, String fecha, String estado) {
		super();
		this.id_solicitud = id_solicitud;
		this.nombre_producto = nombre_producto;
		this.dni_doctor = dni_doctor;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.estado = estado;
	}


	public int getId_solicitud() {
		return id_solicitud;
	}


	public void setId_solicitud(int id_solicitud) {
		this.id_solicitud = id_solicitud;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getDni_doctor() {
		return dni_doctor;
	}


	public void setDni_doctor(String dni_doctor) {
		this.dni_doctor = dni_doctor;
	}


	public String getNombre_producto() {
		return nombre_producto;
	}


	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Solicitud [id_solicitud=" + id_solicitud + ", cantidad=" + cantidad + ", dni_doctor=" + dni_doctor
				+ ", nombre_producto=" + nombre_producto + ", estado=" + estado + ", fecha=" + fecha + "]";
	}
	
	
	
}
