package logic;

import java.io.Serializable;

public abstract class Producto implements Serializable {
	
	private static final long serialVersionUID =1L;
	private static int idProducto=1;
	
	protected String codigo;
	protected int cantidad;
	
	public Producto(String codigo, int cantidad) {
		super();
		this.codigo = codigo+idProducto;
		this.cantidad = cantidad;
		idProducto++;
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
