package logic;

import java.io.Serializable;

public class Proveedor implements Serializable {
	
	private static final long serialVersionUID =1L;
	private String rnc;
	private String nombre;
	private String telefono;
	private String direccion;
	private String nombreRepre;
	private String telefonoRepre;
	
	public Proveedor(String rnc, String nombre, String telefono, String direccion, String nombreRepre, String telefonoRepre) {
		super();
		this.rnc = rnc;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nombreRepre = nombreRepre;
		this.telefonoRepre = telefonoRepre;
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
	public String getNombreRepre() {
		return nombreRepre;
	}
	public void setNombreRepre(String nombreRepre) {
		this.nombreRepre = nombreRepre;
	}
	public String getTelefonoRepre() {
		return telefonoRepre;
	}
	public void setTelefonoRepre(String telefonoRepre) {
		this.telefonoRepre = telefonoRepre;
	}
	
	
}
