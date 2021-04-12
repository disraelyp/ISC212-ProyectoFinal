package logic;

import java.util.ArrayList;
import java.util.Date;

public class DevolucionInventario extends OrdenInventario {
	
	private boolean retirada;
	
	public DevolucionInventario(Proveedor proveedor, Date fecha, Administrador administrador, int plazoPago, ArrayList<Componente> componentes) {
		super(proveedor, fecha, administrador, plazoPago, componentes);
		this.retirada = false;
	}
	
	public boolean isRetirada() {
		return retirada;
	}
	public void setRetirada(boolean retirada) {
		this.retirada = retirada;
	}
}
