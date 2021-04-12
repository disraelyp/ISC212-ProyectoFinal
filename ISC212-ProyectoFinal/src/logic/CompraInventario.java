package logic;

import java.util.ArrayList;
import java.util.Date;

public class CompraInventario extends OrdenInventario {
	
	private boolean pagada;
	private boolean recibida;

	public CompraInventario(Proveedor proveedor, Date fecha, Administrador administrador, int plazoPago, ArrayList<Componente> componentes) {
		super(proveedor, fecha, administrador, plazoPago, componentes);
		this.pagada = false;
		this.recibida = false;
	}

	public boolean isPagada() {
		return pagada;
	}
	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}
	public boolean isRecibida() {
		return recibida;
	}
	public void setRecibida(boolean recibida) {
		this.recibida = recibida;
	}
}
