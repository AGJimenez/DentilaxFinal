package Modelo;

import java.sql.Date;

public class Odontograma {

	
	private int id_diente;
	private String observaciones;
	private Date fecha;
	
	public Odontograma(int id_diente, String observaciones, Date fecha) {
		super();
		this.id_diente = id_diente;
		this.observaciones = observaciones;
		this.fecha = fecha;
	}

	public int getId_diente() {
		return id_diente;
	}

	public void setId_diente(int id_diente) {
		this.id_diente = id_diente;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Odontograma [id_diente=" + id_diente + ", observaciones=" + observaciones + ", fecha=" + fecha + "]";
	}


	
	
}
