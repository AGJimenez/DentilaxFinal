package Modelo;

public class Proveedores {
	
	private int id_proveedor;
	private String proveedor;
	private int precio_producto;
	
	public Proveedores(int id_proveedor, String proveedor, int precio_producto) {
		super();
		this.id_proveedor = id_proveedor;
		this.proveedor = proveedor;
		this.precio_producto = precio_producto;		
		
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

	public int getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(int precio_producto) {
		this.precio_producto = precio_producto;
	}

	@Override
	public String toString() {
		return "Proveedores [id_proveedor=" + id_proveedor + ", proveedor=" + proveedor + ", precio_producto="
				+ precio_producto + "]";
	}	
}
