package logic;

import java.util.ArrayList;
import java.util.Date;

public class FacturaVenta extends OrdenVenta {

	private boolean pagada;
	
	public FacturaVenta(Cliente cliente, Empleado empleado, Date fecha, int plazoPago, ArrayList<Producto> productos) {
		super(cliente, empleado, fecha, plazoPago, productos);
		this.pagada = false;
	}
	public boolean isPagada() {
		return pagada;
	}
	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}

}
