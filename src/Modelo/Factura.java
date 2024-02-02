package Modelo;

public class Factura {
	
	private String fecha, nombre, apellidos, por_pagar;

	public Factura(String fecha, String nombre, String apellidos, String por_pagar) {
		super();
		this.fecha = fecha;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.por_pagar = por_pagar;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPor_pagar() {
		return por_pagar;
	}

	public void setPor_pagar(String por_pagar) {
		this.por_pagar = por_pagar;
	}
}