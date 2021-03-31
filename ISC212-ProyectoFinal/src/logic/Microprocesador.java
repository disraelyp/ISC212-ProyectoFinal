package logic;

public class Microprocesador extends Componente{
	
	private String conexion;
	private float velocidad; //MHZ
	
	public Microprocesador(String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo,
			String conexion, float velocidad) {
		super(modelo, marca, cantidad, cantidadMinima, precio, costo);
		this.conexion = conexion;
		this.velocidad = velocidad;
	}
	
	public String getConexion() {
		return conexion;
	}
	public void setConexion(String conexion) {
		this.conexion = conexion;
	}
	public float getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
	
}
