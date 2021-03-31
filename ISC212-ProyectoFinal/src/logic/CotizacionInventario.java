package logic;

import java.util.ArrayList;

public class CotizacionInventario extends OrdenInventario {
	
	private static int idCotizacion=1;
	private String codigo;
	
	public CotizacionInventario(Proveedor proveedor, Administrador administrador, ArrayList<Componente> componentes) {
		super(proveedor, administrador, componentes);
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
