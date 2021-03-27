package logic;

import java.util.ArrayList;

public class Compra {
	private String codigo;
	private Proveedor proovedor;
	private Administrador administrador;
	private ArrayList<Componente> componentes;
	private boolean estado;
	
	public Compra(String codigo, Proveedor proovedor, Administrador administrador, ArrayList<Componente> componentes) {
		super();
		this.codigo = codigo;
		this.proovedor = proovedor;
		this.administrador = administrador;
		this.componentes = componentes;
		this.estado = false;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Proveedor getProv() {
		return proovedor;
	}
	public void setProovedor(Proveedor prov) {
		this.proovedor = prov;
	}
	public Administrador getAdministrador() {
		return administrador;
	}
	public void setAdmin(Administrador administrador) {
		this.administrador = administrador;
	}
	public ArrayList<Componente> getComponentes() {
		return componentes;
	}
	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
