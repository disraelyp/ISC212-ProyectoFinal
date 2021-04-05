package logic;

import java.io.Serializable;

public class Proveedor implements Serializable {
	
	private static final long serialVersionUID =1L;
	private String rnc;
	private String nombre;
	private String telefono;
	private String direccion;
	private Persona representante;
	
	public Proveedor(String rnc, String nombre, String telefono, String direccion, Persona representante) {
		super();
		this.rnc = rnc;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.representante = representante;
	}

	public String getRnc() {
		return rnc;
	}
	public void setRnc(String rnc) {
		this.rnc = rnc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Persona getRepresentante() {
		return representante;
	}
	public void setRepresentante(Persona representante) {
		this.representante = representante;
	}
	
	
}
