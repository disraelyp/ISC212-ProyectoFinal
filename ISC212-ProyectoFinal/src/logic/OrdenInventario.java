package logic;

import java.util.ArrayList;

public class OrdenInventario {
	protected Proveedor proveedor;
	protected Administrador administrador;
	protected ArrayList<Componente> componentes;
	
	public OrdenInventario(Proveedor proveedor, Administrador administrador, ArrayList<Componente> componentes) {
		super();
		this.proveedor = proveedor;
		this.administrador = administrador;
		this.componentes = componentes;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Administrador getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	public ArrayList<Componente> getComponentes() {
		return componentes;
	}
	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
	
	public float getCostoTotal() {
		float costoTotal=0;
		for(Componente x: componentes) {
			costoTotal+=x.getCosto();
		}
		return costoTotal;
	}

}
