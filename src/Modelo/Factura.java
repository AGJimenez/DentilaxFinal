package Modelo;

public class Factura {
	
	private String id, fecha, nombre, apellidos, por_pagar, pagado, DNI_paciente;

	public Factura(String fecha, String nombre, String apellidos, String por_pagar, String id, String pagado, String DNI_paciente) {
		super();
		this.fecha = fecha;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.por_pagar = por_pagar;
		this.id = id;
		this.pagado = pagado;
		this.DNI_paciente = DNI_paciente;
	}
	
	public Factura(String fecha, String DNI_paciente, String pagado, String por_pagar) {
		super();
		this.fecha = fecha;
		this.DNI_paciente = DNI_paciente;
		this.pagado = pagado;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPagado() {
		return pagado;
	}

	public void setPagado(String pagado) {
		this.pagado = pagado;
	}

	public String getDNI_paciente() {
		return DNI_paciente;
	}

	public void setDNI_paciente(String dNI_paciente) {
		DNI_paciente = dNI_paciente;
	}
}