package logic;

public class Componente {
	
	protected String serie;
	protected String modelo;
	protected String marca;
	protected int cantidad;
	protected float precio;
	protected float costo;
	
	public Componente(String serie, String modelo, String marca, int cantidad, float precio, float costo) {
		super();
		this.serie = serie;
		this.modelo = modelo;
		this.marca = marca;
		this.cantidad = cantidad;
		this.precio = precio;
		this.costo = costo;
	}

	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
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
