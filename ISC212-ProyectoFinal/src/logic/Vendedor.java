package logic;

public class Vendedor extends Empleado{
	//Padre: Empleado
	private int cantVentas;
	private float comisionVentas;
	
	public Vendedor(String cedula, String nombre, String telefono, String direccion, String codigo, float sueldoBase,
			int horasExtra, int cantVentas, float comisionVentas) {
		super(cedula, nombre, telefono, direccion, codigo, sueldoBase, horasExtra);
		this.cantVentas = cantVentas;
		this.comisionVentas = comisionVentas;
	}

	public int getCantVentas() {
		return cantVentas;
	}

	public void setCantVentas(int cantVentas) {
		this.cantVentas = cantVentas;
	}

	public float getComisionVentas() {
		return comisionVentas;
	}

	public void setComisionVentas(float comisionVentas) {
		this.comisionVentas = comisionVentas;
	}
	
	
}
