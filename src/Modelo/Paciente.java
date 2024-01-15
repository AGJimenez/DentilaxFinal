package Modelo;

public class Paciente {

	private String fecha, tratamiento, dni_dr, nombre, apellidos, observaciones, seguro;

	public Paciente(String fecha, String tratamiento, String dni_dr) {
		super();
		this.fecha = fecha;
		this.tratamiento = tratamiento;
		this.dni_dr = dni_dr;
	}
	public Paciente(String nombre, String apellidos, String observaciones, String seguro) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.observaciones = observaciones;
		this.seguro = seguro;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public String getDni_dr() {
		return dni_dr;
	}

	public void setDni_dr(String dni_dr) {
		this.dni_dr = dni_dr;
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
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getSeguro() {
		return seguro;
	}
	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}
	@Override
	public String toString() {
		return "Paciente [fecha=" + fecha + ", tratamiento=" + tratamiento + ", dni_dr=" + dni_dr + "]";
	}


	
	
}
