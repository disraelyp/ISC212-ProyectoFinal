package logic;

import java.util.ArrayList;
import java.util.Date;

public class CotizacionInventario extends OrdenInventario {
	
	private static int idCotizacion=1;
	private String codigo;

	public CotizacionInventario(Proveedor proveedor, Date fecha, Administrador administrador, int plazoPago, ArrayList<Componente> componentes) {
		super(proveedor, fecha, administrador, plazoPago, componentes);
		this.codigo = "P-"+idCotizacion;
		idCotizacion++;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
		
}
