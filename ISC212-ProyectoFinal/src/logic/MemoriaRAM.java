package logic;

public class MemoriaRAM extends Componente{
	
	private float capacidad; //GB
	private int tipo; //1: DDR, 2: DDR2, 3: DDR3
	private int frecuencia; //MHz
	
	public MemoriaRAM(String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo,
			float capacidad, int tipo, int frecuencia) {
		super(modelo, marca, cantidad, cantidadMinima, precio, costo);
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.frecuencia = frecuencia;
	}
	
	public float getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	
}
