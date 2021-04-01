package logic;

public abstract class Producto {
	
	protected String codigo;
	protected int cantidad;
	
	public Producto(String codigo, int cantidad) {
		super();
		this.codigo = codigo;
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
