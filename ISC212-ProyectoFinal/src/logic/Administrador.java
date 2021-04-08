package logic;

import java.io.Serializable;

public class Administrador extends Empleado implements Serializable{

	private static final long serialVersionUID =1L;
	private int cantidadCompras;

	public Administrador(String cedula, String nombre, String telefono, String direccion, float sueldo,
			float comision, String usuario, String contraseña) {
		super(cedula, nombre, telefono, direccion, sueldo, comision, usuario, contraseña);
		this.cantidadCompras = 0;
		super.setCodigo("A-"+(super.getIdEmpleado()-1));
	}
	public int getCantidadCompras() {
		return cantidadCompras;
	}
	public void setCantidadCompras(int cantidadCompras) {
		this.cantidadCompras = cantidadCompras;
	}	
	
}
