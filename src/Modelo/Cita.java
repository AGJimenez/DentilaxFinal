package Modelo;

public class Cita {
	
	private String fecha,especialidad,dniPaciente;

	public Cita(String fecha, String especialidad, String dniPaciente) {
		super();
		this.fecha = fecha;
		this.especialidad = especialidad;
		this.dniPaciente = dniPaciente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
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
		return "Historial [fecha=" + fecha + ", especialidad=" + especialidad + ", dniPaciente=" + dniPaciente + "]";
	}
	
	

}