package Modelo;

public class Doctor {

	private String nombre,especialidad,dniDoctor;

	public Doctor(String fecha, String especialidad, String dniDoctor) {
		super();
		this.nombre = fecha;
		this.especialidad = especialidad;
		this.dniDoctor = dniDoctor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String fecha) {
		this.nombre = fecha;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getDniDoctor() {
		return dniDoctor;
	}

	public void setDniDoctor(String dniDoctor) {
		this.dniDoctor = dniDoctor;
	}

	@Override
	public String toString() {
		return "Doctor [nombre=" + nombre + ", especialidad=" + especialidad + ", dniDoctor=" + dniDoctor + "]";
	}
	
	
}
