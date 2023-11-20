package Modelo;

public class Paciente {

	private String fecha, tratamiento, dni_dr;

	public Paciente(String fecha, String tratamiento, String dni_dr) {
		super();
		this.fecha = fecha;
		this.tratamiento = tratamiento;
		this.dni_dr = dni_dr;
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

	@Override
	public String toString() {
		return "Paciente [fecha=" + fecha + ", tratamiento=" + tratamiento + ", dni_dr=" + dni_dr + "]";
	}


	
	
}
