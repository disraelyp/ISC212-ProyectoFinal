package logic;

import java.util.ArrayList;
import java.util.Date;

public class CotizacionInventario extends OrdenInventario {
	public CotizacionInventario(Proveedor proveedor, Date fecha, Administrador administrador, int plazoPago, ArrayList<Componente> componentes) {
		super(proveedor, fecha, administrador, plazoPago, componentes);
	}
}
