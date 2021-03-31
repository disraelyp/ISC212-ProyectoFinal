package logic;

public class DiscoDuro extends Componente{
	private float capacidad; //MB
	private int tipo; // 1: IDE, 2: SATA, 3: SATA-2, 4: SATA-3
	
	public DiscoDuro(String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo,
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
