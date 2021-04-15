package logic;

import java.util.Date;
import java.util.ArrayList;

public class DevolucionVenta extends OrdenVenta{
	
	private boolean recibida;
	
	public DevolucionVenta(Cliente cliente, Empleado empleado, Date fecha, int plazoPago, ArrayList<Producto> productos) {
		super(cliente, empleado, fecha, plazoPago, productos);
		this.recibida = false;
	}
	public boolean isRecibida() {
		return recibida;
	}
	public void setRecibida(boolean retirada) {
		this.recibida = retirada;
	}
}
