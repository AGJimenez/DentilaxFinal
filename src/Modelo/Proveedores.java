package Modelo;

public class Proveedores {
	
	private int id_proveedor;
	private String proveedor;
	private String producto;
	private int precio;
	
	public Proveedores(int id_proveedor, String proveedor, String producto, int precio) {
		super();
		this.id_proveedor = id_proveedor;
		this.proveedor = proveedor;
		this.producto = producto;	
		this.precio = precio;
		
	}

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Proveedores [id_proveedor=" + id_proveedor + ", proveedor=" + proveedor + ", producto="
				+ producto + ", precio=" + precio + "]";
	}	
}
