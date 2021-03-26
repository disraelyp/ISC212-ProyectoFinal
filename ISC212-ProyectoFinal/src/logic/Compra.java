package logic;

import java.util.ArrayList;

public class Compra {
	private String codigo;
	private Proveedor prov;
	private Administrador admin;
	private ArrayList<Componente> componentes;
	private boolean estado;
	
	public Compra(String codigo, Proveedor prov, Administrador admin, ArrayList<Componente> componentes,
			boolean estado) {
		super();
		this.codigo = codigo;
		this.prov = prov;
		this.admin = admin;
		this.componentes = componentes;
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Proveedor getProv() {
		return prov;
	}

	public void setProv(Proveedor prov) {
		this.prov = prov;
	}

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
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
