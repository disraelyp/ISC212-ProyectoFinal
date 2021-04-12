package logic;

import java.io.Serializable;

public abstract class Producto implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	protected String codigo;
	protected int cantidad;
	
	public Producto(int cantidad) {
		super();
		this.codigo = "P-"+Tienda.getInstance().getProductos().size();
		this.cantidad = cantidad;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public abstract float getPrecio();
	public abstract float getCosto();
}
