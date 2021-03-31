package logic;

public class Componente {
	
	private static int idComponente=0;
	
	protected String codigo;
	protected String modelo;
	protected String marca;
	protected int cantidad;
	protected int cantidadMinima;
	protected float precio;
	protected float costo;
	
	
	public Componente(String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo) {
		super();
		this.codigo = "C-"+idComponente;
		idComponente++;
		this.modelo = modelo;
		this.marca = marca;
		this.cantidad = cantidad;
		this.cantidadMinima = cantidadMinima;
		this.precio = precio;
		this.costo = costo;
	}


	public String getCodigo() {
		return codigo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCantidadMinima() {
		return cantidadMinima;
	}
	public void setCantidadMinima(int cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public float getCosto() {
		return costo;
	}


	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	
	
	
	
}
