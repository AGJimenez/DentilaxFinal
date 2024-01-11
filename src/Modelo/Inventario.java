package Modelo;

public class Inventario {

	private String id, producto, cantidad;

	public Inventario(String id, String producto, String cantidad) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + "]";
	}


	
	
}
