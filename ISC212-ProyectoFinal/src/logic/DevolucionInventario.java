package logic;

import java.util.ArrayList;
import java.util.Date;

public class DevolucionInventario extends OrdenInventario {
	
	private static int idDevolucion=1;
	private boolean retirada;
	
	public DevolucionInventario(Proveedor proveedor, Date fecha, Administrador administrador, int plazoPago, ArrayList<Componente> componentes) {
		super("D-"+idDevolucion, proveedor, fecha, administrador, plazoPago, componentes);
		this.retirada = false;
		idDevolucion++;
	}
	
	public boolean isRetirada() {
		return retirada;
	}
	public void setRetirada(boolean retirada) {
		this.retirada = retirada;
	}
}
