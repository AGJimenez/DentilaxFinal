package Modelo;

public class Paciente {

	private String nombre, seguro, DNI_paciente;

	public Paciente(String nombre, String seguro, String dNI_paciente) {
		super();
		this.nombre = nombre;
		this.seguro = seguro;
		DNI_paciente = dNI_paciente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSeguro() {
		return seguro;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	public String getDNI_paciente() {
		return DNI_paciente;
	}

	public void setDNI_paciente(String dNI_paciente) {
		DNI_paciente = dNI_paciente;
	}

	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", seguro=" + seguro + ", DNI_paciente=" + DNI_paciente + "]";
	}


	
	
}
