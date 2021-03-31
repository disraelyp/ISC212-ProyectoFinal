package logic;

import java.util.ArrayList;
import java.util.Date;

public class DevolucionInventario extends OrdenInventario {
	
	private static int idDevolucion=1;
	private String codigo;
	private boolean retirada;
	
	public DevolucionInventario(Proveedor proveedor, Date fecha, Administrador administrador, int plazoPago, ArrayList<Componente> componentes) {
		super(proveedor, fecha, administrador, plazoPago, componentes);
		this.codigo = "D-"+idDevolucion;
		this.retirada = false;
		idDevolucion++;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public boolean isRetirada() {
		return retirada;
	}
	public void setRetirada(boolean retirada) {
		this.retirada = retirada;
	}
}
