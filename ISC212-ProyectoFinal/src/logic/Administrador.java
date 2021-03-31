package logic;

public class Administrador extends Empleado{

	private int cantidadCompras;

	public Administrador(String cedula, String nombre, String telefono, String direccion, String codigo, float sueldo,
			float comision, int cantidadVentas, String usuario, String contraseña, int cantidadCompras) {
		super(cedula, nombre, telefono, direccion, codigo, sueldo, comision, cantidadVentas, usuario, contraseña);
		this.cantidadCompras = cantidadCompras;
	}

	public int getCantidadCompras() {
		return cantidadCompras;
	}
	public void setCantidadCompras(int cantidadCompras) {
		this.cantidadCompras = cantidadCompras;
	}	
	
}
