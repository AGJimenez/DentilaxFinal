package Modelo;

public class Doctor {

	private String nombre, apellidos, telefono, correo, fecha, especialidad, dniPaciente;
	

	public Doctor(String fecha, String especialidad, String dniPaciente) {
		super();
		this.fecha = fecha;
		this.especialidad = especialidad;
		this.dniPaciente = dniPaciente;
	}
	
	public Doctor(String nombre, String apellidos, String especialidad, String telefono, String correo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.especialidad = especialidad;
		this.telefono = telefono;
		this.correo = correo;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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
