package logic;

public class Componente extends Producto{
	
	private static int idComponente=0;
	
	protected String codigo;
	protected String modelo;
	protected String marca;
	protected int cantidadMinima;
	protected float precio;
	protected float costo;
	
	public Componente(String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo) {
		super("C-"+idComponente, cantidad);
		idComponente++;
		this.modelo = modelo;
		this.marca = marca;
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
	public int getCantidadMinima() {
		return cantidadMinima;
	}
	public void setCantidadMinima(int cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}

	@Override
	public float getPrecio() {
		return precio;
	}
	@Override
	public float getCosto() {
		return costo;
	}
}
