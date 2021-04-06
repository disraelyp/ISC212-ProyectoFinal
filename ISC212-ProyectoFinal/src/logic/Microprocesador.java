package logic;

public class Microprocesador extends Componente{
	
	private int conexion;
	private float velocidad; //MHZ
	private int nucleos;
	
	public Microprocesador(String codigo, String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo,
			int conexion, float velocidad, int nucleos) {
		super(codigo, modelo, marca, cantidad, cantidadMinima, precio, costo);
		this.conexion = conexion;
		this.velocidad = velocidad;
		this.nucleos = nucleos;
	}
	
	public int getConexion() {
		return conexion;
	}
	public void setConexion(int conexion) {
		this.conexion = conexion;
	}
	public float getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
	public int getNucleos() {
		return nucleos;
	}
	public void setNucleos(int nucleos) {
		this.nucleos = nucleos;
	}	
}
