package logic;

import java.util.ArrayList;
import java.util.Date;

public class CotizacionInventario extends OrdenInventario {
	
	private static int idCotizacion=1;

	public CotizacionInventario(Proveedor proveedor, Date fecha, Administrador administrador, int plazoPago, ArrayList<Componente> componentes) {
		super("P-"+idCotizacion, proveedor, fecha, administrador, plazoPago, componentes);
		idCotizacion++;
	}
		
}
