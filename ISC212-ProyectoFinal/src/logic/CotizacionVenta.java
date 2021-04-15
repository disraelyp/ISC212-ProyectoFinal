package logic;

import java.util.ArrayList;
import java.util.Date;

public class CotizacionVenta extends OrdenVenta{

	public CotizacionVenta(Cliente cliente, Empleado empleado, Date fecha, int plazoPago, ArrayList<Producto> productos) {
		super(cliente, empleado, fecha, plazoPago, productos);
	}
	
}
