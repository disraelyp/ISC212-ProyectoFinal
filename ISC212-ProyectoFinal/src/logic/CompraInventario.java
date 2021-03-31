package logic;

import java.util.ArrayList;

public class CompraInventario extends OrdenInventario {
	private static int idCompra=1;
	private String codigo;
	private boolean pagada;
	private boolean recibida;
	
	public CompraInventario(Proveedor proveedor, Administrador administrador, ArrayList<Componente> componentes) {
		super(proveedor, administrador, componentes);
		this.codigo = "C-"+idCompra;
		this.pagada = false;
		this.recibida = false;
		idCompra++;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
