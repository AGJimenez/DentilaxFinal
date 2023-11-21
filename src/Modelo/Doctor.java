package Modelo;

public class Doctor {

	private String fecha,especialidad,dniPaciente;

	public Doctor(String fecha, String especialidad, String dniPaciente) {
		super();
		this.fecha = fecha;
		this.especialidad = especialidad;
		this.dniPaciente = dniPaciente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setfecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getDniPaciente() {
		return dniPaciente;
	}

	public void setDniPaciente(String dniPaciente) {
		this.dniPaciente = dniPaciente;
	}

	@Override
	public String toString() {
		return "Doctor [fecha=" + fecha + ", especialidad=" + especialidad + ", dniPaciente=" + dniPaciente + "]";
	}

	
}
