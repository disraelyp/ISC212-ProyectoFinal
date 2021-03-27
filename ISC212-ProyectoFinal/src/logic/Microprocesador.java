package logic;

public class Microprocesador extends Componente{
	
	private String conexion;
	private float velocidad; //MHZ
	
	public Microprocesador(String serie, String modelo, String marca, int cantidad, float precio, float costo,
			String conexion, float velocidad) {
		super(serie, modelo, marca, cantidad, precio, costo);
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
