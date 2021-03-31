package logic;

public class MemoriaRAM extends Componente{
	
	private float capacidad; //MB
	private int tipo; //1: DDR, 2: DDR2, 3: DDR3
	
	public MemoriaRAM(String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo,
			float capacidad, int tipo) {
		super(modelo, marca, cantidad, cantidadMinima, precio, costo);
		this.capacidad = capacidad;
		this.tipo = tipo;
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
	
}
